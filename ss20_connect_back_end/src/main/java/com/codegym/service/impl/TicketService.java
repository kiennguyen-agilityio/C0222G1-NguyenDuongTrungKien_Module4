package com.codegym.service.impl;

import com.codegym.model.Ticket;
import com.codegym.repository.ITicketRepository;
import com.codegym.service.ITicketService;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private ITicketRepository iTicketRepository;

    @Override
    public Page<Ticket> findAll(Pageable pageable) {
        return iTicketRepository.findAll(pageable);
    }

    @Override
    public List<Ticket> findAll() {
        return iTicketRepository.findAll();
    }

    @Override
    public Ticket findById(int id) {
        return iTicketRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Ticket ticket) {
        iTicketRepository.save(ticket);
    }

    @Override
    public void delete(int id) {
        iTicketRepository.deleteById(id);
    }

//    @Override
//    public Page<Ticket> findAllByIdContainsOrNameContains(String search, Pageable pageable) {
//        return iTicketRepository.findAllByIdContainsOrNameContains(search, search, pageable);
//    }

    @Override
    public void update(Ticket ticket) {
        iTicketRepository.save(ticket);
    }

    @Override
    public Page<Ticket> search(String startPoint, String endPoint, Pageable pageble) {
        return iTicketRepository.search("%" + startPoint + "%", "%" + endPoint + "%", pageble);
    }
}
