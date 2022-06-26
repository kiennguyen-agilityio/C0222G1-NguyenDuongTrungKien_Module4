package com.codegym.repository.employee;

import com.codegym.model.person.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IDivisionRepository extends JpaRepository<Division, Integer> {
}
