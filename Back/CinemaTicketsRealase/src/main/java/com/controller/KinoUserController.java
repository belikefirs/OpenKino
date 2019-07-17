package com.controller;

import com.models.KinoUser;
import com.models.Position;
import com.service.KinUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/KinoUser")
public class KinoUserController {

@Autowired
    private KinUserService kinUserService;



    @PostMapping("/save")
    public Long saveKinoUser(@RequestBody KinoUser kinoUser) {

        return kinUserService.saveKinoUser(kinoUser);
    }

    @PutMapping("/update")
    public Long updateKinoUser(@RequestBody KinoUser kinoUser) {
        return kinUserService.updateKinoUser(kinoUser);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteKinoUser(@PathVariable Long id) {
        kinUserService.deleteById(id);
    }

    @PutMapping("/block")
    public Long activeKinoUser(@RequestBody KinoUser kinoUser) {
        return kinUserService.action_true(kinoUser);
    }

    @PutMapping("/active")
    public Long blockKinoUser(@RequestBody KinoUser kinoUser) {
        return kinUserService.action_false(kinoUser);
    }

    @GetMapping("/all")
    public List<KinoUser> getAll() {
        return kinUserService.findKinoUserAll();
    }

    @GetMapping("/{id}")
    public KinoUser get(@PathVariable Long id) {
        return kinUserService.findKinoUserById(id);
    }

   /* @PutMapping("/setRole/{id}")
    public KinoUser setPosition(@RequestBody KinoUser kinoUser) {
        int id = 0;
        switch (kinoUser.getPosition().getName()) {
            case "User":
            case "Пользователь":
                id = 1;
                break;
            case "Admin":
            case "Администратор":
                id = 2;
                break;
        }
        return kinUserService.setPositionKinoUserById(idPosition, id)
    }*/


}
