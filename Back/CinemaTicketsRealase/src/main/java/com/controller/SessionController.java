package com.controller;

import com.models.Session;
import com.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/save")
    public Long saveSession(@RequestBody Session session, @RequestParam(name = "idFilm")Long idFilm,
                            @RequestParam(name = "idHall") Long idHall) {
        return sessionService.saveAllSession(session, idFilm, idHall);
    }

    @GetMapping("/{id_film}")
    public List<Session> getSessionAll(@PathVariable  Long id_film){
        return sessionService.findSessionByFilm(id_film);
    }
    @GetMapping("/all")
    public List<Session> SessionAll(){
        return sessionService.findSessionAll();
    }

    @PutMapping("/update")
    public Long updateKinoUser(@RequestBody Session session) {
        return sessionService.updateSession(session);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteKinoUser(@PathVariable Long id) {
        sessionService.deleteSession(id);
    }

}
