package com.dao;

import com.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionDao extends JpaRepository<Session,Long> {
    List<Session> findAllByFilm_Id(Long id_film);
}
