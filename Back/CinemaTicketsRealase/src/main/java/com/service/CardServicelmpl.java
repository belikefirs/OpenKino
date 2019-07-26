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
    public Long saveCard(Card card, KinoUser kinoUser) {
        KinoUser kinoUser1 = kinoUserDao.findById(kinoUser.getId()).get();
        card.setKinoUser(kinoUser1);
        cardDao.save(card);
        return card.getId();
    }

    @Override
    public void deleteCardById(Long id) {
          cardDao.deleteById(id);
    }

    @Override
    public Card findCardById(Long id) {
        return cardDao.findById(id).get();

    }

    @Override
    public Long setCardKinoUserById(Long id, Long idCard) {
        return null;
    }

    @Override
    public Long addBalance(Long id, Double money) {
        Card card = cardDao.findById(id).get();
        card.setBalance(card.getBalance()+money);
        return cardDao.save(card).getId();
    }
}
