package com.service;

import com.dao.*;
import com.enums.Pstatus;
import com.masks.HallMask;
import com.masks.PlaceMask;
import com.models.Buy;
import com.models.Hall;
import com.models.Place;
import com.models.Reservation;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class HallServiceImpl implements HallService {
    private HallDao hallDao;
    private PlaceDao placeDao;
    private ReservationDao reservationDao;
    private BuyDao buyDao;
    private SessionDao sessionDao;
    public HallServiceImpl(HallDao hallDao, PlaceDao placeDao,
                           ReservationDao reservationDao, BuyDao buyDao,
                           SessionDao sessionDao){
        this.hallDao = hallDao;
        this.placeDao = placeDao;
        this.reservationDao = reservationDao;
        this.buyDao = buyDao;
        this.sessionDao = sessionDao;
    }
    @Override
    @Transactional
    public Long saveHall(Hall hall) {////////////////////////////////////////////////
        return hallDao.save(hall).getId();
    }

    @Override
    @Transactional
    public Long save(HallMask hallMask) {
        Hall hall = new Hall();
        hall.setNumber(hallMask.getNumber());
        hall.setWidth(hallMask.getWidth());
        hall.setHeight(hallMask.getHeight());
        Long id = hallDao.save(hall).getId();
        List<Place> places = new ArrayList<Place>();
        for(int i = 1; i < hallMask.getWidth(); i++){
            for(int j = 1; j < hallMask.getHeight(); j++){
                Place place = new Place();
                place.setHall(hallDao.findById(id).get());
                place.setY(i);
                place.setX(j);
                place.setPrice(hallMask.getPrice());
                place.setStatus(Pstatus.IsFree);
                placeDao.save(place);
                places.add(place);
            }
        }
        hallDao.findById(id).get().setPlaces(places);
        return id;
    }
    @Override
    @Transactional
    public Hall saveAll(Integer number, Integer width, Integer height, BigDecimal price) {
        Hall hall = new Hall();
        hall.setNumber(number);
        hall.setWidth(width);
        hall.setHeight(height);
        Long id = hallDao.save(hall).getId();
        List<Place> places = new ArrayList<Place>();
        for(int i = 1; i < width+1; i++){
            for(int j = 1; j < height+1; j++){
                Place place = new Place();
                place.setHall(hallDao.findById(id).get());
                place.setY(i);
                place.setX(j);
                place.setPrice(price);
                place.setStatus(Pstatus.IsFree);
                placeDao.save(place);
                places.add(place);
            }
        }
        hallDao.findById(id).get().setPlaces(places);
        return hall;
    }

    @Override
    public List<Place> getIsReservation(Long id) {
        return placeDao.getFindbyIdReservaion(id);
    }
    /*@Override
    @Transactional
    public List<Place> createdPlaces(Integer width, Integer height, BigDecimal price, Long idHall){
        List<Place> places = new ArrayList<Place>();
        for(int i = 1; i < height; i++){
            for(int j = 1; j < width; j++){
                Place place = new Place();
                place.setHall(hallDao.findById(idHall).get());
                place.setY(i);
                place.setX(j);
                place.setPrice(price);
                place.setStatus(Pstatus.IsFree);
                placeDao.save(place);
                places.add(place);
            }
        }
        return places;
    }

    @Override
    @Transactional
   public Hall saveListPlaces(Long id, List<Place> places){
        Hall hall = hallDao.findById(id).get();
        hall.setPlaces(places);
        return hall;
    }*/

    @Override
    public Hall saveAndCreatedListSession(Long id) {
        Hall hall = hallDao.findById(id).get();
        hall.setSessions(sessionDao.getAllSession(hall.getId()));
        hallDao.save(hall);
        return hall;
    }

    @Override
    @Transactional
    public Hall findHallbyId(Long id) {
        Hall hall = hallDao.findById(id).get();
        hall.getPlaces().size();
        return hall;
    }

    @Override
    @Transactional
    public Hall findHallbyNumber(Integer number) {
        Hall hall = hallDao.getNumberHall(number);
        hall.getPlaces().size();
        return hall;
    }

    @Override
    @Transactional
    public Long updateHall(Hall hall) {
        Hall hall1 = hallDao.findById(hall.getId()).get();
        hall1.setHeight(hall.getHeight());
        hall1.setWidth(hall.getWidth());
        hall1.setPlaces(hall.getPlaces());
        return hallDao.save(hall1).getId();
    }

    @Override
    @Transactional
    public void deleteHall(Long id) {
        hallDao.deleteById(id);
    }

    @Override
    @Transactional
    public List<Place> getPlaces(Long id) {
        Hall hall = hallDao.findById(id).get();
        List<Place> places = placeDao.getFindHallWithlacesById(hall.getId());
        return places;
    }

    @Override
    @Transactional
    public Place getPlace(Long idHall, Long idPlaces) {
        return null;
    }

    @Override
    @Transactional
    public List<Place> getPlacesNotReservation(Long id) {
        Hall hall = hallDao.findById(id).get();
        List<Place>  places =
                placeDao.getFindbyIdHallPlacesnotReservation(hall.getId());
        return places;
    }

    @Override
    @Transactional
    public List<Place> getPlacesReservation(Long id) {
        Hall hall =  hallDao.findById(id).get();
        List<Place> places =
                placeDao.getFindbyIdHallPlacesisReservation(hall.getId());
        return places;
    }

    @Override
    @Transactional
    public Integer getSize(Long id) {
        Hall hall = hallDao.findById(id).get();
        return hall.getWidth() * hall.getHeight();
    }
    @Override
    @Transactional
    public Long savePlace(PlaceMask placeMask) {
        Hall hall = hallDao.findById(placeMask.getIdH()).get();
        placeMask.getPlace().setHall(hall);
        placeMask.getPlace().setStatus(Pstatus.IsFree);
        return placeDao.save(placeMask.getPlace()).getId();
    }

    @Override
    @Transactional
    public Long changeStatus(Long id, int status) {
        Place place = placeDao.findById(id).get();
        if(status == 1){
            place.setStatus(Pstatus.IsFree);
        }
        if(status == 2){
            place.setStatus(Pstatus.IsBuy);
        }
        if(status == 3){
            place.setStatus(Pstatus.IsReservation);
        }
        if(status == 0){
            place.setStatus(Pstatus.IsBroken);
        }
        placeDao.save(place);
        return place.getId();
    }

    @Override
    @Transactional
    public Long updatePlace(Long id, BigDecimal price, Integer status) {
        Place place = placeDao.findById(id).get();
        place.setPrice(price);
        if(status == 1){
            place.setStatus(Pstatus.IsFree);
        }
        if(status == 2){
            place.setStatus(Pstatus.IsBuy);
        }
        if(status == 3){
            place.setStatus(Pstatus.IsReservation);
        }
        if(status == 0){
            place.setStatus(Pstatus.IsBroken);
        }
        placeDao.save(place);
        return place.getId();
    }

    @Override
    @Transactional
    public void deletePlace(Long id) {
        placeDao.deleteById(id);
    }

    @Override
    @Transactional
    public Place findPlaceByNumberFromHall(Long idHall, Long number) {
        Place place = placeDao.findPlaceByNumberFromHall(idHall, number);
        return place;
    }

    @Override
    @Transactional
    public List<Hall> getAllHall() {
        List<Hall> halls = hallDao.findAll();
        for (Hall e: halls) {
           e.getPlaces().size();
           e.getSessions().size();
        }
        return halls;
    }
}
