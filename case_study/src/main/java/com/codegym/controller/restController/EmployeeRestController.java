package com.codegym.controller.restController;

import com.codegym.model.person.employee.Employee;
import com.codegym.service.employee.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("")
    public ResponseEntity<?> listEmployee() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<?> editEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editEmployee(@RequestBody Employee employee) {
        employeeService.update(employee);
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> getDeleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> searchByName(@PathVariable String name) {
        List<Employee> employees = employeeService.searchByName(name);
        return new ResponseEntity<>(employees, HttpStatus.OK);
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
