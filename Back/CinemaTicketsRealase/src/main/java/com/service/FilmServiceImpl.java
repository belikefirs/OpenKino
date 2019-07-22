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
        updateGRLT(film);
        return filmDao.save(film).getId();
    }

    @Override
    public void deleteFilmById(Long id) {
        filmDao.deleteById(id);
    }

    @Override
    public Long updateFilmById(Film film) {
        updateGRLT(film);
        Film film1 = filmDao.findById(film.getId()).get();
        film1.setGenre(film.getGenre());
        film1.setName(film.getName());
        film1.setLenght(film.getLenght());
        return filmDao.save(film1).getId();
    }

    @Override
    public Film findFilmById(Long id) {
        return filmDao.findById(id).get();
    }

    @Override
    public List<Film> findFilms(String name, Integer limitAge, Double rating, String typeFilm, String genre) {
        return null;
    }

    @Override
    public Long updateGenre(Genre genre) {
        Genre genre1 = genreDao.findById(genre.getId()).get();
        genre1.setName(genre.getName());
        genre1.setFilms(genre.getFilms());
        return genreDao.save(genre1).getId();
    }

    @Override
    public List<Genre> findAllGenre() {
        return genreDao.findAll();
    }

    @Override
    public Long updateTypeFilm(TypeFilm typeFilm) {
        TypeFilm typeFilm1 = typeFilmDao.findById(typeFilm.getId()).get();
        typeFilm1.setName(typeFilm.getName());
        typeFilm1.setFilms(typeFilm.getFilms());
        return typeFilmDao.save(typeFilm1).getId();
        }

    @Override
    public List<TypeFilm> findAllTypeFilm() {
        return typeFilmDao.findAll();
    }

    @Override
    public Long updateLimitAge(LimitAge limitAge) {
        LimitAge limitAge1 = limitAgeDao.findById(limitAge.getId()).get();
        limitAge1.setAge(limitAge.getAge());
        limitAge1.setFilms(limitAge.getFilms());
        return limitAgeDao.save(limitAge1).getId();
    }

    @Override
    public List<LimitAge> findAllLimitAge() {
        return limitAgeDao.findAll();
    }

    @Override
    public void updateGRLT(Film film) {
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
            filmDao.save(film).getId();
        }
    }

    @Override
    public Long updateRating(Rating rating) {
        Rating rating1 = ratingDao.findById(rating.getId()).get();
        rating1.setRating(rating.getRating());
        rating1.setFilms(rating.getFilms());
        return ratingDao.save(rating1).getId();
    }

    @Override
    public List<Rating> findAllRating() {
        return ratingDao.findAll();
    }

    @Override
    public List<Film> findAllFilm(String name, Long length, Integer limitAge, Double rating, String typeFilm, String genre) {
        if (name != null) {
            return filmDao.findAllByNameContainingIgnoreCase(name);
        }

        return null;
    }

    @Override
    public List<Film> findAllByRatingId(Long id) {
        return filmDao.findAllByRatingId(id);
    }

    @Override
    public List<Film> findAllByGenreId(Long id) {
        return filmDao.findAllByGenreId(id);
    }

    @Override
    public List<Film> findAllByTypeFIlmId(Long id) {
        return filmDao.findAllByTypeFilmId(id);
    }

    @Override
    public List<Film> findAllByLimitAgeId(Long id) {
        return filmDao.findAllByLimiteAgeId(id);
    }

    @Override
    public List<Film> findFilmsByNameLike(String name) {
        return filmDao.findAllByNameContainingIgnoreCase(name);
    }
}
