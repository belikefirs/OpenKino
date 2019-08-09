package com.service;

import com.dao.*;
import com.models.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
    private ReservationDao reservationDao;
    private PlaceDao placeDao;
    private KinoUserDao kinoUserDao;
    private DiscountDao discountDao;
    private BuyDao buyDao;
    public ReservationServiceImpl(ReservationDao reservationDao, PlaceDao placeDao,
                                  KinoUserDao kinoUserDao, DiscountDao discountDao, BuyDao buyDao){
        this.reservationDao = reservationDao;
        this.placeDao = placeDao;
        this.kinoUserDao = kinoUserDao;
        this.discountDao = discountDao;
        this.buyDao = buyDao;
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
    public Long updateReservation(Reservation reservation, Long id) {
        Reservation reservation1 = reservationDao.findById(id).get();
        reservation1.setKinoUser(reservation.getKinoUser());
        reservation1.setDiscount(reservation.getDiscount());
        reservation1.setBuy(reservation.getBuy());
        reservation1.setStart(reservation.getStart());
        reservation1.setEnd(reservation.getEnd());
        reservation1.setPlaces(reservation.getPlaces());
        return reservationDao.save(reservation1).getId();
    }

    @Override
    public Long saveAllReservation(Reservation reservation, Long idKinU, Long idBuy, Long idDis) {
        KinoUser kinoUser = kinoUserDao.findById(idKinU).get();
        Buy buy = buyDao.findById(idBuy).get();
        Discount discount = discountDao.findById(idDis).get();
        reservation.setKinoUser(kinoUser);
        reservation.setBuy(buy);
        reservation.setDiscount(discount);
        return reservationDao.save(reservation).getId();
    }

    @Override
    public List<Place> getPlacesWithReservationId(Long id) {
        return placeDao.getFindbyIdReservaion(id);
    }


}
