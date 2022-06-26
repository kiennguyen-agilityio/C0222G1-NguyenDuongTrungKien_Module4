package com.codegym.service.customer;

import com.codegym.model.person.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
