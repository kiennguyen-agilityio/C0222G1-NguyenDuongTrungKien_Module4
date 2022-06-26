package com.codegym.service.employee;

import com.codegym.model.person.employee.Position;

import java.util.List;
import java.util.Optional;

public interface IPositionService {
    List<Position> findAll();

    void save(Position position);

    Optional<Position> findById(Integer id);
}
