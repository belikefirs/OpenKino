package com.dao;

import com.models.Position;
import javafx.geometry.Pos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PositionDao extends JpaRepository<Position, Long> {
    @Query(value = "select p from Position as p where p.name = :name")
    Position findByName(@Param("name")String namePos);
}
