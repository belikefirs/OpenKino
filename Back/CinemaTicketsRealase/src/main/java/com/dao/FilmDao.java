package com.dao;

import com.models.Film;
import com.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmDao extends JpaRepository<Film, Long> {
}
