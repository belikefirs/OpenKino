package com.dao;

import com.models.Buy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyDao extends JpaRepository <Buy, Long > {
}
