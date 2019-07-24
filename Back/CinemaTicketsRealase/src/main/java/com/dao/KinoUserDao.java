package com.dao;

import com.models.KinoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KinoUserDao extends JpaRepository <KinoUser,Long> {
    KinoUser findByMailOrPhone(String mail, String phone);
}
