package com.service;
import com.models.*;

import java.util.List;

public interface FilmService {

    Long saveFilm(Film film);
    void deleteFilmById(Long id);
    Long updateFilmById(Film film);
    Film findFimlById(Long id);

    Long setGenreByFilmId(Long id, Long idGenre);
    Long setTypeFilmById(Long id, Long idTypeFilm);
    Long setLimitAgeById(Long id,Long idLimiteAge);
    Long setRatingById(Long id, Long idRating);


    Long saveGenre(Genre genre);
    void deleteGenreById(Long id);
    List<Genre> findAllGenre();

    Long saveTypeFilm(TypeFilm typeFilm);
    void deleteTypeFilmById(Long id);
    List<TypeFilm> findAllTypeFilm();

    Long saveLimitAge(LimitAge limitAge);
    void deleteLimitAgeById(Long id);
    List <LimitAge> findAllLimitAge();

    Long saveRating(Rating rating);
    void deleteRatingById(Long id);
    List <Rating> findAllRating();
    List <Film> findAllFilm();

}
