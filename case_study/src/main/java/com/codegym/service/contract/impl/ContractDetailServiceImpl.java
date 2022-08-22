package com.codegym.service.contract.impl;

import com.codegym.model.contract.ContractDetail;
import com.codegym.repository.contract.ContractDetailRepository;
import com.codegym.service.contract.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public List<ContractDetail> findAllByContractId(int id) {
        return contractDetailRepository.findAllByContract_Id(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void save(List<ContractDetail> contractDetailList) {
        for (ContractDetail contractDetail : contractDetailList) {
            contractDetailRepository.save(contractDetail);
        }
    }

    @Override
    public void deleteByContractId(int id) {
        contractDetailRepository.deleteAllByContract_Id(id);
    }

    @Override
    public boolean contractDetailKeyIsExist(int contractId, int attachServiceId) {
        for (ContractDetail contractDetail : contractDetailRepository.findAll()) {
            if (contractDetail.getContract().getId() == contractId && contractDetail.getAttachService().getId() == attachServiceId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ContractDetail findById(Integer id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(ContractDetail contractDetail) {
        contractDetailRepository.delete(contractDetail);
    }
}
