package com.service.impl;

import com.repository.InformationServiceRepo;
import com.repository.impl.IInformationServiceRepo;
import com.service.InformationService;

import java.util.List;

public class IInformationService implements InformationService {
   private InformationServiceRepo serviceRepo = new IInformationServiceRepo() ;
    @Override
    public List<String> vehicle() {
        return serviceRepo.vehicle();
    }

    @Override
    public List<String> gender() {
        return serviceRepo.gender();
    }

    @Override
    public List<String> nationality() {
        return serviceRepo.nationality();
    }

    @Override
    public List<String> year() {
        return serviceRepo.year();
    }
}
