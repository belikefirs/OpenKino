package com.service;

import com.dao.BuyDao;
import com.dao.CardDao;
import com.dao.KinoUserDao;
import com.models.Buy;
import com.models.Card;
import com.models.KinoUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
       return buyDao.save(buy).getId();
    }

    @Override
    public Buy findBuyById(Long id) {
        return buyDao.findById(id).get();
    }

    @Override
    public Long saveBuyByKinoUser(Buy buy, KinoUser kinoUser) {
        KinoUser kinoUser1 = kinoUserDao.findById(kinoUser.getId()).get();
        Card card = buy.getCard();
        card.setKinoUser(kinoUser1);
        return buyDao.save(buy).getId();
    }
}
