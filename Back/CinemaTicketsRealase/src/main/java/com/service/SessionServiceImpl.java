package com.service;

import com.components.SaveAllSession;
import com.dao.FilmDao;
import com.dao.HallDao;
import com.dao.SessionDao;
import com.models.Film;
import com.models.Hall;
import com.models.Session;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class SessionServiceImpl implements SessionService {

    private FilmDao filmDao;
    private HallDao hallDao;
    private SessionDao sessionDao;

    public SessionServiceImpl(FilmDao filmDao, HallDao hallDao, SessionDao sessionDao) {
        this.filmDao = filmDao;
        this.hallDao = hallDao;
        this.sessionDao = sessionDao;
    }

    @Override
    public List<Session> findSessionByFilm(Long id_film){
    List<Session> sessions = sessionDao.findAllByFilm_Id(id_film);
        for (Session e: sessions) {
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
    public void deleteSession(Long id)  {
        sessionDao.deleteById(id);
    }

    @Override
    public Long updateSession(Session session) {
        Session session1 = sessionDao.findById(session.getId()).get();
        session1.setStart(session.getStart());
        session1.setFilm(session.getFilm());
        session1.setHall(session.getHall());
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
        for (Session e: sessions) {
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
    public Long saveSessionVer2_0(SaveAllSession saveAllSession) {
        Film film = filmDao.findById(saveAllSession.getIdFilm()).get();
        Hall hall = hallDao.findById(saveAllSession.getIdHall()).get();
        Session session = saveAllSession.getSession();
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
