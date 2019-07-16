package com.controller;

import com.models.Film;
import com.models.Rating;
import com.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by mbelo on 15.07.2019.
 */
@RestController
@RequestMapping("/Film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @PostMapping("")
    public Long saveFilm(@RequestBody Film film){
        return filmService.saveFilm(film);
    }

    @GetMapping("/{id}")
    public Film get(@PathVariable Long id){
        return filmService.findFimlById(id);
    }

    @GetMapping("/setRating")
    public Long setRating(){
        return filmService.setRatingById(1L,2L);
    }
}
