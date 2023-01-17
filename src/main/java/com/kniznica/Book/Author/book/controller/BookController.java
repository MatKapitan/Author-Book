package com.kniznica.Book.Author.book.controller;


import com.kniznica.Book.Author.book.domain.Book;
import com.kniznica.Book.Author.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }
    @PostMapping
    void createBook(@RequestBody Book book){
        bookService.createBook(book);
    }
    @PutMapping("/publish/{id}")
    int publishBook(@PathVariable Long id){
        bookService.publishBook(id);
        return 1;
    }

    @GetMapping("/attribute/{any}")
    List<Book> searchByAniAtribute(@PathVariable String any){
        return bookService.findBookByAny(any);
    }


}
