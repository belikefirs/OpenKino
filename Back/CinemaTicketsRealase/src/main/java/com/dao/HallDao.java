package com.dao;

import com.models.Hall;
import com.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HallDao extends JpaRepository <Hall,Long> {

}
