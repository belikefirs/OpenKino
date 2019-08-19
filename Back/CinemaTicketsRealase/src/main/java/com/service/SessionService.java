package com.service;

import com.models.Film;
import com.models.Session;

import java.util.Date;
import java.util.List;

public interface SessionService {

    Long saveSession(Long id_film, Long id_hall, Date time);
    void deleteSession(Long id);
    Long updateSession(Session session);
  //  Session findSessionById(Long id);
    List<Session> findSessionByFilm(Long id_film);
    Long saveAllSession(Session session, Long idFilm, Long idHall);

}
