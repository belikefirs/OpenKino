package com.service;

import com.dao.BuyDao;
import com.dao.CardDao;
import com.dao.KinoUserDao;
import com.dao.ReservationDao;
import com.masks.BuyMask;
import com.models.Buy;
import com.models.Card;
import com.models.KinoUser;
import com.models.Reservation;
import com.sun.xml.internal.ws.handler.HandlerException;
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
    private ReservationDao reservationDao;
    final static Logger logger = Logger.getLogger(BuyServiceImpl.class);

    public BuyServiceImpl(BuyDao buyDao, CardDao cardDao, KinoUserDao kinoUserDao, ReservationDao reservationDao) {
        this.buyDao = buyDao;
        this.cardDao = cardDao;
        this.kinoUserDao = kinoUserDao;
        this.reservationDao = reservationDao;
    }

    @Override
    public Buy findBuyById(Long id) {
        return buyDao.findById(id).get();
    }

    @Override
    public Long saveBuy(BuyMask buyMask, KinoUser kinoUser) {
        if (kinoUser != null) {
            Buy buy = new Buy();
            Card card = new Card();
            card.setId(buyMask.getCardMask().getId());
            card.setBalance(buyMask.getCardMask().getBalance());
            card.setKinoUser(kinoUser);
            buy.setCard(card);
            buy.setReservation(reservationDao.findById(buyMask.getIdReservation()).get());
            KinoUser kinoUser1 = kinoUserDao.findById(kinoUser.getId()).get();
            Reservation reservation = reservationDao.findById(buy.getReservation().getId()).get();
            buy.setPrice(reservation.getPrice());
            reservation.setBuy(buy);
            BigDecimal result = new BigDecimal(String.valueOf(
                    buy.getCard().getBalance().subtract(buy.getPrice())));
            card = buy.getCard();
            if (result.compareTo(BigDecimal.valueOf(0)) >= 0) {
                card.setBalance(result);
                card.setKinoUser(kinoUser1);
                return buyDao.save(buy).getId();
            } else throw new HandlerException("not enough money");
        } else {
            throw new HandlerException("no user");
        }
    }



    @Override
    public void deleteBuyById(Long id) {
        buyDao.deleteById(id);
    }
}
