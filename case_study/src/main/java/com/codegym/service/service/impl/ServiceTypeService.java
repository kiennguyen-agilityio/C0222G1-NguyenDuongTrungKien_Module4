package com.codegym.service.service.impl;

import com.codegym.model.service.ServiceType;
import com.codegym.repository.service.IServiceTypeRepository;
import com.codegym.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTypeService implements IServiceTypeService {
    @Autowired
    private IServiceTypeRepository repository;

    @Override
    public List<ServiceType> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(ServiceType serviceType) {
        repository.save(serviceType);
    }

    @Override
    public Optional<ServiceType> findById(Integer id) {
        return repository.findById(id);
    }
}
