package com.service;

import com.dao.FilmDao;
import com.dao.HallDao;
import com.dao.SessionDao;
import com.models.Film;
import com.models.Hall;
import com.models.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Long saveSession(Session session) {
        return sessionDao.save(session).getId();
    }

    @Override
    public void deleteSessionById(Long id) {
        sessionDao.deleteById(id);
    }

    @Override
    public Long updateSesById(Session session) {
       Session session1 = sessionDao.findById(session.getId()).get();
       session1.setName(session.getName());
       session1.setStart(session.getStart());
       session1.setEnd(session.getEnd());
        session.setFilm(session.getFilm());
        session1.setHall(session.getHall());
        return sessionDao.save(session1).getId();
    }

    @Override
    public Session findSessionById(Long id) {
        return sessionDao.findById(id).get();
    }
}
