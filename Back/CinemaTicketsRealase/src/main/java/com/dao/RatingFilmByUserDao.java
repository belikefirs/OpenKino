package com.dao;

import com.models.RatingFilmByUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface RatingFilmByUserDao extends JpaRepository<RatingFilmByUser, Long> {
    @Query(value = "SELECT * FROM RatingFilmByUser WHERE (ID_FILM = :id_film AND ID_USER = :id_user)",nativeQuery = true)
    RatingFilmByUser findRating(@Param("id_film") Long id_film, @Param("id_user") Long id_user);
}

