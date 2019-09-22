package com.service;
import com.models.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.io.IOException;
import java.security.acl.LastOwnerException;
import java.util.List;

public interface FilmService {

    Long saveFilm(Film film);//
    void deleteFilmById(Long id);//
    Long updateFilmById(Film film);
    Film findFilmById(Long id);//
    List <Film> findFilmsByVars(String name,
                                String genre,
                                String typeFilm,
                                Double rating,
                                Integer age);
    void updateGRLT(Film film);
    List<Film> getAllFilms();

    Long updateGenre(Genre genre);
    List<Genre> findAllGenre();

    Long updateTypeFilm(TypeFilm typeFilm);
    List<TypeFilm> findAllTypeFilm();

    Long updateLimitAge(LimitAge limitAge);
    List <LimitAge> findAllLimitAge();

    Long updateRating(Rating rating);
   Double findFilmRating(Long id_film);

    Long loadImage(MultipartFile file, Long id) throws IOException;
    Long loadImageUpdate(MultipartFile file, Long id) throws IOException;
    Image getImage(Long id);

    void deleteImage(Long id);
    List<Image> getAllImage();

    Long addRating(Long id_film, KinoUser kinoUser, Double rating);
}
