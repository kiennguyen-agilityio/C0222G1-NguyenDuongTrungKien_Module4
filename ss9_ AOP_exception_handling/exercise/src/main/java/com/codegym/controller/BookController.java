package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.service.IBookService;
import com.codegym.service.IBorrowBookService;
import com.codegym.service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public ModelAndView showHomePage() {
        return new ModelAndView("index");
    }

    @GetMapping("/books")
    public ModelAndView showBookList() {
        return new ModelAndView("book/book-list", "books", bookService.findAll());
    }

    @GetMapping("/book/new")
    public ModelAndView showBookForm() {
        return new ModelAndView("book/new-book", "book", new Book());
    }

    @PostMapping("/book/save")
    public String addNewBook(@Valid @ModelAttribute Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book/new-book";
        }
        bookService.save(book);
        return "redirect:/books";
    }
}
