package com.service;

import com.models.Hall;
import com.models.Place;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public interface HallService {
    Long saveHall(Hall hall);
    Long save(Integer number, Integer width, Integer height);
    List<Place> createdPlaces(Integer width, Integer height, BigDecimal price, Long idHall);
    Hall saveListPlaces(Long id, List<Place> places);
    Hall saveAndCreatedListSession(Long id);
     Hall findHallbyId(Long id);
    Hall findHallbyNumber(Integer number);
     Long updateHall(Hall hall);
     void deleteHall(Long id);
    Integer getSize(Long id);
    Long savePlace(Place place, Long id);
    Long updatePlace(Long id, BigDecimal price, Integer status);
    void deletePlace(Long id);
    Place  findPlaceByNumberFromHall(Long idHall, Long number);
    List<Place> getPlaces(Long idHall);
    Place getPlace(Long idHall, Long idPlaces);
    List<Place> getPlacesNotReservation(Long id);
     List<Place> getPlacesReservation(Long id);
List<Hall>  getAllHall();
}
