package com.service;
import com.models.Card;
import com.models.KinoUser;
import com.models.Position;

import java.util.List;

public interface KinUserService {
    Long saveKinoUser(KinoUser kinoUser);
    KinoUser findKinoUserById(Long id);
    Long updateKinoUserById(Long id,String name,String fname, Integer age, String phone, String mail);
    Long updatePasswordById(Long id, String password);
    void deleteById(Long id);
    List<Card> getCardsById(Long id);
    Long setPositionKinoUserById(Long idPosition, Long id);
    Position getPositionKinoUserById(Long id);
    Long saveCard(Long id, Card card);
    Long savePosition(Position position);
}
