package com.codegym.service.employee.impl;

import com.codegym.model.person.employee.Division;
import com.codegym.repository.employee.IDivisionRepository;
import com.codegym.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository divisionRepository;
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public void save(Division division) {
   divisionRepository.save(division) ;
    }

    @Override
    public Optional<Division> findById(Integer id) {
        return divisionRepository.findById(id);
    }
}
