package com.service;
import com.dao.*;
import com.models.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FilmServiceImpl implements FilmService {
    private FilmDao filmDao;
    private RatingDao ratingDao;
    private GenreDao genreDao;
    private LimitAgeDao limitAgeDao;
    private TypeFilmDao typeFilmDao;

    public FilmServiceImpl(FilmDao filmDao, TypeFilmDao typeFilmDao , RatingDao ratingDao, GenreDao genreDao, LimitAgeDao limitAgeDao) {
        this.filmDao = filmDao;
        this.typeFilmDao = typeFilmDao;
        this.ratingDao = ratingDao;
        this.genreDao = genreDao;
        this.limitAgeDao = limitAgeDao;
    }

    @Override
    public Long saveFilm(Film film) {
        if (film.getRating() != null) {
            Rating rating = film.getRating();
            if(film.getRating().getId() == null){
                ratingDao.save(rating);
            }
        }
        if (film.getLimitAge()!=null) {
            LimitAge limitAge = film.getLimitAge();
            if (film.getLimitAge().getId() == null) {
                limitAgeDao.save(limitAge);
            }
        }
        if (film.getTypeFilm() != null) {
            TypeFilm typeFilm = film.getTypeFilm();
            if (film.getTypeFilm().getId() == null) {
                typeFilmDao.saveAndFlush(typeFilm);
            }
        }
        if (film.getGenre() != null) {
            Genre genre = film.getGenre();
            if (film.getGenre().getId() ==  null) {
                genreDao.saveAndFlush(genre);
            }
        }
        else {
            return filmDao.save(film).getId();
        }
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
     //   film1.setDescription(film.getDescription());
        return filmDao.save(film1).getId();
    }

    @Override
    public Film findFimlById(Long id) {
        return filmDao.findById(id).get();
    }

    @Override
    public Long setGenreByFilmId(Long id, Long idGenre) {
        Genre genre = genreDao.findById(idGenre).get();
        Film film = findFimlById(id);
        film.setGenre(genre);
        return saveFilm(film);
    }

    @Override
    public Long setTypeFilmById(Long id, Long idTypeFilm) {
        Film film = findFimlById(id);
        TypeFilm typeFilm = typeFilmDao.findById(idTypeFilm).get();
        film.setTypeFilm(typeFilm);
        return saveFilm(film);
    }

    @Override
    public Long setLimitAgeById(Long id, Long idLimiteAge) {
        Film film = findFimlById(id);
        LimitAge limitAge = limitAgeDao.findById(idLimiteAge).get();
        film.setLimitAge(limitAge);
        return saveFilm(film);
    }

    @Override
    public Long setRatingById(Long id, Long idRating) {
        Film film = findFimlById(id);
        Rating rating = ratingDao.findById(idRating).get();
        film.setRating(rating);
        return saveFilm(film);
    }

    @Override
    public Long saveGenre(Genre genre) {
        return genreDao.save(genre).getId();
    }

    @Override
    public void deleteGenreById(Long id) {
        genreDao.deleteById(id);
    }

    @Override
    public List<Genre> findAllGenre() {
        return genreDao.findAll();
    }

    @Override
    public Long saveTypeFilm(TypeFilm typeFilm) {
        return typeFilmDao.save(typeFilm).getId();
    }

    @Override
    public void deleteTypeFilmById(Long id) {
        typeFilmDao.deleteById(id);
    }

    @Override
    public List<TypeFilm> findAllTypeFilm() {
        return typeFilmDao.findAll();
    }

    @Override
    public Long saveLimitAge(LimitAge limitAge) {
        return limitAgeDao.save(limitAge).getId();
    }

    @Override
    public void deleteLimitAgeById(Long id) {
        limitAgeDao.deleteById(id);
    }

    @Override
    public List<LimitAge> findAllLimitAge() {
        return limitAgeDao.findAll();
    }

    @Override
    public Long saveRating(Rating rating) {
        return ratingDao.save(rating).getId();
    }

    @Override
    public void deleteRatingById(Long id) {
    ratingDao.deleteById(id);
    }

    @Override
    public List<Rating> findAllRating() {
        return ratingDao.findAll();
    }

    @Override
    public List<Film> findAllFilm() {
        return filmDao.findAll();
    }
}
