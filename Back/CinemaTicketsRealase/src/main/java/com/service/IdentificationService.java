package com.service;


import com.models.Identification;
import com.models.KinoUser;

public interface IdentificationService {
    Long save(Identification identification);
    Identification getIdentificationById(Long id);
}
