package com.wecode.bookStore.repository;

import com.wecode.bookStore.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    @Sql(scripts = {"classpath:InsertInitialBookRecordForTest.sql"})
    void shouldAbleToFetchAllBooksInDb() {
        List<Book> all = (List<Book>) bookRepository.findAll();

        assertEquals(all.size(), 2);
    }

    @Test
    @Sql(scripts = {"classpath:InsertInitialBookRecordForTest.sql"})
    void shouldReturnOneBookWhenTitleIsTestBookTitle() {
        List<Book> books = bookRepository.findBooksByTitle("Test Book Title");

        assertEquals(books.size(), 1);
    }
}
