package com.controller;

import com.models.Film;
import com.models.Rating;
import com.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mbelo on 15.07.2019.
 */
@RestController
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping("/savefilm")
    public Long saveFilm(Film film){
        film.setName("Титаник");
        film.setName("Драма");
        film.setLenght(7200L);
        return filmService.saveFilm(film);
    }

    @GetMapping("/saveRating")
    public Long saveRating(Rating rating){
        rating.setRating(5);
        return filmService.saveRating(rating);
    }

    @GetMapping("/setRating")
    public Long setRating(){
        return filmService.setRatingById(1L,2L);
    }
}
