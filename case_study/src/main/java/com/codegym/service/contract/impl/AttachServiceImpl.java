package com.codegym.service.contract.impl;

import com.codegym.model.contract.AttachService;
import com.codegym.repository.contract.AttachServiceRepository;
import com.codegym.service.contract.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceImpl implements AttachServiceService {
    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public AttachService findById(int id) {
        return attachServiceRepository.findById(id).orElse(null);
    }
}
