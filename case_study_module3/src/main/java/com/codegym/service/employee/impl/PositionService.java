package com.codegym.service.employee.impl;

import com.codegym.model.person.employee.Position;
import com.codegym.repository.employee.IPositionRepository;
import com.codegym.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository positionRepository;
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public void save(Position position) {
    positionRepository.save(position);
    }

    @Override
    public Optional<Position> findById(Integer id) {
        return positionRepository.findById(id);
    }
}
