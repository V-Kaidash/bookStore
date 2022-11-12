package com.wecode.bookStore.controller;

import com.wecode.bookStore.dto.BookDto;
import com.wecode.bookStore.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Api(value = "Book api", tags = "Book api", produces = "application/json")
@RestController
@RequestMapping("api/v1")
public class BookController {
    @Autowired
    private BookService bookService;

    @ApiOperation(value = "get list of books", response = BookDto[].class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of books"),
            @ApiResponse(code = 403, message = "Accessing the resource tou were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getBooks() {
         return ResponseEntity.ok(bookService.getBooks());
    }

    public ResponseEntity<List<BookDto>> getAuthors(){
        return null;
    }
}