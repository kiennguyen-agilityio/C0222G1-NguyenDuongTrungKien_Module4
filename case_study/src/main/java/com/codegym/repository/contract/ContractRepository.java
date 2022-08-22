package com.codegym.repository.contract;

import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findAll(Pageable pageable);

    @Query("SELECT e FROM Contract e WHERE e.id = ?1 OR e.customer.name LIKE ?2")
    Page<Contract> findAllByIdOrCustomer_Name(int id, String name, Pageable pageable);
}
