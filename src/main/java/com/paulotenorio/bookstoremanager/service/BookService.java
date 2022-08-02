package com.paulotenorio.bookstoremanager.service;

import com.paulotenorio.bookstoremanager.dto.MessageRespondeDTO;
import com.paulotenorio.bookstoremanager.entity.Book;
import com.paulotenorio.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookService  {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageRespondeDTO create (@RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        return new MessageRespondeDTO("Book created with ID " + savedBook.getId());
    }

    public List<Book> findAll () {
        return bookRepository.findAll();
    }

}
