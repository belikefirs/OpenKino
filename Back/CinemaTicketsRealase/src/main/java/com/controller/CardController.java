package com.controller;

import com.models.Card;
import com.models.KinoUser;
import com.service.CardService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {
    private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("")
    Long saveCard(@RequestBody Card card, @AuthenticationPrincipal KinoUser kinoUser){
        return cardService.saveCard(card,kinoUser);
    }

    @PutMapping("/add")
    Long addCard(@RequestBody Card card){
        return cardService.addBalance(card);
    }

}
