package com.service;

import com.models.Film;
import com.models.Session;

import java.util.List;

public interface SessionService {

    Long saveSession(Session session);
    void deleteSessionById(Long id);
    Long updateSesById(Session session);
    Session findSessionById(Long id);

}
