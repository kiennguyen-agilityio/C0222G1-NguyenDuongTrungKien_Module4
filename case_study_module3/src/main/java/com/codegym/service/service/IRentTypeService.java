package com.codegym.service.service;

import com.codegym.model.service.RentType;

import java.util.List;
import java.util.Optional;

public interface IRentTypeService {
    List<RentType> findAll();

    void save(RentType rentType);

    Optional<RentType> findById(Integer id);
}
