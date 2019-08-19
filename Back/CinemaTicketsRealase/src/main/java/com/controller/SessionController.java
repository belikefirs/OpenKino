package com.controller;

import com.models.Session;
import com.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/save/{id_film},{id_hall},{time}")
    public Long saveSession(@PathVariable  Long id_film, @PathVariable  Long id_hall,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd@HH:mm")Date time) {
        return sessionService.saveSession(id_film,id_hall,time);
    }

    @GetMapping("/{id_film}")
    public List<Session> getSessionAll(@PathVariable  Long id_film){
        return sessionService.findSessionByFilm(id_film);
    }

   /* @PutMapping("/update")
    public Long updateKinoUser(@RequestBody Session kinoUser) {
        return sessionService.updateSession(kinoUser);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteKinoUser(@PathVariable Long id) {
        sessionService.deleteById(id);
    }*/
}
