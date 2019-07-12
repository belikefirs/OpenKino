package com.service;

import com.models.KinoUser;
import org.springframework.stereotype.Service;

@Service
public class KinoUserServiceImp implements  KinoUserService {
    KinoUserService kinoUserService;
    @Override
    public Long save(KinoUser kinoUser) {
        return kinoUserService.save(kinoUser);
    }

}
