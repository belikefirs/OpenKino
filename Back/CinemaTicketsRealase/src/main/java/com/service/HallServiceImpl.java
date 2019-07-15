package com.service;

import com.dao.HallDao;
import com.dao.PlaceDao;
import com.models.Hall;
import com.models.Place;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

public class HallServiceImpl implements HallService {
    private HallDao hallDao;
    private PlaceDao placeDao;
    public HallServiceImpl(HallDao hallDao, PlaceDao placeDao){
        this.hallDao = hallDao;
        this.placeDao = placeDao;
    }
    @Override
    @Transactional
    public Long saveHall(Hall hall) {
        hallDao.save(hall);
        return hall.getId();
    }

    @Override
    @Transactional
    public Hall findGHallbyId(Long id) {

        return hallDao.findById(id).get();
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
        return null;
    }

    @Override
    public Integer getSize(Long id) {
        Hall hall = hallDao.findById(id).get();
        return hall.getWidth() * hall.getHeight();
    }
    
}
