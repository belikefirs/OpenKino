package com.dao;

import com.models.Card;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CardDao extends JpaRepository<Card, Long> {
    List<Card> findAllByKinoUserId(Long id);
}
