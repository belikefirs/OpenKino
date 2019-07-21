package com.service;

import com.dao.PlaceDao;
import com.models.Place;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlaceServiceImpl implements PlaceService {
    private PlaceDao placeDao;
    public PlaceServiceImpl(PlaceDao placeDao){
        this.placeDao = placeDao;
    }
    @Override
    public Long savePlace(Place place) {
        return placeDao.save(place).getId();
    }

    @Override
    public Long updatePlace(Place place) {
        Place place1 = placeDao.findById(place.getId()).get();
        place1.setX(place.getX());
        place1.setY(place.getY());
        place1.setPrice(place.getPrice());
        place1.setHall(place.getHall());
        place1.setReservation(place.getReservation());
        return null;
    }

    @Override
    public void deletePlace(Long id) {
        placeDao.deleteById(id);
    }

    @Override
    public Place findPlaceById(Long id) {
        Place place = placeDao.findById(id).get();
        return place;
    }

}
