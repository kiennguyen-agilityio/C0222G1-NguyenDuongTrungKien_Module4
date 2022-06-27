package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "borrow_book")
public class BorrowBook {
    @Id
    private Integer id ;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
