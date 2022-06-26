package com.codegym.service.employee.impl;

import com.codegym.model.person.employee.Employee;
import com.codegym.repository.employee.IEmployeeRepository;
import com.codegym.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Override
    public Page<Employee> findAll(Pageable pageble) {
        return employeeRepository.findAll(pageble);
    }

    @Override
    public void save(Employee employee) {
    employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void update(Employee employee) {
     employeeRepository.save(employee) ;
    }

    @Override
    public void remove(Employee employee) {
    employeeRepository.delete(employee);
    }
    @Override
    public Page<Employee> searchByName(String name, Pageable pageble) {
        return employeeRepository.findByNameContaining(name,pageble);
    }
}
