package com.service;

import com.dao.HallTempleteDao;
import com.masks.SessionMask;
import com.dao.FilmDao;
import com.dao.HallDao;
import com.dao.SessionDao;
import com.models.Film;
import com.models.Hall;
import com.models.HallTemplete;
import com.models.Session;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Service
@Transactional
public class SessionServiceImpl implements SessionService {

    private FilmDao filmDao;
    private HallDao hallDao;
    private SessionDao sessionDao;
    private HallService hallService;
private HallTempleteDao hallTempleteDao;

    public SessionServiceImpl(FilmDao filmDao, HallDao hallDao, SessionDao sessionDao, HallService hallService, HallTempleteDao hallTempleteDao) {
        this.filmDao = filmDao;
        this.hallDao = hallDao;
        this.sessionDao = sessionDao;
        this.hallService = hallService;
        this.hallTempleteDao = hallTempleteDao;
    }

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
        session1.setEnd(sessionMask.getEnd());
        return sessionDao.save(session1).getId();
    }

    @Override
    public Long saveSession(Session session) {
        Film film = filmDao.findById(session.getFilm().getId()).get();
        session.setEnd(session.getStart().plusMinutes(film.getLenght()));
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
        hall.setNumber(hallTemplete.getNumber());
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
        session.getFilm().getId();

        return session;
    }
}
