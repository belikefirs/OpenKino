package com.controller;

import com.masks.CardMask;
import org.codehaus.jackson.map.annotate.JsonView;
import com.models.Card;
import com.models.KinoUser;
import com.service.CardService;
import com.view.Views;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }


    @PostMapping("")
    public Long saveCard(@RequestBody CardMask card, @AuthenticationPrincipal KinoUser kinoUser){
        return cardService.saveCard(card,kinoUser);
    }

    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Long id){
        cardService.deleteCardById(id);
    }
    @JsonView(Views.Internal.class)
    @GetMapping("/allByKinoUser/{id}")
    public List<Card> findCardsByIdKinoUser(@PathVariable Long id){
        return cardService.findCardsByIdKinoUser(id);
    }

    @PutMapping("/add/{id},{money}")
    public Long addMoneyInCard(@PathVariable Long id,@PathVariable BigDecimal money){
        return cardService.addBalance(id,money);
    }

}
