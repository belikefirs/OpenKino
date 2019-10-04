package com.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.masks.BuyMask;
import com.models.Buy;
import com.models.KinoUser;
import com.service.BuyService;
import com.view.Views;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buy")
public class BuyController {

    private BuyService buyService;

    public BuyController(BuyService buyService) {
        this.buyService = buyService;
    }

    @PostMapping("/save")
    Long saveBuyByKinoUser( @RequestBody BuyMask buyMask,
                            @AuthenticationPrincipal KinoUser kinoUser) {
        return buyService.saveBuy(buyMask,kinoUser);
    }

    @JsonView(Views.Internal.class)
    @GetMapping("/id/{id}")
    Buy findById(@PathVariable Long id){
        return buyService.findBuyById(id);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id){
       buyService.deleteBuyById(id);
    }
}
