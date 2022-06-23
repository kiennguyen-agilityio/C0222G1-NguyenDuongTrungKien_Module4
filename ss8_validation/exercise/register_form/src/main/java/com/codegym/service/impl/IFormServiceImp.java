package com.codegym.service.impl;

import com.codegym.model.FormModel;
import com.codegym.repository.FormRepository;
import com.codegym.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IFormServiceImp implements FormService {
    @Autowired
    FormRepository formRepository ;
    @Override
    public void save(FormModel formModel) {
    formRepository.save(formModel) ;
    }
}
