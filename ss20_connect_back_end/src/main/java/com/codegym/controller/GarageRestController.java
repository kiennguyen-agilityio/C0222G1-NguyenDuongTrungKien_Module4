package com.codegym.controller;

import com.codegym.model.Garage;
import com.codegym.model.Ticket;
import com.codegym.service.impl.GarageService;
import com.codegym.service.impl.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/garage")
@CrossOrigin(origins = "http://localhost:4200")
public class GarageRestController {
    @Autowired
    private GarageService service;

    @GetMapping("")
    public ResponseEntity<List<Garage>> listGarage() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}
