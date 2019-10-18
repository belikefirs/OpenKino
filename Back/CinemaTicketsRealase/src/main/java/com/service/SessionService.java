package com.service;

import com.models.Place;
import com.models.Session;

import java.awt.*;
import java.util.List;

public interface SessionService {

    Long saveSession(Session session);
    Long createPlaces(Long idSession);
    void updateBroken(Long idSession, List<Point> pointsPlaces);
    void deleteSession(Long id);
    List<Session> findSessionByFilm(Long id_film);
    Long saveAllSession(Session session, Long idFilm, Long idHall);
    List<Session> findSessionAll();
    Session getSession(Long id);
    List<Place> getPlace(Long idSession);
}
