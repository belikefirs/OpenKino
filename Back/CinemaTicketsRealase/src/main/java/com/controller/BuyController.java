package com.controller;

import com.models.Buy;
import com.models.KinoUser;
import com.service.BuyService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buy")
public class BuyController {

    private BuyService buyService;

    public BuyController(BuyService buyService) {
        this.buyService = buyService;
    }

    @PostMapping("")
    Long saveBuy(@RequestBody Buy buy){
        return buyService.saveBuy(buy);
    }

    @PostMapping("/save")
    Long saveBuyByKinoUser(@RequestBody Buy buy, @AuthenticationPrincipal KinoUser kinoUser){
        return buyService.saveBuyByKinoUser(buy,kinoUser);
    }

    @GetMapping("/id/{id}")
    Buy findById(@PathVariable Long id){
        return buyService.findBuyById(id);
    }
}
