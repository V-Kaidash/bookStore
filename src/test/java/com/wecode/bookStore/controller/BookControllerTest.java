package com.wecode.bookStore.controller;

import com.wecode.bookStore.dto.BookDto;
import com.wecode.bookStore.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @Test
    void shouldReturnBookDtoListWhenGetBooksCalled() {
        List<BookDto> bookDtos = new ArrayList<>();
        bookDtos.add(getBookDto());
        when(bookService.getBooks()).thenReturn(bookDtos);
        ResponseEntity<List<BookDto>> books = bookController.getBooks();
        assertThat(books.getBody().size()).isEqualTo(1);
        assertThat(books.getBody()).isNotNull();
    }

    private BookDto getBookDto() {
        return BookDto.builder()
                .title("Test title")
                .description("test description")
                .id(UUID.randomUUID())
                .releaseYear(2020)
                .build();
    }
}