package com.dao;

import com.models.LimitAge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LimitAgeDao extends JpaRepository<LimitAge, Long> {
}
