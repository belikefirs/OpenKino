package com.dao;

import com.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CardDao extends JpaRepository<Card, Long> {
    @Query("select card from Card as card " +
            "join card.kinoUser as kinoUser " +
            "where kinoUser.id = :id")
    List<Card> findAllByKinoUserId(@Param("id") Long id);
}
