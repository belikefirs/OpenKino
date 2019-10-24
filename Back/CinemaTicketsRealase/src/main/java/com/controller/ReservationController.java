package com.controller;

import com.models.Discount;
import com.models.KinoUser;
import com.models.Place;
import com.models.Reservation;
import com.service.ReservationService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PostMapping("/discount")
    public Long save(@RequestBody Discount discount){
        return reservationService.saveDiscount(discount);
    }
    @DeleteMapping ("/deleteList/{id}")
    List<Place> deletePLace(@PathVariable Long id){
        return reservationService.deletePlaceFromList(places, id);
    }
    @PostMapping("")
    public Long saveall(
                         @RequestBody ArrayList<Long> listIdPlace,@RequestParam(name = "session") Long idSess, @AuthenticationPrincipal KinoUser kinoUser){
        return reservationService.saveAllReservation(listIdPlace, idSess, kinoUser);
    }
    @PutMapping("update/{id}")
    public Long update(@RequestParam(name = "id") Long id, @RequestParam(name = "status") int status, @RequestBody Reservation reservation){
        return reservationService.updateReservation(reservation, id, status);
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

    @GetMapping("/listRes/{enum_status}")//Auth
    public ArrayList getInfoFromReser(@AuthenticationPrincipal KinoUser kinoUser, @PathVariable(name = "enum_status") Long enum_value){
        return reservationService.getInfoFromReser(kinoUser, enum_value);
    }

    @DeleteMapping("/delete/{idReser}")
    public String deleteReser(@PathVariable (name = "idReser") Long idReser){
        reservationService.deleteReservationById(idReser);
        return "Reservation successfully deleted";
    }
}
