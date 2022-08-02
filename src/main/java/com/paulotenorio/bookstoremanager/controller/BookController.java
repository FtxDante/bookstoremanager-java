package com.paulotenorio.bookstoremanager.controller;

import com.paulotenorio.bookstoremanager.dto.MessageRespondeDTO;
import com.paulotenorio.bookstoremanager.entity.Book;
import com.paulotenorio.bookstoremanager.repository.BookRepository;
import com.paulotenorio.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public MessageRespondeDTO create (@RequestBody Book book) {
        return this.bookService.create(book);
    }

    @GetMapping
    public List<Book> findAll () {
        return bookService.findAll();
    }
}
