package com.controller;

import com.models.Discount;
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
    private List<Place> places;
    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
        places = new ArrayList<Place>();
    }
    @PostMapping("/save")
    public Long save(@RequestBody Reservation reservation){
        return reservationService.saveReservation(reservation);
    }
    @PostMapping("/discount")
    public Long save(@RequestBody Discount discount){
        return reservationService.saveDiscount(discount);
    }
    @PostMapping("/setList/{id}")
    List<Place> savePlaces(@PathVariable Long id){
        return reservationService.getPlacesForReservation(places, id);
    }
    @DeleteMapping ("/deleteList/{id}")
    List<Place> deletePLace(@PathVariable Long id){
        return reservationService.deletePlaceFromList(places, id);
    }
    @PostMapping("/saveall")
    public Long saveall(
                        @RequestParam(name = "idKinU")Long idKinU,
                        @RequestParam(name = "idDis")Long idDis,
                        @RequestParam(name = "idSess")Long idSess,
                        @RequestParam(name = "idHall")Long idHall   /*,
                     @RequestBody Long[] places)*/ ){
        List<Long> placesIsReservation = new ArrayList<Long>();
      //  Collections.addAll(placesIsReservation, places);
        return reservationService.saveAllReservation(idKinU, idDis, idSess, idHall,
                places);
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
    @GetMapping("/getReservationFromUser/{id}")
    public List<Reservation> getReservationFromUser(@PathVariable Long id){
        return reservationService.getFindByIdKinoUser(id);
    }
    @GetMapping("/get/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationService.getFindById(id);
    }
    @PutMapping("/changeStatus")
    public Long changeStatusReservation(@PathVariable(name = "id")Long id,
                                        @PathVariable(name = "status")Integer status){
        return reservationService.changeStatusReservation(id, status);
    }
}
