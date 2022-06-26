package com.codegym.service.customer.impl;

import com.codegym.model.person.customer.Customer;
import com.codegym.repository.customer.ICustomerRepository;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findById(String id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return iCustomerRepository.save(customer);
    }

    @Override
    public void delete(String id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAllByIdOrName(String search, Pageable pageable) {
        return iCustomerRepository.findAllByIdContainsOrNameContains(search, search, pageable);
    }
    @Override
    public void update(Customer customer) {
        iCustomerRepository.save(customer);
    }

}
