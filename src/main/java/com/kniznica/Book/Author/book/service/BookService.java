package com.kniznica.Book.Author.book.service;


import com.kniznica.Book.Author.book.domain.Book;
import com.kniznica.Book.Author.book.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    public void publishBook(Long id) {
        bookRepository.publishBookQuery(id);
    }

    public Page<Book> findBookByAny(String searchAttribute, Pageable page){
        return bookRepository.getBookByAny(searchAttribute, page);
    }
}
