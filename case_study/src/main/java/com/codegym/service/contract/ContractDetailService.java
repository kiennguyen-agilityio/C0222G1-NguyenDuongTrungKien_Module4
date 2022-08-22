package com.codegym.service.contract;

import com.codegym.model.contract.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> findAll();

    List<ContractDetail> findAllByContractId(int id);

    void save(ContractDetail contractDetail);

    void save(List<ContractDetail> contractDetailList);

    void deleteByContractId(int id);

    boolean contractDetailKeyIsExist(int contractId, int attachServiceId);

    ContractDetail findById(Integer id);

    void delete(ContractDetail contractDetail);
}
