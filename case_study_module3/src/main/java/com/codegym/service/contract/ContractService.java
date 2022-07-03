package com.codegym.service.contract;

import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);

    Contract findById(int id);

    Contract save(Contract contract);

    void delete(int id);

    Page<Contract> findAllByIdOrCustomerName(int id ,String search, Pageable pageable);
}
