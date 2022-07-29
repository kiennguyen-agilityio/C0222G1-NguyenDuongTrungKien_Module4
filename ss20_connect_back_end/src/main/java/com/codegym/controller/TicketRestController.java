package com.codegym.controller;

import com.codegym.model.Ticket;
import com.codegym.service.impl.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/ticket")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketRestController {
    @Autowired
    private TicketService service;

    @GetMapping("")
    public ResponseEntity<List<Ticket>> listTicket() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    //
    @PostMapping("/save")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        service.save(ticket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //
    @GetMapping("/{id}")
    private ResponseEntity<Ticket> findById(@PathVariable int id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    private ResponseEntity<?> updateTicket(@PathVariable int id) {
        Ticket ticket = service.findById(id);
        ticket.setAmount(ticket.getAmount() - 1);
        service.save(ticket);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //
//    @GetMapping("/delete/{id}")
//    public ResponseEntity<?> getDeletingTicket(@PathVariable Integer id) {
//        Ticket ticket = service.findById(id);
//        return new ResponseEntity<>(ticket, HttpStatus.OK);
//    }
//
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//
    @GetMapping("/search/{startPosition}&{endPosition}")
    public ResponseEntity<?> search(@PathVariable String startPosition, @PathVariable String endPosition,
                                    @RequestParam(name = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("id").ascending();
        Page<Ticket> tickets = service.search(startPosition, endPosition, PageRequest.of(page, 4, sort));
        if (tickets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }
}
