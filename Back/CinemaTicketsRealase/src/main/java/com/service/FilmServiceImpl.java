package com.service;
import com.dao.FilmDao;
import com.dao.GenreDao;
import com.dao.LimitAgeDao;
import com.dao.RatingDao;
import com.models.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    private FilmDao filmDao;
    private RatingDao ratingDao;
    private GenreDao genreDao;
    private LimitAgeDao limitAgeDao;

    public FilmServiceImpl(FilmDao filmDao, RatingDao ratingDao, GenreDao genreDao, LimitAgeDao limitAgeDao) {
        this.filmDao = filmDao;
        this.ratingDao = ratingDao;
        this.genreDao = genreDao;
        this.limitAgeDao = limitAgeDao;
    }

    @Override
    public Long saveFilm(Film film) {
        return filmDao.save(film).getId();
    }

    @Override
    public void deleteFilmById(Long id) {
        filmDao.deleteById(id);
    }

    @Override
    public Long updateFilmById(Film film) {
        Film film1 = filmDao.findById(film.getId()).get();
        film1.setName(film.getName());
        film1.setLenght(film.getLenght());
        film1.setLimitAge(film.getLimitAge());
        film1.setRating(film.getRating());
        film1.setSessions(film.getSessions());
        film1.setTypeFilm(film.getTypeFilm());
        return filmDao.save(film1).getId();
    }

    @Override
    public Film findFimlById(Long id) {
        return filmDao.findById(id).get();
    }

    @Override
    public Long saveGenre(Genre genre) {
        return null;
    }

    @Override
    public void deleteGenreById(Long id) {

    }

    @Override
    public List<Genre> findAllGenre() {
        return null;
    }

    @Override
    public Long saveTypeFilm(TypeFilm typeFilm) {
        return null;
    }

    @Override
    public void deleteTypeFilmById(Long id) {

    }

    @Override
    public List<TypeFilm> findAllTypeFilmBYId() {
        return null;
    }

    @Override
    public Long saveLimitAge(LimitAge limitAge) {
        return null;
    }

    @Override
    public void deleteLimitAgeById(Long id) {

    }

    @Override
    public List<LimitAge> findAllLimitAge() {
        return null;
    }

    @Override
    public Long saveRating(Rating rating) {
        return null;
    }

    @Override
    public void deleteRatingById(Long id) {

    }

    @Override
    public List<Rating> findAllRating() {
        return null;
    }
}
