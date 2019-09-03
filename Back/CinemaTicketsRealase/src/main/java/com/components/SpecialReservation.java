package com.components;

import java.util.ArrayList;

public class SpecialReservation {
    Long idKinU;
    Long idSess;
    Long idHall;
    ArrayList<Long> places;

    public Long getIdKinU() {
        return idKinU;
    }

    public void setIdKinU(Long idKinU) {
        this.idKinU = idKinU;
    }

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

    public ArrayList<Long> getPlaces() {
        return places;
    }

    public void setPlaces(ArrayList<Long> places) {
        this.places = places;
    }
}
