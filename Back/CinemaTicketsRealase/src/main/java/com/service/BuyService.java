package com.service;


import com.masks.BuyMask;
import com.models.Buy;
import com.models.KinoUser;

public interface BuyService {
    Long saveBuy(BuyMask buyMask, KinoUser kinoUser) ;//покупка c регистрацией
    Buy findBuyById(Long id);
    void deleteBuyById(Long id);
}
