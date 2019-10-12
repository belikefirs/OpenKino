package com.service;

import com.models.Discount;

import java.util.List;

public interface DiscountService {
    Long save(Discount discount);
    Long update(Discount discount);
    void delete(Long id);
    Discount get(Long id);
    List<Discount> getAll();

}
