package com.paulotenorio.bookstoremanager.controller;

import com.paulotenorio.bookstoremanager.dto.BookDTO;
import com.paulotenorio.bookstoremanager.dto.MessageRespondeDTO;
import com.paulotenorio.bookstoremanager.entity.Book;
import com.paulotenorio.bookstoremanager.repository.BookRepository;
import com.paulotenorio.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public MessageRespondeDTO create (@RequestBody @Valid BookDTO bookDTO) throws Error {
        return this.bookService.create(bookDTO);
    }

    @GetMapping
    public List<BookDTO> findAll () {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Long id) {
        return bookService.findById(id);
    }
}
