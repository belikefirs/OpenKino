package com.threads;

import com.dao.ReservationDao;
import com.models.Reservation;
import org.springframework.stereotype.Component;


public class FindReservations implements Runnable {
    private ReservationDao reservationDao;
    private boolean isCount;
    public  FindReservations(ReservationDao reservationDao){
        this.reservationDao = reservationDao;
    }
    @Override
    public void run() {
        if(reservationDao.getCountReservation() == 0){
            isCount = false;
        } else if(reservationDao.getCountReservation() != 0){
            isCount = true;
        }
    }

    public boolean isCount() {
        return isCount;
    }
}
