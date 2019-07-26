package com.dao;

import com.models.Card;
import org.omg.PortableInterceptor.LOCATION_FORWARD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CardDao extends JpaRepository<Card, Long> {
    List<Card> findAllByKinoUserId(Long id);
}
