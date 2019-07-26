package com.service;
import com.models.*;
public interface CardService {
    Long saveCard(Card card, KinoUser kinoUser);
    void deleteCardById(Long id);
    Card findCardById(Long Id);

    Long addBalance(Card card);

    Long setCardKinoUserById(Long id, Long idCardKinoUser);


}
