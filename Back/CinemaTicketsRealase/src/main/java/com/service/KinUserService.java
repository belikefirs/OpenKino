package com.service;
import com.models.Card;
import com.models.KinoUser;

import java.util.List;

public interface KinUserService {
    Long saveKinoUser(KinoUser kinoUser);
    KinoUser getKinoUserById(Long id);
    Long updateKinoUserById(Long id);
    void deleteById(Long id);
    List<Card> getCard(Long id);
}
