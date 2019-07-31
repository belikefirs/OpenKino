package com.service;

import com.dao.BuyDao;
import com.models.Buy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BuyServiceImpl implements BuyService {
    private BuyDao buyDao;

    public BuyServiceImpl(BuyDao buyDao) {
        this.buyDao = buyDao;
    }

    @Override
    public Long saveBuy(Buy buy) {
        return buyDao.save(buy).getId();
    }

    @Override
    public Buy findBuyById(Long id) {
        return buyDao.findById(id).get();
    }
}
