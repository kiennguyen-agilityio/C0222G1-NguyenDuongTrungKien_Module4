package com.codegym.repository.customer;

import com.codegym.model.person.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer,String> {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByIdContainsOrNameContains(String id, String name, Pageable pageable);
}
