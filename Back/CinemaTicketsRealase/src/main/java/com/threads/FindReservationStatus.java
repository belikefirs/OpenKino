package com.threads;

import com.dao.ReservationDao;
import com.models.Reservation;

import java.util.ArrayList;
import java.util.List;

public class FindReservationStatus implements Runnable {
    private ReservationDao reservationDao;
    private List<Reservation> reservationList;
    public FindReservationStatus(ReservationDao reservationDao){
        this.reservationDao = reservationDao;
        reservationList = new ArrayList<Reservation>();
    }
    @Override
    public void run() {

    }
}
