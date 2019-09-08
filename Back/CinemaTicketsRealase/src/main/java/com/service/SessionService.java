package com.service;

import com.masks.SessionMask;
import com.models.Session;

import java.util.List;

public interface SessionService {

    Long saveSession(Session session);
    void deleteSession(Long id);
    Long updateSession(SessionMask sessionMask);
  //  Session findSessionById(Long id);
    List<Session> findSessionByFilm(Long id_film);
    Long saveAllSession(Session session, Long idFilm, Long idHall);
void addSession();
    List<Session> findSessionAll();
    Long saveSessionVer2_0(SessionMask sessionMask);
    Session getSession(Long id);
}
