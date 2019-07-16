package com.dao;

import com.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CardDao extends JpaRepository<Card, Long> {
    List<Card> findAllByKinoUserId(Long id);
}
