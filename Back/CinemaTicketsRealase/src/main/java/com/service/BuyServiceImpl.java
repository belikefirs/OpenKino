package com.service;

import com.dao.BuyDao;
import com.dao.CardDao;
import com.dao.KinoUserDao;
import com.models.Buy;
import com.models.Card;
import com.models.KinoUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BuyServiceImpl implements BuyService {
    private BuyDao buyDao;
    private CardDao cardDao;
    private KinoUserDao kinoUserDao;

    public BuyServiceImpl(BuyDao buyDao, CardDao cardDao, KinoUserDao kinoUserDao) {
        this.buyDao = buyDao;
        this.cardDao = cardDao;
        this.kinoUserDao = kinoUserDao;
    }

    @Override
    public Long saveBuy(Buy buy) {
        if (buy.getCard().getBalance()-buy.getPrice() >= 0) {
            Card card = buy.getCard();
            card.setBalance(buy.getCard().getBalance()-buy.getPrice());
            buy.setCard(card);
            return buyDao.save(buy).getId();
        }
        else {
            return null;
        }
    }

    @Override
    public Buy findBuyById(Long id) {
        return buyDao.findById(id).get();
    }

    @Override
    public Long saveBuyByKinoUser(Buy buy, KinoUser kinoUser) {
        KinoUser kinoUser1 = kinoUserDao.findById(kinoUser.getId()).get();
        if ( cardDao.findById(buy.getCard().getId()).equals(Optional.ofNullable(null))){
            Card card = buy.getCard();
            if (buy.getCard().getBalance()-buy.getPrice() >= 0) {
                card.setBalance(card.getBalance()-buy.getPrice());
                card.setKinoUser(kinoUser1);
                return buyDao.save(buy).getId();
            }
            else {
                return null;
            }
        }
        else {
            Card card = cardDao.findById(buy.getCard().getId()).get();
            if (card.getBalance()-buy.getPrice() >= 0){
                card.setBalance(card.getBalance()-buy.getPrice());
                buy.setCard(card);
                return buyDao.save(buy).getId();
            }
            else {
                return null;
            }
        }
    }
}
