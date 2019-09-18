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
import java.util.*;

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
    private FilmDao filmDao;

    public ReservationServiceImpl(ReservationDao reservationDao, PlaceDao placeDao,
                                  KinoUserDao kinoUserDao, DiscountDao discountDao, BuyDao buyDao, SessionDao sessionDao, FilmDao filmDao) {
        this.reservationDao = reservationDao;
        this.placeDao = placeDao;
        this.kinoUserDao = kinoUserDao;
        this.discountDao = discountDao;
        this.buyDao = buyDao;
        this.sessionDao = sessionDao;
        this.filmDao = filmDao;
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
        if (Status == 0) {
            reservation1.setStatus(RStatus.IsAlive);
        } else if (Status == 1) {
            reservation1.setStatus(RStatus.IsNotAlive);
        } else if (Status == 2) {
            reservation1.setStatus(RStatus.isBuy);
        }
        return reservationDao.save(reservation1).getId();
    }

    @Override
    public Long saveAllReservation(ReservationMask reservationMask, Long id_user) {
        KinoUser kinoUser1 = kinoUserDao.findById(id_user).get();
        Reservation reservation = new Reservation();
        reservation.setStart(LocalDateTime.now(ZoneId.of("UTC+4")));
        reservation.setEnd(sessionDao.getBeginSession(reservationMask.getIdSess()).minusHours(1));
        reservation.setKinoUser(kinoUser1);
        reservation.setStatus(RStatus.IsAlive);
        BigDecimal resultPrice = new BigDecimal("0");
        reservation.setPrice(resultPrice);
        Long id = reservationDao.save(reservation).getId();
        Reservation r = reservationDao.findById(id).get();
        ArrayList list = new ArrayList();
        for (int i = 0; i < reservationMask.getPlaces().size(); i++) {
            list.add(reservationMask.getPlaces().get(i));
            Place place = placeDao.findById(reservationMask.getPlaces().get(i)).get();
           place.setStatus(Pstatus.IsReservation);
            place.setReservation(r);
            placeDao.save(place);
            resultPrice = resultPrice.add(place.getPrice());
        }
        List<Place> placeList =  new ArrayList<Place>();
        for (Long e: reservationMask.getPlaces()
             ) {
            placeList.add(placeDao.findById(e).get());
        }
        r.setPlaces(placeList);
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
        if (status == 0) {
            reservation.setStatus(RStatus.IsNotAlive);
        } else if (status == 1) {
            reservation.setStatus(RStatus.IsAlive);
        } else if (status == 2) {
            reservation.setStatus(RStatus.isBuy);
        }
        return reservationDao.save(reservation).getId();
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

    @Override
    public ArrayList getInfoFromReser(KinoUser kinoUser) {
        List<Reservation> listReser = reservationDao.getFindByIdKinoUser(kinoUser.getId());
        ArrayList list = new ArrayList();
        for (Reservation e : listReser) {
            ArrayList listEachReser = new ArrayList();
            List<Place> listPlace = placeDao.getFindbyIdReservaion(e.getId());
            for (Place ee : listPlace) {
                ArrayList listInfo = new ArrayList();
                listInfo.add(ee.getPrice());
                listInfo.add(ee.getX());
                listInfo.add(ee.getY());
                Hall hall = ee.getHall();
                listInfo.add(hall.getNumber());
                Session session = sessionDao.findSessionByHall_Id(hall.getId());
                listInfo.add(session.getStart());
                listInfo.add(session.getFilm().getName());
                listEachReser.add(listInfo);
            }
            list.add(listEachReser);

        }

        return list;
    }
}
