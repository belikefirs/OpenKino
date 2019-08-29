package com.controller;

import com.models.Place;
import com.models.Reservation;
import com.service.ReservationService;
import javafx.print.Collation;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
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
    public Long saveall(
                        @RequestParam(name = "idKinU")Long idKinU,
                        @RequestParam(name = "idDis")Long idDis,
                        @RequestParam(name = "idSess")Long idSess,
                        @RequestParam(name = "placeIsReservation")Place[] places) {
        List<Place> placesIsReservation = new ArrayList<Place>();
        Collections.addAll(placesIsReservation, places);
        return reservationService.saveAllReservation(
                idKinU, idDis, idSess, placesIsReservation);
    }
    @PutMapping("/update/{id}")
    public Long update(@RequestParam(name = "id") Long id, @RequestParam(name = "status") int status, @RequestBody Reservation reservation){
        return reservationService.updateReservation(reservation, id, status);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        reservationService.deleteReservationById(id);
    }
    @GetMapping("/get_places_is_reservation_id/{id}")
    public List<Place> getPlaesIsReservationId(@PathVariable Long id){
        return reservationService.getPlacesWithReservationId(id);
    }
    @GetMapping("getReservationFromUser")
    public List<Reservation> getReservationFromUser(@PathVariable Long id){
        return reservationService.getFindByIdKinoUser(id);
    }
    @PutMapping("changeStatus")
    public Long changeStatusReservation(@PathVariable(name = "id")Long id,
                                        @PathVariable(name = "status")Integer status){
        return reservationService.changeStatusReservation(id, status);
    }
}
