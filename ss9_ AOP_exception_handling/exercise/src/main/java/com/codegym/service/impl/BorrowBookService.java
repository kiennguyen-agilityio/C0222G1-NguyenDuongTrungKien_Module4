package com.codegym.service.impl;

import com.codegym.model.BorrowBook;
import com.codegym.repository.IBorrowBookRepository;
import com.codegym.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowBookService implements IBorrowBookService {
    @Autowired
    private IBorrowBookRepository repository;

    @Override
    public List<BorrowBook> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(BorrowBook borrowBook) {
        repository.save(borrowBook);
    }

    @Override
    public void update(BorrowBook borrowBook) {
        repository.save(borrowBook);
    }

    @Override
    public BorrowBook findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
