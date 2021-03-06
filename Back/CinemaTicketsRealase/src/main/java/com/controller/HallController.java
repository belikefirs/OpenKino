package com.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.models.Hall;
import com.models.Place;
import com.service.HallService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/hall")
public class HallController {

    public HallService hallService;
    public HallController(HallService hallService){
        this.hallService = hallService;
    }


    @PostMapping("")
    public Long saveV2( @JsonView(Hall.View.Internal.class)@RequestBody Hall hall){
       return hallService.saveV2(hall);
    }

    @PostMapping("/save")
    public Long save(@RequestBody Hall hall){
        return hallService.saveHall(hall);
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
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        hallService.deleteHall(id);
    }
    @DeleteMapping("/place/{id}")
    public void deletePlace(@PathVariable Long id){
        hallService.deletePlace(id);
    }
    @GetMapping("/place")
    public Place get(@RequestParam(name = "idHall") Long id,
                     @RequestParam(name = "idPlace") Long number){
        return hallService.findPlaceByNumberFromHall(id, number);
    }
//    @PostMapping("")
//    public Long saveAll(@RequestBody HallMask hallMask){
//        return hallService.save(hallMask);
//    }
//    @PostMapping("/saveall")
//    public Long saveAllF(@RequestParam(name = "number")Integer num,
//                         @RequestParam(name = "width")Integer width,
//                         @RequestParam(name = "height")Integer height,
//                         @RequestParam(name = "price")BigDecimal price){
//        return hallService.saveAll(num, width, height, price);
//    }
    @GetMapping("/getPlacesIsReser/{id}")
    public List <Place> getPlacesReserV2(@PathVariable Long id){
        return hallService.getIsReservation(id);
    }
    @GetMapping("/all")
    public List<Hall> getAllHall(){
        return hallService.getAllHall();
    }


    @GetMapping("/{id}")
    @JsonView(Hall.View.Public.class)
    public Hall getHall(@PathVariable Long id){
        return hallService.findHallbyId(id);
    }

    @GetMapping("/places/{id}")
    public List<Place> getPlaces(@PathVariable Long id){
        return hallService.getPlaces(id);
    }
    @PutMapping("/changeStatus")
    public void changeStatusReservation(@RequestBody List<Long> listPlace,
                                        @RequestParam(name = "status")Integer status){
        hallService.changeStatus(listPlace, status);
    }

    @GetMapping("/placeNotReser/{id}")
    public List<Place> getPlacesNotReser(@PathVariable Long id){
        return hallService.getPlacesNotReservation(id);
    }
    @GetMapping("/placeReser/{id}")
    public List<Place> getPlacesReser(@PathVariable Long id){
        return hallService.getPlacesReservation(id);
    }

    @GetMapping("/bySession/{id_session}")
    public Hall getHallBySession(@PathVariable Long id_session) {return hallService.getHallBySession(id_session);
    }
}
