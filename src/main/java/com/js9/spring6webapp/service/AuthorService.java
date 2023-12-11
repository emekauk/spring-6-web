package com.js9.spring6webapp.service;

import com.js9.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
