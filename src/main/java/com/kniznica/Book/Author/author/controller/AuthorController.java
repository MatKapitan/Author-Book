package com.kniznica.Book.Author.author.controller;


import com.kniznica.Book.Author.author.domain.Author;
import com.kniznica.Book.Author.author.domain.AuthorDTO;
import com.kniznica.Book.Author.author.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;


    // Create
    @PostMapping
    public void createAuthor(@RequestBody Author author){
        authorService.createAuthor(author);
    }


     //Get all
    @GetMapping
    public Page<Author> allAuthors(@RequestParam(defaultValue = "createdAt", required = false) String sortBy,
                            @RequestParam(defaultValue = "0", required = false) int page,
                            @RequestParam(defaultValue = "5", required = false) int size,
                            @RequestParam(defaultValue = "DESC", required = false) String direction ){
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.valueOf(direction),sortBy));
        return authorService.getAllAuthors(pageable);
    }


    // Get by id
    @GetMapping("/{id}")
    public AuthorDTO getAuthorById(@PathVariable Long id) throws Exception {
        return authorService.findAuthorById(id);
    }

    // Update
    @PutMapping
    public Author updateAuthor(@RequestBody Author authorToUpdate) throws Exception {
       return authorService.updateAuthor(authorToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) throws Exception {
        authorService.deleteAuthor(id);
    }

    @PutMapping("/{authorId}/addbook/{bookId}")
    public void addBookToAuthor(@PathVariable Long authorId, @PathVariable Long bookId){
        authorService.addBookToAuthor(authorId,bookId);


    }











    @ExceptionHandler({ Exception.class })
    public ResponseEntity handleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
