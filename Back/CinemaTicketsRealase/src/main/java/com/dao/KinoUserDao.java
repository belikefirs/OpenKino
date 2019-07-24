package com.dao;

import com.models.KinoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KinoUserDao extends JpaRepository <KinoUser,Long> {
    KinoUser findByMailOrPhone(String mail, String phone);
@Query(value = "SELECT * FROM KINOUSER WHERE KINOUSER.MAIL = :mail", nativeQuery = true)
    KinoUser findKinoUsersByName(@Param ("mail") String mail );
}
