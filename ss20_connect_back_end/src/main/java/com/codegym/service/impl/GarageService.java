package com.codegym.service.impl;

import com.codegym.model.Garage;
import com.codegym.repository.IGarageRepository;
import com.codegym.service.IGarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageService implements IGarageService {
@Autowired
    private IGarageRepository iGarageRepository;

    @Override
    public List<Garage> findAll() {
        return iGarageRepository.findAll();
    }
}
