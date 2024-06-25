package com.example.service;

import com.example.dto.BookDto;
import com.example.dto.CreateBookRequestDto;
import java.util.List;

public interface BookService {
    BookDto save(CreateBookRequestDto book);

    BookDto getBookById(Long id);

    List<BookDto> findAll();
}
