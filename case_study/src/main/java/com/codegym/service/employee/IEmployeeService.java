package com.codegym.service.employee;

import com.codegym.model.person.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageble);
    List<Employee> findAll();
    void save(Employee employee);

    Employee findById(Integer id);

    void update(Employee employee);

    void delete(Integer id);

   List<Employee>  searchByName(String name);
}
