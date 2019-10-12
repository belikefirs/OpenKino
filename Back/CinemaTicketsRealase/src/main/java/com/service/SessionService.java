package com.service;

import com.masks.SessionMask;
import com.models.Place;
import com.models.Session;
import javafx.print.PageLayout;

import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

public interface SessionService {

    Long saveSession(Session session);
    Long cretedPlaces(Long numberHall, Long idSession);
    void updateBroken(Long idSession, List<Point> pointsPlaces);
    void deleteSession(Long id);
    Long updateSession(SessionMask sessionMask);
  //  Session findSessionById(Long id);
    List<Session> findSessionByFilm(Long id_film);
    Long saveAllSession(Session session, Long idFilm, Long idHall);
void addSession();
    List<Session> findSessionAll();
    Long saveSessionVer2_0(SessionMask sessionMask, BigDecimal price);
    Session getSession(Long id);
    List<Place> getPlace(Long idSession);
}
