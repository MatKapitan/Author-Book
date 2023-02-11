package com.kniznica.Book.Author.book.controller;


import com.kniznica.Book.Author.book.domain.Book;
import com.kniznica.Book.Author.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok( bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @GetMapping("/attribute")
    public Page<Book> searchByAnyAttribute(@RequestParam String any,
                                    @PageableDefault(value = 5, page = 0)
                                    @SortDefault(sort = "title", direction = Sort.Direction.DESC) Pageable page){
        return bookService.findBookByAny(any, page);
    }

    @PostMapping
    public void createBook(@RequestBody Book book){
        bookService.createBook(book);
    }

    @PatchMapping("/publish/{id}")
    public void publishBook(@PathVariable Long id){
        bookService.publishBook(id);
    }



}
