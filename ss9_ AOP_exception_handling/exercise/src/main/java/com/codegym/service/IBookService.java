package com.codegym.service;

import com.codegym.model.Book;
import com.codegym.model.BorrowBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> findAll();

    void save(Book book);

    void update(Book book);

    Book findById(Integer id);

    void delete(int id);
}
