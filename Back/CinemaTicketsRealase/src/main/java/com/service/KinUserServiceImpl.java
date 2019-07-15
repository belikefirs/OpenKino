package com.service;

import com.dao.CardDao;
import com.dao.KinoUserDao;
import com.dao.PositionDao;
import com.models.Card;
import com.models.KinoUser;
import com.models.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mbelo on 14.07.2019.
 */

@Service
public class KinUserServiceImpl implements KinUserService {
    private KinoUserDao kinoUserDao;
    private CardDao cardDao;
    private PositionDao positionDao;

    public KinUserServiceImpl(KinoUserDao kinoUserDao, CardDao cardDao, PositionDao positionDao) {
        this.kinoUserDao = kinoUserDao;
        this.cardDao = cardDao;
        this.positionDao = positionDao;
    }

    @Override
    @Transactional
    public Long saveKinoUser(KinoUser kinoUser) {
        kinoUserDao.save(kinoUser);
        return kinoUser.getId();
    }

    @Override
    @Transactional
    public KinoUser findKinoUserById(Long id) {
        return kinoUserDao.findById(id).get();
    }

    @Override
    @Transactional
    public Long updateKinoUser(KinoUser kinoUser){
        KinoUser kinoUser1 = kinoUserDao.findById(kinoUser.getId()).get();
        kinoUser1.setName(kinoUser.getName());
        kinoUser1.setfName(kinoUser.getfName());
        kinoUser1.setAge(kinoUser.getAge());
        kinoUser1.setPhone(kinoUser.getPhone());
        kinoUser1.setMail(kinoUser.getMail());
        kinoUser1.setPassword(kinoUser.getPassword());
        kinoUser1.setPosition(kinoUser.getPosition());
        kinoUser1.setCards(kinoUser.getCards());
        return kinoUserDao.save(kinoUser1).getId();
    }


    @Override
    @Transactional
    public void deleteById(Long id) {
        kinoUserDao.deleteById(id);
    }

    @Override
    @Transactional
    public List<Card> getCardsById(Long id) {
        return null;
    }

    @Override
    public Long savePosition(Position position) {
        return positionDao.save(position).getId();
    }


    @Override
    @Transactional
    public Long setPositionKinoUserById(Long idPosition, Long id) {
        KinoUser kinoUser = kinoUserDao.findById(id).get();
        kinoUser.setPosition(positionDao.findById(idPosition).get());
        return kinoUserDao.save(kinoUser).getId();
    }

    @Override
    @Transactional
    public Position getPositionKinoUserById(Long id) {
        return kinoUserDao.findById(id).get().getPosition();
    }

    @Override
    @Transactional
    public Long saveCard(Long id,Card card) {
        card.setKinoUser(kinoUserDao.findById(id).get());
        return cardDao.save(card).getId();
    }




}
