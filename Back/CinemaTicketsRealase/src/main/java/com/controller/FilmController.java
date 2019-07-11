package com.controller;

import com.models.Film;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilmController {
    public static final int N = 10;
    private List<Film> filmList;

    public FilmController(){
        filmList = new ArrayList<Film>(N);
        for (int i = 0; i < filmList.size(); i++){
            Film film = new Film();
            filmList.set(i, film);
        }
    }
    @GetMapping("/films")
    public List<Film> getFilmsId(){
        filmList = new ArrayList<Film>();
       for(int i = 0; i < 10;i++){
           filmList.get(i).setId(i);
       }
        return  filmList;
    }
    @GetMapping("/films1")
    public List<Film> getFilmsName(){
        filmList = new ArrayList<Film>();
        for(int i = 0; i < 10;i++){
            filmList.get(i).setName("VOL: " + i);
        }
        return  filmList;
    }
    @GetMapping("/films2")
    public List<Film> getFilmsLenght(){
        filmList = new ArrayList<Film>();
        for(int i = 0; i < 10;i++){
            filmList.get(i).setLenght((long) (i * 35.8)) ;
        }
        return  filmList;
    }

}
