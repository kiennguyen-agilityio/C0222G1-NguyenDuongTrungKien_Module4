package com.codegym.repository.service;

import com.codegym.model.service.Service;
import com.codegym.model.service.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
}
