package com.codegym.repository.contract;

import com.codegym.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
    List<ContractDetail> findAllByContract_Id(int contractId);

    void deleteAllByContract_Id(int contractId);

}
