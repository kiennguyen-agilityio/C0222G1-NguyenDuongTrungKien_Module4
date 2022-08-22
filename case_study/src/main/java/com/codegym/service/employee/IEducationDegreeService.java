package com.codegym.service.employee;

import com.codegym.model.person.employee.EducationDegree;

import java.util.List;
import java.util.Optional;

public interface IEducationDegreeService {
    List<EducationDegree> findAll();

    void save(EducationDegree educationDegree);

    Optional<EducationDegree> findById(Integer id);
}
