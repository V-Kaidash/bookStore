package com.wecode.bookStore.service;

import com.wecode.bookStore.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> getBooks();
}