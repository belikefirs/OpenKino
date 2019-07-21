package com.service;
import com.models.*;
import java.util.List;

public interface FilmService {

    Long saveFilm(Film film);//
    void deleteFilmById(Long id);//
    Long updateFilmById(Film film);
    Film findFilmById(Long id);//
    List <Film> findAllFilm();
    void updateGRLT(Film film);
    List <Film> findAllByRatingId(Long id);
    List <Film> findAllByGenreId(Long id);
    List <Film> findAllByTypeFIlmId(Long id);
    List <Film> findAllByLimitAgeId(Long id);

    Long updateGenre(Genre genre);
    List<Genre> findAllGenre();

    Long updateTypeFilm(TypeFilm typeFilm);
    List<TypeFilm> findAllTypeFilm();

    Long updateLimitAge(LimitAge limitAge);
    List <LimitAge> findAllLimitAge();

    Long updateRating(Rating rating);
    List <Rating> findAllRating();
}
