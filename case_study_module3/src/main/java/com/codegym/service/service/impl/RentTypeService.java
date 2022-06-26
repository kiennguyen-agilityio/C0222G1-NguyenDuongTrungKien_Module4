package com.codegym.service.service.impl;

import com.codegym.model.service.RentType;
import com.codegym.repository.service.IRentTypeRepository;
import com.codegym.service.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public Optional<RentType> findById(Integer id) {
        return rentTypeRepository.findById(id);
    }
}
