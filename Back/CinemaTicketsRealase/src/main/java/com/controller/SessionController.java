package com.controller;

import com.models.Session;
import com.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
@Autowired
    private SessionService sessionService;

@GetMapping("/save_session")
    public Long saveSession(Session session){
    session.setName("Утренняя");
    return sessionService.saveSession(session);
}
}
