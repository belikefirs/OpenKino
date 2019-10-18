package com.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.models.KinoUser;
import com.models.Position;
import com.service.KinUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/KinoUser")
public class KinoUserController {

    @Autowired
    private KinUserService kinUserService;

    @JsonView(KinoUser.View.Setter.class)
    @PostMapping("/save")
    public Long saveKinoUser(@RequestBody KinoUser kinoUser) {
        return kinUserService.saveKinoUser(kinoUser);
    }

    @JsonView(KinoUser.View.Setter.class)
    @PutMapping("/update")
    public Long updateKinoUser(@RequestBody KinoUser kinoUser) {
        return kinUserService.updateKinoUser(kinoUser);
    }

    @JsonView(KinoUser.View.Setter.class)
    @PutMapping("/block")
    public Long activeKinoUser(@RequestBody KinoUser kinoUser) {
        return kinUserService.action_false(kinoUser);
    }

    @JsonView(KinoUser.View.Setter.class)
    @PutMapping("/active")
    public Long blockKinoUser(@RequestBody KinoUser kinoUser) {
        return kinUserService.action_true(kinoUser);
    }


    @JsonView(KinoUser.View.Getter.class)
    @DeleteMapping("/delete/{id}")
    public void deleteKinoUser(@PathVariable Long id) {
        kinUserService.deleteById(id);
    }

    @JsonView(KinoUser.View.Getter.class)
    @GetMapping("/all")
    public List<KinoUser> getAll() {
        return kinUserService.findKinoUserAll();
    }

    @JsonView(KinoUser.View.Getter.class)
    @GetMapping("/{id}")
    public KinoUser get(@PathVariable Long id) {
        return kinUserService.findKinoUserById(id);
    }

    @JsonView(KinoUser.View.Getter.class)
    @GetMapping("")
    public KinoUser getKinoUserByMail(@RequestParam(name = "mail", required = false) String mail) {
        return kinUserService.findKinoUserByMail(mail);
    }

    @JsonView(KinoUser.View.Getter.class)
    @PostMapping("/position")
    public List<Position> savePosition() {
        return kinUserService.createPosition();
    }


}
