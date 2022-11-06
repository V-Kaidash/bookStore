package com.wecode.bookStore.service.impl;

import com.wecode.bookStore.dto.BookDto;
import com.wecode.bookStore.model.Book;
import com.wecode.bookStore.repository.BookRepository;
import com.wecode.bookStore.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final ModelMapper modelMapper;

    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<BookDto> getBooks() {
        Iterable<Book> books = bookRepository.findAll();

        return StreamSupport.stream(books.spliterator(), false)
                .map(toBookDto())
                .collect(Collectors.toList());
    }

    private Function<Book, BookDto> toBookDto() {
        return book -> modelMapper.map(book, BookDto.class);
    }
}