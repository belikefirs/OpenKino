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
    @Autowired
    private KinoUserDao kinoUserDao;
    @Autowired
    private CardDao cardDao;
    @Autowired
    private PositionDao positionDao;


    @Override
    @Transactional
    public Long saveKinoUser(KinoUser kinoUser) {
        kinoUserDao.save(kinoUser);
        return kinoUser.getId();
    }

    @Override
    @Transactional
    public KinoUser findKinoUserById(Long id) {
        return kinoUserDao.getOne(id);
    }

    @Override
    @Transactional
    public Long updateKinoUserById(Long id, String name, String fname, Integer age, String phone, String mail) {
        KinoUser kinoUser = kinoUserDao.getOne(id);
        kinoUser.setName(name);
        kinoUser.setfName(fname);
        kinoUser.setAge(age);
        kinoUser.setMail(mail);
        kinoUser.setPhone(phone);
        return kinoUserDao.save(kinoUser).getId();
    }


    @Override
    @Transactional
    public Long updatePasswordById(Long id, String password) {
        KinoUser kinoUser = kinoUserDao.getOne(id);
        kinoUser.setPassword(password);
        return kinoUserDao.save(kinoUser).getId();
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
        KinoUser kinoUser = kinoUserDao.getOne(id);
        Position position = positionDao.getOne(idPosition);
        kinoUser.setPosition(position);
        return kinoUserDao.save(kinoUser).getId();
    }

    @Override
    @Transactional
    public Position getPositionKinoUserById(Long id) {
        return kinoUserDao.getOne(id).getPosition();
    }

    @Override
    @Transactional
    public Long saveCard(Long id,Card card) {
        card.setKinoUser(kinoUserDao.getOne(id));
        return cardDao.save(card).getId();
    }




}
