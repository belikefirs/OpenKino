package com.dao;

import com.models.Identification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentificationDao extends JpaRepository<Identification,Long> {

}
