package com.codegym.service.employee;

import com.codegym.model.person.employee.Division;

import java.util.List;
import java.util.Optional;

public interface IDivisionService {
    List<Division> findAll();

    void save(Division division);

    Optional<Division> findById(Integer id);
}
