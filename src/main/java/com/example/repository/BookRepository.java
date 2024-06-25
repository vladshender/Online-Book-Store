package com.example.repository;

import com.example.model.Book;
import java.util.List;

public interface BookRepository {
    Book save(Book book);

    Book getBookById(Long id);

    List<Book> findAll();
}
