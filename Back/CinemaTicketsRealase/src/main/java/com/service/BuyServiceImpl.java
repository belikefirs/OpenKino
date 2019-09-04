package com.service;

import com.dao.BuyDao;
import com.dao.CardDao;
import com.dao.KinoUserDao;

import com.models.Buy;
import com.models.Card;
import com.models.KinoUser;


import org.apache.log4j.Logger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


@Service
@Transactional
public class BuyServiceImpl implements BuyService {
    private BuyDao buyDao;
    private CardDao cardDao;
    private KinoUserDao kinoUserDao;
    final static Logger logger = Logger.getLogger(BuyServiceImpl.class);

    public BuyServiceImpl(BuyDao buyDao, CardDao cardDao, KinoUserDao kinoUserDao) {
        this.buyDao = buyDao;
        this.cardDao = cardDao;
        this.kinoUserDao = kinoUserDao;
    }

    @Override
    public Long saveBuy(Buy buy) {
        BigDecimal result = new BigDecimal(String.valueOf(
                buy.getCard().getBalance().subtract(buy.getPrice())));
        if (result.compareTo(BigDecimal.valueOf(0)) >=0 ) {
            Card card = buy.getCard();
            card.setBalance(result);
            buy.setCard(card);
            logger.info("Save Card ,by card :" + card.getId());
            return buyDao.save(buy).getId();
        }
        else return null;
    }

    @Override
    public Buy findBuyById(Long id) {
        return buyDao.findById(id).get();
    }

    @Override
    public Long saveBuyByKinoUser(Buy buy, KinoUser kinoUser) {
        KinoUser kinoUser1 = kinoUserDao.findById(kinoUser.getId()).get();
        BigDecimal result = new BigDecimal(String.valueOf(
                buy.getCard().getBalance().subtract(buy.getPrice())));
            Card card = buy.getCard();
            if (result.compareTo(BigDecimal.valueOf(0)) >= 0) {
                card.setBalance(result);
                card.setKinoUser(kinoUser1);
                return buyDao.save(buy).getId();
            }
            else return null;
        }



    @Override
    public void deleteBuyById(Long id) {
        buyDao.deleteById(id);
    }
}
