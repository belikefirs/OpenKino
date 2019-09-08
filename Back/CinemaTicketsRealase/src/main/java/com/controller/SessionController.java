package com.controller;

import com.masks.SessionMask;
import com.fasterxml.jackson.annotation.JsonView;
import com.models.Session;
import com.service.SessionService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/saveAll")
    public Long saveSessionVer2_0(    @JsonView(SessionMask.View.Save.class) @RequestBody SessionMask sessionMask){
        sessionMask.initSession();
        return sessionService.saveSessionVer2_0(sessionMask);
    }
    @GetMapping("/get/{id}")
    public @ResponseBody Session getSession(@PathVariable Long id){
        return  sessionService.getSession(id);
    }
}
