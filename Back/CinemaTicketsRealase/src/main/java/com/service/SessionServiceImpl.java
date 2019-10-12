package com.service;

import com.dao.*;
import com.enums.Pstatus;
import com.masks.SessionMask;
import com.models.*;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class SessionServiceImpl implements SessionService {

    private FilmDao filmDao;
    private HallDao hallDao;
    private SessionDao sessionDao;
    private HallService hallService;
    private PlaceDao placeDao;
private HallTempleteDao hallTempleteDao;


    @Override
    public List<Session> findSessionByFilm(Long id_film) {
        List<Session> sessions = sessionDao.findAllByFilm_Id(id_film);
        for (Session e : sessions) {
            Hibernate.initialize(e.getHall().getPlaces());
        }
        return sessions;
    }

    @Override
    public Long saveAllSession(Session session, Long idFilm, Long idHall) {
        Film film = filmDao.findById(idFilm).get();
        Hall hall = hallDao.findById(idHall).get();
        session.setFilm(film);
        session.setHall(hall);
        return sessionDao.save(session).getId();
    }


    @Override
    public void deleteSession(Long id) {
        sessionDao.deleteById(id);
    }

    @Override
    public Long updateSession(SessionMask sessionMask) {
        Session session1 = sessionDao.findById(sessionMask.getId()).get();
        session1.setStart(sessionMask.getStart());
        session1.setFilm(filmDao.findById(sessionMask.getId()).get());
        session1.setHall(hallDao.findById(sessionMask.getId()).get());
      //  session1.setEnd(sessionMask.getEnd());
        return sessionDao.save(session1).getId();
    }

    @Override
    public Long saveSession(Session session) {
        Hall hall = hallDao.findById(session.getIdHall()).get();
        session.setHall(hall);
       // session.setEnd(session.getStart().plusMinutes(film.getLenght()));
        return sessionDao.save(session).getId();
    }

    @Override
    public void addSession() {
        Session session = new Session();
        session.setStart(LocalDateTime.of(1994, Month.APRIL, 15, 11, 30));
        sessionDao.save(session);
    }

    @Override
    public List<Session> findSessionAll() {
        List<Session> sessions = sessionDao.findAll();
        for (Session e : sessions) {
            initLazySessionFields(e);
        }
        return sessions;
    }

    public void initLazySessionFields(Session e) {
        e.getHall().getSessions().size();
        e.getHall().getPlaces().size();
        e.getFilm().getId();
    }

    @Override
    public Long saveSessionVer2_0(SessionMask sessionMask, BigDecimal price) {
        Film film = filmDao.findById(sessionMask.getFilm()).get();
        Hall hall = new Hall();
        HallTemplete hallTemplete = hallTempleteDao.findById(sessionMask.getHallTemplete()).get();
      //  hall.setNumber(hallTemplete.getNumber());
        hall.setWidth(hallTemplete.getWidth());
        hall.setHeight(hallTemplete.getHeight());
        hallService.save(hall, price);
        Session session = sessionMask.getSession();
        session.setFilm(film);
        session.setHall(hall);
        return sessionDao.save(session).getId();
    }

    @Override
    public Session getSession(Long id) {
        Session session = sessionDao.findById(id).get();
        session.getHall().getPlaces().size();
        session.getHall().getSessions().size();
        session.getPlaces().size();
        return session;
    }

    @Override
    public Long cretedPlaces(Long numberHall, Long idSession) {
        Hall hall = hallDao.getNumberHall(numberHall);
        Session session = sessionDao.findById(idSession).get();
        List<Place> places = new ArrayList<Place>();
        for(int y = 1; y <= hall.getHeight()+1; y++){
            for(int x = 1; x <=hall.getWidth()+1; x++){
                Place place = new Place();
                place.setHall(hall);
                place.setSession(session);
                place.setX(x);
                place.setY(y);
                place.setStatus(Pstatus.IsFree);
                placeDao.save(place);
                places.add(place);
            }
        }
        hall.setPlaces(places);
        session.setPlaces(places);
        return sessionDao.save(session).getId();
    }

    @Override
    public void updateBroken(Long idSession, List<Point> pointsPlaces) {
        Session session = sessionDao.findById(idSession).get();
        for(int j = 0; j < session.getPlaces().size(); j++){
        for(int i = 0; i < pointsPlaces.size(); i++) {
            if ((session.getPlaces().get(j).getX() == pointsPlaces.get(i).x) &&
                    (session.getPlaces().get(j).getY() == pointsPlaces.get(j).y)) {
                session.getPlaces().get(j).setStatus(Pstatus.IsBroken);
                placeDao.save(session.getPlaces().get(j));
            }
        }

        }
        sessionDao.save(session);
    }

    @Override
    public List<Place> getPlace(Long idSession) {
        Session session = sessionDao.findById(idSession).get();
        session.getPlaces().size();
        return session.getPlaces();
    }
}
