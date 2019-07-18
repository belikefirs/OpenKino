package com.service;
import com.models.*;
public interface CardService {
    Long saveCard(Card card, Long kinoUserId);
    void deleteCardById(Long id);
    Card findCardById(Long Id);


    Long setCardKinoUserById(Long id, Long idCardKinoUser);


}
