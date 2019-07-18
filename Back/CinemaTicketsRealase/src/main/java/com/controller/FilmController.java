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

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }
    ///=================================Film========================
    @PostMapping("")
    public Long saveFilm(@RequestBody Film film){
        return filmService.saveFilm(film);
    }
    @PutMapping("")
    public Long updateFilm(@RequestBody Film film){
        return filmService.updateFilmById(film);
    }
    @DeleteMapping("/{id}")
    public void deleteFilmById(@PathVariable Long id){
    filmService.deleteFilmById(id);
    }
    @GetMapping("/{id}")
    public Film get(@PathVariable Long id){
        return filmService.findFilmById(id);
    }
    @GetMapping("")
    public List <Film> getAll(){
        return filmService.findAllFilm();
    }

    ///=================================TypeFilm========================
    @GetMapping("/type")
    public List<TypeFilm> getType(){
        return filmService.findAllTypeFilm();
    }
    @PutMapping("/type")
    public Long update(@RequestBody TypeFilm typeFilm){
       return filmService.updateTypeFilm(typeFilm);
    }

    ///=================================Genre========================
    @GetMapping("/genre")
    public List<Genre> getGenre(){
        return filmService.findAllGenre();
    }
    @PutMapping("/genre")
    public Long update(@RequestBody Genre genre){
        return filmService.updateGenre(genre);
    }

    ///=================================LimitAge========================
    @GetMapping("/limitAge")
    public List<LimitAge> getLimitage(){
        return filmService.findAllLimitAge();
    }
    @PutMapping("/limitAge")
    public Long updateLimitAge(LimitAge limitAge){
        return filmService.updateLimitAge(limitAge);
    }


}
