package com.dao;

import com.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmDao extends JpaRepository<Film, Long> {
    @Query("select f from Film f join f.rating r where r.id = :id")
    List<Film> findAllByRatingId(@Param("id") Long id);
    @Query(value = "SELECT * FROM FILM WHERE ID_GENRE = :id",nativeQuery = true)
    List<Film> findAllByGenreId(@Param("id") Long id);
    @Query(value = "SELECT * FROM FILM WHERE ID_LIMIT_AGE = :id",nativeQuery = true)
    List<Film> findAllByLimiteAgeId(@Param("id") Long id);
    @Query(value = "SELECT * FROM FILM WHERE ID_TYPEFILM = :id",nativeQuery = true)
    List<Film> findAllByTypeFilmId(@Param("id") Long id);

    List<Film> findAllByNameContainingIgnoreCase(String name);
}
