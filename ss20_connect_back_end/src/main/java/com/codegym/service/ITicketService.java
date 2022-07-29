package com.codegym.service;

import com.codegym.model.Ticket;
import org.omg.CORBA.TIMEOUT;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITicketService {
    Page<Ticket> findAll(Pageable pageable);

    List<Ticket> findAll();

    Ticket findById(int id);

    void save(Ticket ticket);

    void delete(int id);



    void update(Ticket ticket);

    List<Ticket> searchByStartPosition(String startPosition);
}
