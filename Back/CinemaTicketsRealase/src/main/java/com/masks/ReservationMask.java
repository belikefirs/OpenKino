package com.masks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.models.Place;
import com.models.Reservation;

import java.util.ArrayList;

public class ReservationMask {
    public static class View {
        public static class Save {}
    }
    @JsonIgnore
    Reservation reservation;
    @JsonView(View.Save.class)
    Long idSess;

    @JsonView(View.Save.class)
    Long idHall;

    @JsonView(Reservation.View.Save.class)
    ArrayList<Long> places;

    public ReservationMask(){}
//    public void initReservation(){
//        this.reservation =  new Reservation();
//        this.reservation.setPlaces(places);
//    }
    public Long getIdSess() {
        return idSess;
    }

    public void setIdSess(Long idSess) {
        this.idSess = idSess;
    }

    public Long getIdHall() {
        return idHall;
    }

    public void setIdHall(Long idHall) {
        this.idHall = idHall;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public ArrayList<Long> getPlaces() {
        return places;
    }

    public void setPlaces(ArrayList<Long> places) {
        this.places = places;
    }
}
