package com.controller;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.models.*;
import com.service.FilmService;
import com.service.FilmServiceImpl;
import com.view.Views;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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

    @JsonView(Views.Internal.class)
    @GetMapping("/{id}")
    public Film get(@PathVariable Long id){
        return filmService.findFilmById(id);
    }

    @JsonView(Views.Internal.class)
    @GetMapping("")
    public List <Film> getAll(@RequestParam(name = "name",required = false) String name ,
                              @RequestParam(name = "limitAge" ,required = false) Integer limitAge,
                              @RequestParam(name = "rating" ,required = false) Double rating,
                              @RequestParam(name = "typeFilm" ,required = false) String typeFilm,
                              @RequestParam(name = "genre" ,required = false) String genre){
        return filmService.findFilmsByVars(name,genre,typeFilm,rating,limitAge);
    }


    ///=================================TypeFilm========================
    @JsonView(Views.Internal.class)
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
    @JsonView(Views.Internal.class)
    public List<Genre> getGenre(){
        return filmService.findAllGenre();
    }

    @PutMapping("/genre")
    public Long update(@RequestBody Genre genre){
        return filmService.updateGenre(genre);
    }

    ///=================================LimitAge========================
    @GetMapping("/limitAge")
    @JsonView(Views.Internal.class)
    public List<LimitAge> getLimitage(){
        return filmService.findAllLimitAge();
    }

    @PutMapping("/limitAge")
    public Long updateLimitAge(@RequestBody LimitAge limitAge){
        return filmService.updateLimitAge(limitAge);
    }

    ///=================================Rating========================
    @JsonView(Views.Internal.class)
    @GetMapping("/rating")
    public List <Rating> getRating(){
        return filmService.findAllRating();
    }

    @PutMapping("/rating")
    public Long updateRating(@RequestBody Rating rating){
        return filmService.updateRating(rating);
    }

    @JsonView(Views.Internal.class)
    @PostMapping("/load")
    public Long loadImage(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) throws IOException {
        return filmService.loadImage(file, id);
    }

    @JsonView(Views.Internal.class)
    @GetMapping("/get-image")
    public ResponseEntity<byte[]> getImageWithMediaType(@RequestParam("id") Long id) throws IOException {
        Film film = filmService.findFilmById(id);
        Image image1 = filmService.getImage( film.getImage().getId());
        InputStream targetStream = new ByteArrayInputStream(image1.getImage_array());
        return ResponseEntity.ok().header("content-type", image1.getType()).body(IOUtils.toByteArray(targetStream))  ;
    }

    @DeleteMapping("/image/{id}")
    public void deleteImageById(@PathVariable Long id){
        filmService.deleteImage(id);
    }

    @JsonView(Views.Internal.class)
    @GetMapping("/image/all")
    public List<Image> getAllImage(){
        return filmService.getAllImage();
    }

    @PutMapping("image/update")
    public Long updateFilm(@RequestBody Image image){
        return filmService.updateImage(image);
    }

    @JsonView(Views.Internal.class)
    @PostMapping("/load/update")
    public Long loadImageUpd(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) throws IOException {
        return filmService.loadImageUpdate(file, id);
    }
}
