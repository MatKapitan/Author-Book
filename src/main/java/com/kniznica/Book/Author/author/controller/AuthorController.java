package com.kniznica.Book.Author.author.controller;


import com.kniznica.Book.Author.author.domain.Author;
import com.kniznica.Book.Author.author.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;


    // Create
    @PostMapping
    void createAuthor(@RequestBody Author author){
        authorService.createAuthor(author);
    }


     //Get all
//    @GetMapping
//    List<Author> allAuthors(@RequestParam(defaultValue = "createdAt", required = false) String sortBy){
//        return authorService.getAllAuthors(sortBy);
//    }


    // Get by id
    @GetMapping("/{id}")
    Author getAuthorById(@PathVariable Long id) throws Exception {
        return authorService.findAuthorById(id);
    }

    // Update
    @PutMapping
    Author updateAuthor(@RequestBody Author authorToUpdate) throws Exception {
       return authorService.updateAuthor(authorToUpdate);
    }

    @DeleteMapping("/{id}")
    void deleteAuthor(@PathVariable Long id) throws Exception {
        authorService.deleteAuthor(id);
    }

    @PutMapping("/{authorId}/addbook/{bookId}")
    void addBookToAuthor(@PathVariable Long authorId, @PathVariable Long bookId){
        authorService.addBookToAuthor(authorId,bookId);


    }










    @ExceptionHandler({ Exception.class })
    public ResponseEntity handleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
