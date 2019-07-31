package com.service;

import com.models.Buy;

public interface BuyService {
    Long saveBuy(Buy buy);
    Buy findBuyById(Long id);
}
