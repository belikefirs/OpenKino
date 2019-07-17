package com.controller;
import com.models.Film;
import com.models.Genre;
import com.models.LimitAge;
import com.models.TypeFilm;
import com.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @PostMapping("")
    public Long saveFilm(@RequestBody Film film){
        return filmService.saveFilm(film);
    }

    @PutMapping("/updateFilm")
    public Long updateFilm(@RequestBody Film film){
        return filmService.updateFilmById(film);
    }

    @GetMapping("/{id}")
    public Film get(@PathVariable Long id){
        return filmService.findFilmById(id);
    }
    @GetMapping("/all")
    public List <Film> getAll(){
        return filmService.findAllFilm();
    }

    @GetMapping("/type")
    public List<TypeFilm> getType(){
        return filmService.findAllTypeFilm();
    }

    @GetMapping("/genre")
    public List<Genre> getGenre(){
        return filmService.findAllGenre();
    }

    @GetMapping("/limitAge")
    public List<LimitAge> getLimitage(){
        return filmService.findAllLimitAge();
    }





}
