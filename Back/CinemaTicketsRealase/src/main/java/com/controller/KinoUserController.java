package com.controller;

import com.models.Card;
import com.models.KinoUser;
import com.service.KinUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.GeneratedValue;

/**
 * Created by mbelo on 14.07.2019.
 */
@RestController
public class KinoUserController {
    @Autowired
    private KinUserService kinUserService;



    @GetMapping("/saveKinoUser")
    public String saveKinoUser(KinoUser kinoUser){
        kinoUser.setName("misha");
        kinUserService.saveKinoUser(kinoUser);
        return "KinoUser save";
    }

    @GetMapping("/updateKinoUserById")
    public String updateKinoUserById(KinoUser kinoUser){
        kinoUser.setId(1L);
        kinoUser.setName("Sasha");
        kinoUser.setAge(50);
        kinUserService.updateKinoUser(kinoUser);
        return "Update KinoUserById";
    }

    @GetMapping("/saveCard")
    public Long saveCard(Card card){
        card.setId(22031123344L);
        card.setBalance(500.0);
        kinUserService.saveCard(1L,card);
        return card.getId();
    }


}
