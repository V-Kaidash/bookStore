package com.wecode.bookStore.controller;

import com.wecode.bookStore.dto.BookDto;
import com.wecode.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getBooks() {
         return ResponseEntity.ok(bookService.getBooks());
    }

    public ResponseEntity<List<BookDto>> getAuthors(){
        return null;
    }
}