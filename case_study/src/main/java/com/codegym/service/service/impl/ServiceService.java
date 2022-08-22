package com.codegym.service.service.impl;

import com.codegym.model.service.Service;
import com.codegym.repository.service.IServiceRepository;
import com.codegym.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {
    @Autowired
    private IServiceRepository serviceRepository;
    @Override
    public Page<Service> findAll(Pageable pageble) {
        return serviceRepository.findAll(pageble);
    }

    @Override
    public void save(Service service) {
    serviceRepository.save(service);
    }

    @Override
    public Service findById(Integer id) {
       return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(Integer id) {
    serviceRepository.deleteById(id);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }
}
