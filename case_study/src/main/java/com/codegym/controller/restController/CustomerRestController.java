package com.codegym.controller.restController;

import com.codegym.model.person.customer.Customer;
import com.codegym.service.customer.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {
    @Autowired
    private CustomerService service;

    @GetMapping("")
    public ResponseEntity<?> listCustomer() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
        service.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/edit/{id}")
    public ResponseEntity<?> editCustomer(@PathVariable String id) {
        Customer customer = service.findById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editCustomer(@RequestBody Customer customer) {
        service.update(customer);
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> getDeletingCustomer(@PathVariable String id) {
        Customer customer = service.findById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> searchByName(@PathVariable String name){
        List<Customer> customer= service.searchByName(name);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
