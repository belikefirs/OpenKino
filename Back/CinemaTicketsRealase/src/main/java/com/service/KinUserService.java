package com.service;
import com.models.KinoUser;
import com.models.Position;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface KinUserService extends UserDetailsService {
    Long saveKinoUser(KinoUser kinoUser);
    Long updateKinoUser(KinoUser kinoUser);

    KinoUser findKinoUserById(Long id);
    void deleteById(Long id);
    List<KinoUser> findKinoUserAll();

    Long action_true(KinoUser kinoUser);
    Long action_false(KinoUser kinoUser);

    Long setPositionKinoUserById(Long idPosition, Long id);
    Position getPositionKinoUserById(Long id);
    Long savePosition(Position position);

    KinoUser findKinoUserByMail(String mail);
}
