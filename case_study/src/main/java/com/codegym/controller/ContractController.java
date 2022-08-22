package com.codegym.controller;

import com.codegym.service.contract.AttachServiceService;
import com.codegym.service.contract.ContractDetailService;
import com.codegym.service.contract.ContractService;
import com.codegym.service.customer.impl.CustomerService;
import com.codegym.service.employee.impl.EmployeeService;
import com.codegym.service.service.impl.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    ServiceService service;

    @Autowired
    ContractService contractService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CustomerService customerService;

    @Autowired
    AttachServiceService attachServiceService;

    @Autowired
    ContractDetailService contractDetailService;

}
