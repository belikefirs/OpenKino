package com.service;
import com.dao.CardDao;
import com.dao.KinoUserDao;
import com.models.Card;
import com.models.KinoUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class CardServicelmpl implements CardService{
    private CardDao cardDao;
    private KinoUserDao kinoUserDao;

    public CardServicelmpl(CardDao cardDao, KinoUserDao kinoUserDao) {
        this.cardDao = cardDao;
        this.kinoUserDao = kinoUserDao;
    }

    @Override
    public Long saveCard(Card card, Long kinoUserId) {
        KinoUser kinoUser = kinoUserDao.findById(kinoUserId).get();
        cardDao.save(card);
        card.setKinoUser(kinoUser);
        return card.getId();
    }

    @Override
    public void deleteCardById(Card card) {

    }

    @Override
    public Card findCardById(Long Id) {
        return null;
    }

    @Override
    public Long setCardKinoUserById(Long id, Long idCard) {
        return null;
    }
}
