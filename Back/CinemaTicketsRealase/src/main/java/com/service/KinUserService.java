package com.service;
import com.models.Card;
import com.models.KinoUser;
import com.models.Position;

import java.util.List;

public interface KinUserService {
    Long saveKinoUser(KinoUser kinoUser);
    KinoUser findKinoUserById(Long id);
    Long updateKinoUser(KinoUser kinoUser);
    void deleteById(Long id);
    List<Card> getCardsById(Long id);
    Long setPositionKinoUserById(Long idPosition, Long id);
    Position getPositionKinoUserById(Long id);
    Long saveCard(Long id, Card card);
    Long savePosition(Position position);
}
