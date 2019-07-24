package com.service;

import com.dao.HallDao;
import com.dao.PlaceDao;
import com.models.Hall;
import com.models.Place;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class HallServiceImpl implements HallService {
    private HallDao hallDao;
    private PlaceDao placeDao;

    public HallServiceImpl(HallDao hallDao, PlaceDao placeDao){
        this.hallDao = hallDao;
        this.placeDao = placeDao;
    }
    @Override
    @Transactional
    public Long saveHall(Hall hall) {////////////////////////////////////////////////
        return hallDao.save(hall).getId();
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
        List<Place> places = placeDao.getFindbyIdHall(hall.getId());
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
    @Transactional
    public Long savePlace(Place place, Long id) {
        //placeDao.save(place).getId();
        Hall hall = hallDao.findById(id).get();
        place.setHall(hall);
       // hall.getPlaces().add(place);
        return placeDao.save(place).getId();
    }

    @Override
    public Long updatePlace(Place place) {
        Place place1 = placeDao.findById(place.getId()).get();
        place.setNumber(place.getNumber());
        place1.setX(place.getX());
        place1.setY(place.getY());
        place1.setPrice(place.getPrice());
        place1.setHall(place.getHall());
        place1.setReservation(place.getReservation());
        return place1.getId();
    }

    @Override
    public void deletePlace(Long id) {
        placeDao.deleteById(id);
    }

    @Override
    public Place findPlaceByNumberFromHall(Long idHall, Integer number) {
        Place place = placeDao.findPlaceByNumberFromHall(idHall, number);
        return place;
    }

}
