package com.service;

import com.models.Place;

public interface PlaceService {
    Long savePlace(Place place);

    Long updatePlace(Place place);

    void deletePlace(Long id);

    Place findPlaceById(Long id);
}
