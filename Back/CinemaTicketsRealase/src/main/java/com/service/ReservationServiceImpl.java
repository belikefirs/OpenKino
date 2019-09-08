package com.service;

import com.masks.ReservationMask;
import com.dao.*;
import com.enums.Pstatus;
import com.enums.RStatus;
import com.models.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
    private List<Place> placesIsReservation;
    private ReservationDao reservationDao;
    private PlaceDao placeDao;
    private KinoUserDao kinoUserDao;
    private DiscountDao discountDao;
    private BuyDao buyDao;
    private SessionDao sessionDao;
    public ReservationServiceImpl(ReservationDao reservationDao, PlaceDao placeDao,
                                  KinoUserDao kinoUserDao, DiscountDao discountDao, BuyDao buyDao, SessionDao sessionDao){
        this.reservationDao = reservationDao;
        this.placeDao = placeDao;
        this.kinoUserDao = kinoUserDao;
        this.discountDao = discountDao;
        this.buyDao = buyDao;
        this.sessionDao = sessionDao;
    }
    @Override
    public Long saveReservation(Reservation reservation) {
        return reservationDao.save(reservation).getId();

    }


    @Override
    public void deleteReservationById(Long id) {
        reservationDao.deleteById(id);
    }

    @Override
    public Long saveDiscount(Discount discount) {
        return discountDao.save(discount).getId();
    }

    @Override
    public void deleteDiscountById(Long id) {
        discountDao.deleteById(id);
    }

    @Override
    public Long updateReservation(Reservation reservation, Long id, int Status) {
        Reservation reservation1 = reservationDao.findById(id).get();
        reservation1.setBuy(reservation.getBuy());
        reservation1.setStart(LocalDateTime.now());
        reservation1.setEnd(reservation.getEnd());
        reservation1.setPlaces(reservation.getPlaces());
        if(Status == 0){
            reservation1.setStatus(RStatus.IsAlive);
        } else if(Status == 1){
            reservation1.setStatus(RStatus.IsNotAlive);
        } else if(Status == 2){
            reservation1.setStatus(RStatus.isBuy);
        }
        return reservationDao.save(reservation1).getId();
    }

    @Override
    public Long saveAllReservation(ReservationMask reservationMask, KinoUser kinoUser) {
        KinoUser kinoUser1 = kinoUserDao.findById(kinoUser.getId()).get();
        Reservation reservation = new Reservation();
        reservation.setStart(LocalDateTime.now(ZoneId.of("UTC+4")));
        reservation.setEnd(sessionDao.getBeginSession(reservationMask.getIdSess()).minusHours(1));
        reservation.setKinoUser(kinoUser1);
        BigDecimal resultPrice = new BigDecimal("0");
        Long id = reservationDao.save(reservation).getId();
        Reservation r = reservationDao.findById(id).get();
        for(int i = 0; i < reservationMask.getPlaces().size(); i++){
            reservationMask.getPlaces().get(i).setStatus(Pstatus.IsReservation);
            reservationMask.getPlaces().get(i).setReservation(r);
            placeDao.save(reservationMask.getPlaces().get(i));
            resultPrice.add(reservationMask.getPlaces().get(i).getPrice());
        }
        r.setPlaces(reservationMask.getPlaces());
        r.setPrice(resultPrice);
        return reservationDao.save(r).getId();
    }

    @Override
    public List<Place> getPlacesWithReservationId(Long id) {
        return placeDao.getFindbyIdReservaion(id);
    }

    @Override
    public List<Reservation> getFindByIdKinoUser(Long idKinU) {
        return reservationDao.getFindByIdKinoUser(idKinU);
    }

    @Override
    public Reservation getFindById(Long id) {
        Reservation reservation = reservationDao.findById(id).get();
        reservation.getPlaces().size();
        return reservation;
    }
    @Override
    public Long changeStatusReservation(Long id, Integer status) {
        Reservation reservation = reservationDao.findById(id).get();
        if(status == 0){
            reservation.setStatus(RStatus.IsNotAlive);
        } else if(status == 1){
            reservation.setStatus(RStatus.IsAlive);
        } else if(status == 2){
            reservation.setStatus(RStatus.isBuy);
        }
        return reservationDao.save(reservation).getId() ;
    }

    @Override
    public List<Place> getPlacesForReservation(List<Place> places, Long idPlace) {
        places.add(placeDao.findById(idPlace).get());
        return places;
    }

    @Override
    public List<Place> deletePlaceFromList(List<Place> places, Long idPlace) {
        places.remove(placeDao.findById(idPlace).get());
        return places;
    }
}
