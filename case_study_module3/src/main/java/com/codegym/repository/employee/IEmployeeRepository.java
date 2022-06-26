package com.codegym.repository.employee;

import com.codegym.model.person.employee.Division;
import com.codegym.model.person.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findByNameContaining(String name, Pageable page);
}
