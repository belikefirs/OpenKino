package com.service;

import com.models.Film;
import com.models.Session;

import java.util.List;

public interface SessionService {

    Long saveSession(Session session);
    void deleteSession(Long id);
    Long updateSession(Session session);
  //  Session findSessionById(Long id);
    List<Session> findSessionAll();

}
