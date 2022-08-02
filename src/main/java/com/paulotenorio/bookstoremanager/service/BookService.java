package com.paulotenorio.bookstoremanager.service;

import com.paulotenorio.bookstoremanager.dto.AuthorDTO;
import com.paulotenorio.bookstoremanager.dto.BookDTO;
import com.paulotenorio.bookstoremanager.dto.MessageRespondeDTO;
import com.paulotenorio.bookstoremanager.entity.Author;
import com.paulotenorio.bookstoremanager.entity.Book;
import com.paulotenorio.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService  {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageRespondeDTO create (@RequestBody BookDTO bookDTO) throws Error {
        Book convertedBook = this.convertBookDTOIntoBookEntity(bookDTO);
        Book savedBook = bookRepository.save(convertedBook);
        return new MessageRespondeDTO("Book created with ID " + savedBook.getId());
    }

    public List<BookDTO> findAll () {
        List<Book> bookList = bookRepository.findAll();
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book book : bookList) {
            bookDTOS.add(convertBookIntoBookDTOEntity(book));
        }
        return bookDTOS;
    }

    private Book convertBookDTOIntoBookEntity(BookDTO bookDTO) {
        Book book = new Book();
        Author authorDTO = book.getAuthor();
        Author author = new Author();
        book.setName(bookDTO.getName());
        book.setPages(bookDTO.getPages());
        book.setChapters(bookDTO.getChapters());
        book.setIsbn(bookDTO.getIsbn());
        book.setPublisherName(bookDTO.getPublisherName());
        author.setAge(bookDTO.getAuthor().getAge());
        author.setName(bookDTO.getAuthor().getName());
        book.setAuthor(author);
        return book;
    }

    private BookDTO convertBookIntoBookDTOEntity(Book book) {
        BookDTO bookDTO = new BookDTO();
        AuthorDTO authorDTO = bookDTO.getAuthor();
        AuthorDTO author = new AuthorDTO();

        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setPages(book.getPages());
        bookDTO.setChapters(book.getChapters());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setPublisherName(book.getPublisherName());
        author.setId(book.getId());
        author.setAge(book.getAuthor().getAge());
        author.setName(book.getAuthor().getName());

        bookDTO.setAuthor(author);
        return bookDTO;
    }

    public BookDTO findById(Long id) {
        Book savedBook = bookRepository.findById(id).get();
        return this.convertBookIntoBookDTOEntity(savedBook);
    }
}
