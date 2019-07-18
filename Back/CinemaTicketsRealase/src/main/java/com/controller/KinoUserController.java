package com.controller;

import com.models.KinoUser;
import com.service.KinUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/KinoUser")
public class KinoUserController {

@Autowired
    private KinUserService kinUserService;

    @PutMapping("/update")
    public Long updateKinoUser(@RequestBody KinoUser kinoUser) {
        return kinUserService.updateKinoUser(kinoUser);
    }

    @PutMapping("/block")
    public Long activeKinoUser(@RequestBody KinoUser kinoUser) {
        return kinUserService.action_false(kinoUser);
    }

    @PutMapping("/active")
    public Long blockKinoUser(@RequestBody KinoUser kinoUser) {
        return kinUserService.action_true(kinoUser);
    }

    @PostMapping("/save")
    public Long saveKinoUser(@RequestBody KinoUser kinoUser) {
        return kinUserService.saveKinoUser(kinoUser);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteKinoUser(@PathVariable Long id) {
        kinUserService.deleteById(id);
    }

    @GetMapping("/all")
    public List<KinoUser> getAll() {
        return kinUserService.findKinoUserAll();
    }

    @GetMapping("/{id}")
    public KinoUser get(@PathVariable Long id) {
        return kinUserService.findKinoUserById(id);
    }
}
