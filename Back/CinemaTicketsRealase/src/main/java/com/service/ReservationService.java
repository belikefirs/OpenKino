package com.service;

import com.models.Discount;
import com.models.Reservation;

public interface ReservationService {
    Long saveReservation(Reservation reservation);
    void deleteReservationById(Long id);
    Long saveDiscount(Discount discount);
    void deleteDiscountById(Long id);
}
