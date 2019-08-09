package com.service;

import com.models.Discount;
import com.models.Place;
import com.models.Reservation;

import java.util.List;

public interface ReservationService {
    Long saveReservation(Reservation reservation);
    void deleteReservationById(Long id);
    Long saveDiscount(Discount discount);
    void deleteDiscountById(Long id);
    Long updateReservation(Reservation reservation, Long id);
    Long saveAllReservation(Reservation reservationl, Long idKinU, Long idBuy, Long idDis);
    List<Place>  getPlacesWithReservationId(Long id);

}
