package com.js9.spring6webapp.controller;

import com.js9.spring6webapp.domain.Book;
import com.js9.spring6webapp.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String fetchAll(Model model){
        Iterable<Book> allBooks = bookService.findAll();
        model.addAttribute("books", allBooks);

        return "books";
    }
}
