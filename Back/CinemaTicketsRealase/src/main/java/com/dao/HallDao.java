package com.dao;

import com.models.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HallDao extends JpaRepository <Hall,Long> {
}
