package com.controller;

import com.models.Hall;
import com.models.Place;
import com.service.HallService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/save_place/{id}")
    public Long save(@RequestBody Place place, @PathVariable Long id){

        return hallService.savePlace(place, id);
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
    @GetMapping("/list_places/{id}")
    public List<Place> getPlaces(@PathVariable Long id)  {
        return hallService.getPlaces(id);
    }
    @GetMapping("/places_reservation/{id}")
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
    @GetMapping("/get_place_from_hall")
    public Place get(@RequestParam(name = "idHall") Long id,
                     @RequestParam(name = "NumberPlace") Integer number){
        return hallService.findPlaceByNumberFromHall(id, number);
    }
    @GetMapping("/saveall")
    public Hall saveAll(){
        Hall hall = new Hall();
        hall.setHeight(height);
        hall.setWidth(width);
        hallService.saveHall(hall);
        List<Place> places = new ArrayList<Place>();
        for(int i = 0; i <= width; i++ ){
            for(int j = 0; j <=height; j++){
                if(i % 4 != 0 && j % 3 != 0){
                    Place place = new Place();
                    place.setHall(hall);
                    place.setX(i);
                    place.setY(j);
                    place.setPrice(PRICE);
                    place.setNumber(i);
                    places.add(place);
                    hallService.savePlace(place, hall.getId());
                }
            }
        }
        hall.setPlaces(places);
        return hall;
    }
}
