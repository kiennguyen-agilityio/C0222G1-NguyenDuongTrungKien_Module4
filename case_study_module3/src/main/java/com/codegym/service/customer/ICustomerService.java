package com.codegym.service.customer;

import com.codegym.model.person.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);
    List<Customer> findAll();
    Customer findById(String id);
    Customer save(Customer customer);
    void delete(String id);
    Page<Customer> findAllByIdOrName(String search, Pageable pageable);
    void update(Customer customer);
}
