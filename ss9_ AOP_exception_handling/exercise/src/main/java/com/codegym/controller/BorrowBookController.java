package com.codegym.controller;

import com.codegym.exception.BookException;
import com.codegym.exception.BorrowBookException;
import com.codegym.model.Book;
import com.codegym.model.BorrowBook;
import com.codegym.service.IBookService;
import com.codegym.service.IBorrowBookService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class BorrowBookController {
    @Autowired
    private IBorrowBookService borrowBookService;
    @Autowired
    private IBookService bookService;

    @GetMapping("/borrow/list")
    public String borrowList(Model model) {
        model.addAttribute("borrowBook", borrowBookService.findAll());
        return "borrow/list";
    }
    @GetMapping("/borrow/view/{id}")
    public ModelAndView viewBorrowCard(@PathVariable int id) {
        return new ModelAndView("borrow/detail", "borrowBook", borrowBookService.findById(id));
    }

    @GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable int id, RedirectAttributes redirectAttributes) throws BookException {
        BorrowBook borrowBook = new BorrowBook();
        Book book = bookService.findById(id);
        if (book == null || (book.getAmount()) == 0) {
            throw new BookException();
        } else {
            book.setAmount(book.getAmount() - 1);
            bookService.save(book);
            int borrowBookId = (int) (Math.random() * (89999 - 10000) + 10000);
            borrowBook.setId(borrowBookId);
            borrowBook.setBook(book);
            borrowBookService.save(borrowBook);
        }
        redirectAttributes.addFlashAttribute("message", "Mượn sách thành công");
        return "redirect:/borrow/book-list/";
    }

    @GetMapping("/return")
    public ModelAndView returnBook(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("borrow/detail");
        BorrowBook borrowBook = borrowBookService.findById(id);
        Book book = borrowBook.getBook();
        book.setAmount(book.getAmount() + 1);
        borrowBookService.delete(id);
        bookService.save(book);
        modelAndView.addObject("message", "Trả sách thành công");
        return modelAndView;
    }

    @ExceptionHandler(BorrowBookException.class)
    public ModelAndView showErrorPage() {
        return new ModelAndView("borrow/error-page");
    }

    @ExceptionHandler(BookException.class)
    public ModelAndView showBookErrorPage() {
        return new ModelAndView("book/error-page");
    }
}
