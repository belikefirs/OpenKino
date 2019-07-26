package com.service;
import com.models.*;

import java.util.List;

public interface CardService {
    Long saveCard(Card card, KinoUser kinoUser);
    void deleteCardById(Long id);
    List <Card> findCardsByIdKinoUser(Long id);
    Long addBalance(Long id, Double money);
}
