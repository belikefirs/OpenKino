package com.controller;

import com.models.Place;
import com.models.Reservation;
import com.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/saveall")
    public Long saveall(@RequestBody Reservation reservation,
                        @RequestParam(name = "idKinU")Long idKinU,
                        @RequestParam(name = "idBuy")Long idBuy,
                        @RequestParam(name = "idDis")Long idDis){
        return reservationService.saveAllReservation(reservation,
                idKinU, idBuy, idDis);
    }
    @PutMapping("/update/{id}")
    public Long update(@PathVariable Long id, @RequestBody Reservation reservation){
        return reservationService.updateReservation(reservation, id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        reservationService.deleteReservationById(id);
    }
    @GetMapping("/get_places_is_reservation_id/{id}")
    public List<Place> getPlaesIsReservationId(@PathVariable Long id){
        return reservationService.getPlacesWithReservationId(id);
    }
}
