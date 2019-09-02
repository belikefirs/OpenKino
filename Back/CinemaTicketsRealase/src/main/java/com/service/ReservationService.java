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
    Long updateReservation(Reservation reservation, Long id, int Status);
    Long saveAllReservation(Long idKinU, Long idDis, Long idSess,Long idHall,
                            List<Place> placeIsReservation);
    List<Place>  getPlacesWithReservationId(Long id);
    List<Reservation> getFindByIdKinoUser(Long idKinU);
    Long changeStatusReservation(Long id, Integer status);
    List<Place> getPlacesForReservation(List<Place> places, Long idPlace);
    List<Place> deletePlaceFromList(List<Place> places, Long idPlace);
    public Reservation getFindById(Long id);
}
