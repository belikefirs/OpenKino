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

    @Query(value =" SELECT FILM.*" +
            " FROM FILM " +
            "    inner join GENRE on GENRE.ID = FILM.ID_GENRE " +
            "    inner join LIMIT_AGE on FILM.ID_LIMIT_AGE = LIMIT_AGE.ID " +
            "    inner join RATING on FILM.ID_RATING = RATING.ID " +
            "    inner join TYPE_FILM on FILM.ID_TYPE_FILM = TYPE_FILM.ID " +
            " WHERE (upper(FILM.NAME) LIKE CONCAT('%',upper(:name1),'%') OR FILM.NAME IS NULL) AND " +
            "    (upper(GENRE.NAME) LIKE CONCAT('%',upper(:genre),'%') OR GENRE.NAME IS NULL) AND " +
            "    (upper(TYPE_FILM.NAME) LIKE CONCAT ('%',upper(:typeFilm),'%') OR TYPE_FILM.NAME IS NULL) AND " +
            "    (RATING.RATING = :rating OR :rating IS NULL) AND " +
            "    (LIMIT_AGE.AGE = :age OR :age IS NULL)", nativeQuery = true)
    List<Film> findFilmsByVars(@Param("name1") String name,
                               @Param("genre") String genre,
                               @Param("typeFilm") String typeFilm,
                               @Param("rating") Double rating,
                               @Param("age") Integer age);
}
