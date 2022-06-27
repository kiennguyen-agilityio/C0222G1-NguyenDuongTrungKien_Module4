package com.codegym.repository;

import com.codegym.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IBorrowBookRepository extends JpaRepository<BorrowBook,Integer> {
}
