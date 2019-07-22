package com.service;

import com.dao.KinoUserDao;
import com.dao.PlaceDao;
import com.dao.ReservationDao;
import com.models.Discount;
import com.models.Reservation;

public class ReservationServiceImpl implements ReservationService {
    private ReservationDao reservationDao;
    private PlaceDao placeDao;
    private KinoUserDao kinoUserDao;
    public ReservationServiceImpl(ReservationDao reservationDao, PlaceDao placeDao, KinoUserDao kinoUserDao){
        this.reservationDao = reservationDao;
        this.placeDao = placeDao;
        this.kinoUserDao = kinoUserDao;
    }
    @Override
    public Long saveReservation(Reservation reservation) {
        return reservationDao.save(reservation).getId();
    }

    @Override
    public void deleteReservationById(Long id) {

    }

    @Override
    public Long saveDiscount(Discount discount) {
        return null;
    }

    @Override
    public void deleteDiscountById(Long id) {

    }

    @Override
    public Long updateReservation(Reservation reservation, Long id) {
        return null;
    }
}
