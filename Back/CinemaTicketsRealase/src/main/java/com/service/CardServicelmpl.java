package com.service;
import com.components.Desiariseble;
import com.components.SpecialCard;
import com.dao.CardDao;
import com.dao.KinoUserDao;
import com.models.Card;
import com.models.KinoUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

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
    public Long saveall(SpecialCard Scard) {
        Desiariseble desirialiseble = new Desiariseble(Scard);
        try {
            desirialiseble.whenSerializingAndDeserializing_ThenObjectIsTheSame();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        SpecialCard specialCard = desirialiseble.getSpecialCard1();
        Card card = new Card();
        KinoUser kinoUser = kinoUserDao.findById(specialCard.getIdKinUser()).get();
        card.setBalance(specialCard.getBalance());
        card.setKinoUser(kinoUser);
        card.setBuys(specialCard.getBuyList());
        return cardDao.save(card).getId();
    }

    @Override
    public void deleteCardById(Long id) {
          cardDao.deleteById(id);
    }

    @Override
    public List<Card> findCardsByIdKinoUser(Long id) {
        return cardDao.findAllByKinoUserId(id);
    }

    @Override
    public Long addBalance(Long id, BigDecimal money) {
        Card card = cardDao.findById(id).get();
        card.setBalance(card.getBalance().add(money));
        return cardDao.save(card).getId();
    }
}
