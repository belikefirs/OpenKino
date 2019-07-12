package com.dao;

import com.models.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureDao extends JpaRepository<Picture,Long> {
}
