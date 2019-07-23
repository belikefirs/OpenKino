package com.dao;

import com.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservationDao extends JpaRepository<Reservation,Long> {
}
