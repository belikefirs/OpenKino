package com.dao;

import com.models.TypeFilm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeFilmDao extends JpaRepository<TypeFilm,Long> {
}
