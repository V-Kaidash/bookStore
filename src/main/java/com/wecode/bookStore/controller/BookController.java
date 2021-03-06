package com.wecode.bookStore.controller;

import com.wecode.bookStore.dto.BookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class BookController {

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getBooks() {
        BookDto book = BookDto.builder()
                .title("My first book title")
                .build();
        BookDto book2 = BookDto.builder()
                .title("My second book title")
                .build();

        List<BookDto> books = new ArrayList<>();
        books.add(book);
        books.add(book2);
         return ResponseEntity.ok(books);
    }

    public ResponseEntity<List<BookDto>> getAuthors(){
        return null;
    }
}
