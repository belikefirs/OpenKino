package com.components;

import com.dao.ReservationDao;
import com.models.Reservation;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
//@Component
public class AutoDeleteReservation {
private ReservationDao reservationDao;
public AutoDeleteReservation(ReservationDao reservationDao){
    this.reservationDao = reservationDao;
}
//@Scheduled(fixedDelay = 3000)
public void autoDelete() {

    //reservationDao.deleteById(id);
}
}
