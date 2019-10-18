package com.service;

import com.models.Hall;
import com.models.Place;

import java.math.BigDecimal;
import java.util.List;

public interface HallService {
    Long saveHall(Hall hall);
    Long save(Hall hall, BigDecimal price);
    Long saveV2(Hall hall);
    Hall saveAll(Integer number, Integer width, Integer height, BigDecimal price);
    List<Place> getIsReservation(Long id);
  //  List<Place> createdPlaces(Integer width, Integer height, BigDecimal price, Long idHall);
   // Hall saveListPlaces(Long id, List<Place> places);
    Hall saveAndCreatedListSession(Long id);
     Hall findHallbyId(Long id);
    Hall findHallbyNumber(Long number);
     Long updateHall(Hall hall);
     void changeStatus(List<Long> listPlace, int status);
     void deleteHall(Long id);
    Integer getSize(Long id);
    Long updatePlace(Long id, BigDecimal price, Integer status);
    void deletePlace(Long id);
    Place  findPlaceByNumberFromHall(Long idHall, Long number);
    List<Place> getPlaces(Long idHall);
    Place getPlace(Long idHall, Long idPlaces);
    List<Place> getPlacesNotReservation(Long id);
     List<Place> getPlacesReservation(Long id);
    Hall getHallBySession(Long id_session);
List<Hall>  getAllHall();
}
