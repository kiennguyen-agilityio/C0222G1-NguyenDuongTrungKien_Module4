package com.codegym.service;

import com.codegym.model.BorrowBook;

import java.util.List;
import java.util.Optional;

public interface IBorrowBookService {
    List<BorrowBook> findAll();

    void save(BorrowBook borrowBook);

    void update(BorrowBook borrowBook);

    BorrowBook findById(Integer id) ;

    void delete(int id);
}
