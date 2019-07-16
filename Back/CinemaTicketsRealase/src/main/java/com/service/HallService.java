package com.service;

import com.models.Hall;
import com.models.Place;

import java.util.List;

public interface HallService {
    public Long saveHall(Hall hall);
    public Hall findGHallbyId(Long id);
    public Long updateHall(Hall hall);
    public void deleteHall(Long id);
    public List<Place> getPlaces(Long id);
    public Integer getSize(Long id);

}
