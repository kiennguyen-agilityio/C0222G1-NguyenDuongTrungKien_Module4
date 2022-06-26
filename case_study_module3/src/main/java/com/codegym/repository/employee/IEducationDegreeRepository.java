package com.codegym.repository.employee;

import com.codegym.model.person.employee.Division;
import com.codegym.model.person.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IEducationDegreeRepository extends JpaRepository<EducationDegree, Integer> {
}
