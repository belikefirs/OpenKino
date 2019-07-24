package com.controller;

import com.models.Reservation;
import com.service.ReservationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reser")
public class ReservationController {
    private ReservationService reservationService;
    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }
    @PostMapping("/save")
    public Long save(@RequestBody Reservation reservation){
        return reservationService.saveReservation(reservation);
    }
    @PutMapping("/update/{id}")
    public Long update(@PathVariable Long id, @RequestBody Reservation reservation){
        return reservationService.updateReservation(reservation, id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        reservationService.deleteReservationById(id);
    }
}
