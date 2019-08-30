package com.service;


import com.models.Buy;
import com.models.KinoUser;

public interface BuyService {
    Long saveBuy(Buy buy) ;//покупка без регистрации
    Long saveBuyByKinoUser(Buy buy,KinoUser kinoUser);//покупка c регистрацией
    Buy findBuyById(Long id);
    void deleteBuyById(Long id);
}
