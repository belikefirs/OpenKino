package com.service;

import com.dao.IdentificationDao;
import com.dao.KinoUserDao;
import com.models.Identification;
import com.models.KinoUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IdentificationServiceImp implements IdentificationService {
    private IdentificationDao identificationDao;
    private KinoUserDao kinoUserDao;

    public IdentificationServiceImp(IdentificationDao identificationDao, KinoUserDao kinoUserDao) {
        this.identificationDao = identificationDao;
        this.kinoUserDao = kinoUserDao;
    }

    @Override
    @Transactional
    public Long save(Identification identification) {
        identificationDao.save(identification);
        KinoUser kinoUser = identification.getKinoUser();
        kinoUser.setIdentification(identification);
        kinoUserDao.save(kinoUser);
        return kinoUser.getId();
    }

    @Override
    public Identification getIdentificationById(Long id) {
        return identificationDao.getOne(id);
    }
}
