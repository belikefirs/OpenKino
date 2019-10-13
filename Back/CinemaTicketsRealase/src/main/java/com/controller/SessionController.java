package com.controller;

import com.masks.SessionMask;
import com.fasterxml.jackson.annotation.JsonView;
import com.models.Film;
import com.models.Place;
import com.models.Session;
import com.service.SessionService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {


    private SessionService sessionService;
    public SessionController(SessionService sessionService){
        this.sessionService = sessionService;
    }

    @PostMapping("/save")
    public Long saveSession(@RequestBody Session session, @RequestParam(name = "idFilm")Long idFilm,
                            @RequestParam(name = "idHall") Long idHall) {
        return sessionService.saveAllSession(session, idFilm, idHall);
    }

    @GetMapping("/{id_film}")
    public List<Session> getSessionAll(@PathVariable  Long id_film){
        return sessionService.findSessionByFilm(id_film);
    }
    @JsonView(Session.View.Public.class)
    @GetMapping("/all")
    public List<Session> SessionAll(){
        return sessionService.findSessionAll();
    }

    @PutMapping("/update")
    public Long updateKinoUser(@RequestBody SessionMask session) {
        return sessionService.updateSession(session);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteKinoUser(@PathVariable Long id) {
        sessionService.deleteSession(id);
    }

    @PostMapping(value = "/saveAll/")
    public Long saveSessionVer2_0(@JsonView(SessionMask.View.Save.class) @RequestBody SessionMask sessionMask, @RequestParam(name = "price") BigDecimal price){
        sessionMask.initSession();
        return sessionService.saveSessionVer2_0(sessionMask, price);
    }
    @GetMapping("/get/{id}")
    public @ResponseBody Session getSession(@PathVariable Long id){
        return  sessionService.getSession(id);
    }
    @PostMapping("")
    public Long saveV2(@RequestBody Session session){
        return sessionService.saveSession(session);
    }
    @PutMapping("")
    public Long createdPlace(@RequestParam(name = "number")Long num,
                             @RequestParam(name = "idSession")Long idSession, @RequestBody Session session){
       Long id = sessionService.cretedPlaces(num, idSession);
        return id;
    }
    @JsonView(Place.View.Public.class)
    @GetMapping("/list/{id}")
    public List<Place> getPlace(@PathVariable Long id){
        return sessionService.getPlace(id);
    }
}
