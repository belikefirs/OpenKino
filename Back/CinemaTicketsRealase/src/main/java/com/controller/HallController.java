package com.controller;

import com.models.Hall;
import com.models.Place;
import com.service.HallService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hall")
public class HallController {
    public final static int width = 50;
    public final static int height = 50;
    public HallService hallService;
    public HallController(HallService hallService){
        this.hallService = hallService;
    }
    @PostMapping("/save")
    public Long save(@RequestBody Hall hall){
        return hallService.saveHall(hall);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.FOUND)
    public Long update(@RequestBody Hall hall){
        return hallService.updateHall(hall);
    }
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id){
        hallService.deleteHall(id);
    }

    @GetMapping("/size/id:\\d+")
    public Integer getSize(@PathVariable Long id){
        return hallService.getSize(id);
    }
    @GetMapping("/list_places/id:\\d+")
    public List<Place> getPlaces(@PathVariable Long id)  {
        return hallService.getPlaces(id);
    }
    @GetMapping("/places_reservation/id:\\d+")
    public List<Place> getPlacesIsReservation(@PathVariable Long id)  {
        return hallService.getPlacesReservation(id);
    }
    @GetMapping("/places_not_reservation/id:\\d+")
    public List<Place> getPlacesIsNotReservation(@PathVariable Long id)  {
        return hallService.getPlacesNotReservation(id);
    }
    @GetMapping("/get/{id}")
    public Hall getHall(@PathVariable Long id){
        return hallService.findHallbyId(id);
    }
}
