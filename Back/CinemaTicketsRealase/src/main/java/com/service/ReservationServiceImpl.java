package com.service;

import com.dao.DiscountDao;
import com.dao.KinoUserDao;
import com.dao.PlaceDao;
import com.dao.ReservationDao;
import com.models.Discount;
import com.models.Reservation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
    private ReservationDao reservationDao;
    private PlaceDao placeDao;
    private KinoUserDao kinoUserDao;
    private DiscountDao discountDao;
    public ReservationServiceImpl(ReservationDao reservationDao, PlaceDao placeDao,
                                  KinoUserDao kinoUserDao, DiscountDao discountDao){
        this.reservationDao = reservationDao;
        this.placeDao = placeDao;
        this.kinoUserDao = kinoUserDao;
        this.discountDao = discountDao;
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

}
