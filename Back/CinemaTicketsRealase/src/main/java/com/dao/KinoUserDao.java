package com.dao;

import com.models.KinoUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KinoUserDao extends JpaRepository <KinoUser,Long> {
}
