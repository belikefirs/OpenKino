package com.dao;

import com.models.Card;
import com.models.KinoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KinoUserDao extends JpaRepository <KinoUser,Long> {
}
