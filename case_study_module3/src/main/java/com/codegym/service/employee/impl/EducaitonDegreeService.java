package com.codegym.service.employee.impl;

import com.codegym.model.person.employee.EducationDegree;
import com.codegym.repository.employee.IEducationDegreeRepository;
import com.codegym.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EducaitonDegreeService implements IEducationDegreeService {
    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public void save(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree) ;
    }

    @Override
    public Optional<EducationDegree> findById(Integer id) {
        return educationDegreeRepository.findById(id);
    }
}
