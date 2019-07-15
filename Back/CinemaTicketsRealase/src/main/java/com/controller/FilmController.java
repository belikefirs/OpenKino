package com.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.models.Film;
import com.models.Genre;
import com.models.LimitAge;
import com.models.Rating;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilmController {
    public static final int N = 10;
    private List<Film> filmList;
    public Long id;
    public String name;
    public Long lenght;
    public Genre genre;
    public LimitAge limitAge;
    public Rating rating;
    public FilmController(){
        filmList = new ArrayList<Film>(N);
        for (int i = 0; i < N; i++){
            Film film = new Film();
            genre = new Genre();
            limitAge = new LimitAge();
            rating = new Rating();
            genre.setId((long) (i*10%5));
            limitAge.setId((long) (i*10%4));
            rating.setId(i*10%2);
            film.setId((long) i);
            film.setName("Film vol. " + i+1);
            film.setLenght((long) (i*38.8));
            film.setGenre(genre);
            film.setLimitAge(limitAge);
            film.setRating(rating);
            filmList.add(film);
        }
    }
    @GetMapping("/films")
    public List<Film> getFilms(){
        System.out.println(filmList.size());
        return  filmList;
    }
    @GetMapping("/films1")
    public List<Film> getFilmsAgeId(@RequestParam("ageId") int ageId){
        List<Film> films1 = new ArrayList<Film>();
        for(int i = 0; i < filmList.size(); i++ ){
            if(filmList.get(i).getLimitAge().getId() > 20 ){
                films1.add(filmList.get(i));
            }
        }
        return films1;
    }
}
