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

    @Query(value ="SELECT FILM.NAME,GENRE.NAME,LIMIT_AGE.AGE,RATING.RATING,TYPE_FILM.NAME\n" +
            "FROM FILM\n" +
            "    inner join GENRE on GENRE.ID = FILM.ID_GENRE\n" +
            "    inner join LIMIT_AGE on FILM.ID_LIMIT_AGE = LIMIT_AGE.ID\n" +
            "    inner join RATING on FILM.ID_RATING = RATING.ID\n" +
            "    inner join TYPE_FILM on FILM.ID_TYPE_FILM = TYPE_FILM.ID\n" +
            "WHERE (upper(FILM.NAME) LIKE upper('%:name%') OR FILM.NAME IS NULL) AND\n" +
            "    (upper(GENRE.NAME) LIKE upper('%:genre%') OR GENRE.NAME IS NULL) AND\n" +
            "    (upper(TYPE_FILM.NAME) LIKE upper('%typeFilm%') OR TYPE_FILM.NAME IS NULL) AND\n" +
            "    (RATING.RATING = :rating OR RATING.RATING IS NULL) AND \n" +
            "    (LIMIT_AGE.AGE = :age OR LIMIT_AGE.AGE IS NULL)", nativeQuery = true)
    List<Film> findFilmsByVars(@Param("name") String name,
                               @Param("genre") String genre,
                               @Param("typeFilm") String typeFilm,
                               @Param("rating") Double rating,
                               @Param("age") Integer age);
}
