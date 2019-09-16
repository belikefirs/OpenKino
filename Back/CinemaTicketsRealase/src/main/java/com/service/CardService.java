package com.service;
import com.masks.CardMask;
import com.models.Card;
import com.models.KinoUser;

import java.math.BigDecimal;
import java.util.List;

public interface CardService {
    Long saveCard(CardMask card, KinoUser kinoUser);
    void deleteCardById(Long id);
    List <Card> findCardsByIdKinoUser(Long id);
    Long addBalance(Long id, BigDecimal money);
}
