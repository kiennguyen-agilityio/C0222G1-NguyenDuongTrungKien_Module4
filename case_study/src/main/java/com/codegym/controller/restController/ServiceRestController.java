package com.codegym.controller.restController;

import com.codegym.model.person.employee.Employee;
import com.codegym.model.service.Service;
import com.codegym.service.service.impl.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service")
public class ServiceRestController {
    @Autowired
    private ServiceService serviceService ;
    @GetMapping("")
    public ResponseEntity<?> listService() {
        return new ResponseEntity<>(serviceService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> createService(@RequestBody Service service) {
        serviceService.save(service);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/edit/{id}")
    public ResponseEntity<?> editService(@PathVariable int id) {
        Service service = serviceService.findById(id);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editEmployee(@RequestBody Service service) {
        serviceService.update(service);
        return new ResponseEntity<>(serviceService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> getDeleteService(@PathVariable int id) {
        Service service = serviceService.findById(id);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteService(@PathVariable int id) {
        serviceService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
