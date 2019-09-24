package com.dao;

import com.models.Hall;
import com.models.HallTemplete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HallTempleteDao extends JpaRepository <HallTemplete,Long> {
    @Query(value = "select h from HallTemplete as h where h.number = :number")
    HallTemplete getNumberHall(@Param("number") Integer number);
}
