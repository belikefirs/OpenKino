package com.controller;

import com.models.Session;
import com.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/save")
    public Long saveSession(@RequestBody Session session) {
        return sessionService.saveSession(session);
    }

    @GetMapping("/get")
    public List<Session> getSessionAll(){
        return sessionService.findSessionAll();
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
