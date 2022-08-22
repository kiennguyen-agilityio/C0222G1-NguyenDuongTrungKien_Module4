package com.codegym.service.service;

import com.codegym.model.person.employee.Employee;
import com.codegym.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IServiceService {
    Page<Service> findAll(Pageable pageble);

    void save(Service service);

    Service findById(Integer id);

    void update(Service service);

    void remove(Integer id);

    List<Service> findAll();
}
