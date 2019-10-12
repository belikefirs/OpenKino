package com.service;

import com.dao.*;
import com.enums.Pstatus;
import com.masks.HallMask;
import com.masks.PlaceMask;
import com.models.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

@Service
@Transactional
public class HallServiceImpl implements HallService {
    private HallDao hallDao;
    private PlaceDao placeDao;
    private ReservationDao reservationDao;
    private BuyDao buyDao;
    private SessionDao sessionDao;
    private HallTempleteDao hallTempleteDao;

    public HallServiceImpl(HallDao hallDao, PlaceDao placeDao,
                           ReservationDao reservationDao, BuyDao buyDao,
                           SessionDao sessionDao, HallTempleteDao hallTempleteDao){
        this.hallDao = hallDao;
        this.placeDao = placeDao;
        this.reservationDao = reservationDao;
        this.buyDao = buyDao;
        this.sessionDao = sessionDao;
        this.hallTempleteDao = hallTempleteDao;
    }

    @Override

    public Long saveV2(Hall hall) {
        hall.setPlaces(null);
        hall.setSessions(null);
        return hallDao.save(hall).getId();
    }

    @Override

    public Long saveHall(Hall hall) {////////////////////////////////////////////////
        return hallDao.save(hall).getId();
    }

    @Override

    public Long saveHallTemplete(HallTemplete hallTemplete) {
        return hallTempleteDao.save(hallTemplete).getId();
    }

    @Override

    public Long save(Hall hall, BigDecimal price) {

        Long id = hallDao.save(hall).getId();
        List<Place> places = new ArrayList<Place>();
        for(int i = 1; i < hall.getWidth()+1; i++){
            for(int j = 1; j < hall.getHeight()+1; j++){
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
        return id;
    }
    @Override

    public Hall saveAll(Integer number, Integer width, Integer height, BigDecimal price) {
        Hall hall = new Hall();
      //  hall.setNumber(number);
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

    public Hall findHallbyId(Long id) {
        Hall hall = hallDao.findById(id).get();
        hall.getPlaces().size();
        hall.getSessions().size();
        return hall;
    }

    @Override

    public Hall findHallbyNumber(Long number) {
        Hall hall = hallDao.getNumberHall(number);
        hall.getPlaces().size();
        return hall;
    }

    @Override

    public Long updateHall(Hall hall) {
        Hall hall1 = hallDao.findById(hall.getId()).get();
        hall1.setHeight(hall.getHeight());
        hall1.setWidth(hall.getWidth());
        hall1.setPlaces(hall.getPlaces());
        return hallDao.save(hall1).getId();
    }

    @Override

    public void deleteHall(Long id) {
        hallDao.deleteById(id);
    }

    @Override

    public List<Place> getPlaces(Long id) {
        Hall hall = hallDao.findById(id).get();
        List<Place> places = placeDao.getFindHallWithlacesById(hall.getId());
        return places;
    }

    @Override

    public Place getPlace(Long idHall, Long idPlaces) {
        return null;
    }

    @Override

    public List<Place> getPlacesNotReservation(Long id) {
        Hall hall = hallDao.findById(id).get();
        List<Place>  places =
                placeDao.getFindbyIdHallPlacesnotReservation(hall.getId());
        return places;
    }

    @Override

    public List<Place> getPlacesReservation(Long id) {
        Hall hall =  hallDao.findById(id).get();
        List<Place> places =
                placeDao.getFindbyIdHallPlacesisReservation(hall.getId());
        return places;
    }

    @Override

    public Integer getSize(Long id) {
        Hall hall = hallDao.findById(id).get();
        return hall.getWidth() * hall.getHeight();
    }
    @Override

    public Long savePlace(PlaceMask placeMask) {
        Hall hall = hallDao.findById(placeMask.getIdH()).get();
        placeMask.getPlace().setHall(hall);
        placeMask.getPlace().setStatus(Pstatus.IsFree);
        return placeDao.save(placeMask.getPlace()).getId();
    }

    @Override

    public void changeStatus(List<Long> listPlace, int status) {
        List<Place> places = new ArrayList<Place>();
        for (Long e: listPlace
             ) {
            places.add(placeDao.findById(e).get());
        }

        if(status == 0){
            for (Place ee: places
            ) {
                ee.setStatus(Pstatus.IsFree);
            }
        }
        if(status == 1){
            for (Place ee: places
            ) {
                ee.setStatus(Pstatus.IsBuy);
            }
        }
        if(status == 2){
            for (Place ee: places
            ) {
                ee.setStatus(Pstatus.IsReservation);
            }
        }
        if(status == 3){
            for (Place ee: places
            ) {
                ee.setStatus(Pstatus.IsBroken);
            }
        }
        placeDao.saveAll(places);
    }

    @Override

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

    public void deletePlace(Long id) {
        placeDao.deleteById(id);
    }

    @Override

    public Place findPlaceByNumberFromHall(Long idHall, Long number) {
        Place place = placeDao.findPlaceByNumberFromHall(idHall, number);
        return place;
    }

    @Override

    public List<Hall> getAllHall() {
        List<Hall> halls = hallDao.findAll();
        for (Hall e: halls) {
           e.getPlaces().size();
           e.getSessions().size();
        }
        return halls;
    }


}
