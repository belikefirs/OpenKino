package com.dao;

import com.models.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallDao extends JpaRepository <Hall,Long> {

}
