package com.controller;


import com.models.Identification;
import com.service.IdentificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jnlp.IntegrationService;

@RestController
@RequestMapping("/identification")
public class IdentificationController {

    private IdentificationService identificationService;

    public IdentificationController(IdentificationService identificationService) {
        this.identificationService = identificationService;
    }

    @PostMapping("/save")
    public Long save(@RequestBody Identification identification){
        identificationService.save(identification);
        return identification.getId();
    }
}
