package com.controller;

import com.models.Hall;
import com.models.Place;
import com.service.HallService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hall")
public class HallController {
    public final static int width = 10;
    public final static int height = 10;
    public final static Double PRICE = 328.0;

    public HallService hallService;
    public HallController(HallService hallService){
        this.hallService = hallService;
    }
    @PostMapping("/save")
    public Long save(@RequestBody Hall hall){
        return hallService.saveHall(hall);
    }
    @PostMapping("/save_place")
    public Long save(@RequestBody Place place, @RequestParam(name = "idHall") Long idHall,
                     @RequestParam(name = "idReservation")Long idReservation,
                     @RequestParam(name = "idBuy")Long idBuy){

        return hallService.savePlace(place, idHall);
    }
    @PutMapping("/update")
    public Long update(@RequestBody Hall hall){
        return hallService.updateHall(hall);
    }
    @PutMapping("/update_place")
    public Long update(@RequestParam(name = "id")Long id,
                       @RequestParam(name = "price")BigDecimal price,
                       @RequestParam(name = "status")Integer status){
        return hallService.updatePlace(id, price, status);
    }
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id){
        hallService.deleteHall(id);
    }
    @DeleteMapping("/delete_place/{id}")
    public void deletePlace(@PathVariable Long id){
        hallService.deletePlace(id);
    }
    public Hall getHall(@PathVariable Long id){
        return hallService.findHallbyId(id);
    }
    @GetMapping("/get_place_from_hall")
    public Place get(@RequestParam(name = "idHall") Long id,
                     @RequestParam(name = "idPlace") Long number){
        return hallService.findPlaceByNumberFromHall(id, number);
    }
    @PostMapping("/saveall")
    public Hall saveAll(@RequestParam(name = "number")Integer number,
                        @RequestParam(name = "width")Integer width,
                        @RequestParam(name = "height")Integer height,
                        @RequestParam(name = "price")BigDecimal price){
        Long id = hallService.save(number,width, height);
        return hallService.saveListPlaces(id, hallService.createdPlaces(width, height, price, id));
    }

    @GetMapping("/all")
    public List<Hall> getAllHall(){
        return hallService.getAllHall();
    }
    @GetMapping("/getPlaces/{id}")
    public List<Place> getPlaces(@PathVariable Long id){
        return hallService.getPlaces(id);
    }
    @PutMapping("/changeStatus")
    public Long changeStatusReservation(@PathVariable(name = "id")Long id,
                                        @PathVariable(name = "status")Integer status){
        return hallService.changeStatus(id, status);
    }
    @GetMapping("/placeNotReser/{id}")
    public List<Place> getPlacesNotReser(@PathVariable Long id){
        return hallService.getPlacesNotReservation(id);
    }
    @GetMapping("/placeReser/{id}")
    public List<Place> getPlacesReser(@PathVariable Long id){
        return hallService.getPlacesReservation(id);
    }
}
