package com.js9.spring6webapp.service;

import com.js9.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();

}
