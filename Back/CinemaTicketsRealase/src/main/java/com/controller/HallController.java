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
    @PostMapping("/save_place")
    public Long save(@RequestBody Place place){
        return hallService.savePlace(place);
    }
    @PutMapping("/update")
    public Long update(@RequestBody Hall hall){
        return hallService.updateHall(hall);
    }
    @PutMapping("/update_place")
    public Long update(@RequestBody Place place){
        return hallService.updatePlace(place);
    }
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id){
        hallService.deleteHall(id);
    }
    @DeleteMapping("/delete_place/{id}")
    public void deletePlace(@PathVariable Long id){
        hallService.deletePlace(id);
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
