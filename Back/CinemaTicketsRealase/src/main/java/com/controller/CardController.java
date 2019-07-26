package com.controller;

import com.models.Card;
import com.models.KinoUser;
import com.service.CardService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Long id){
        cardService.deleteCardById(id);
    }
    @GetMapping("/allByKInoUser/{id}")
    public List<Card> findCardsByIdKinoUser(@PathVariable Long id){
       return cardService.findCardsByIdKinoUser(id);
    }

    @PutMapping("/add/{id},{money}")
    Long addMoneyInCard(@PathVariable Long id,@PathVariable Double money){
        return cardService.addBalance(id,money);
    }

}
