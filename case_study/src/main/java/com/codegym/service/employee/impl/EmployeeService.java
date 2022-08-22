package com.codegym.service.employee.impl;

import com.codegym.model.person.employee.Employee;
import com.codegym.repository.employee.IEmployeeRepository;
import com.codegym.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Override
    public Page<Employee> findAll(Pageable pageble) {
        return employeeRepository.findAll(pageble);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
    employeeRepository.save(employee);
    }

    @Override
    public  Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Employee employee) {
     employeeRepository.save(employee) ;
    }

    @Override
    public void delete(Integer id) {
    employeeRepository.deleteById(id);
    }
    @Override
    public List<Employee> searchByName(String name) {
        return employeeRepository.searchByName("%"+name+"%");
    }
}
