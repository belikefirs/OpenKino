package com.dao;

import com.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingDao extends JpaRepository<Rating,Long> {
}
