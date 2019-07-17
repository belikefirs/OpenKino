package com.controller;

import com.dao.CardDao;
import com.models.Card;
import com.models.Film;
import com.models.Rating;
import com.models.TypeFilm;
import com.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mbelo on 15.07.2019.
 */
@RestController
@RequestMapping("/Film")
public class FilmController {

    @Autowired
    private FilmService filmService;
    @Autowired
    private CardDao cardDao;

    @PostMapping("")
    public Long saveFilm(@RequestBody Film film){
        return filmService.saveFilm(film);
    }

    @GetMapping("/{id}")
    public Film get(@PathVariable Long id){
        return filmService.findFimlById(id);
    }

    @GetMapping("/type")
    public List<TypeFilm> getType(){
        return filmService.findAllTypeFilm();
    }


    @GetMapping("/test/{id}")
    public List<Card> getCard(@PathVariable Long id){
        return cardDao.findAllByKinoUserId(id);
    }
}
