package com.dao;

import com.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceDao extends JpaRepository<Place,Long> {
}
