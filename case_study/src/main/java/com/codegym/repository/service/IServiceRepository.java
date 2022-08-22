package com.codegym.repository.service;

import com.codegym.model.service.Service;
import com.codegym.model.service.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends JpaRepository<Service,Integer> {
    Page<Service> findAll(Pageable pageable);
    Page<Service> findAllByNameContains(String name, Pageable pageable);
    Page<Service> findAllByServiceType(ServiceType serviceType, Pageable pageable);
    Page<Service> findAllByIdContainsOrNameContains(String id, String name, Pageable pageable);
}
