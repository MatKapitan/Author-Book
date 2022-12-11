package com.kniznica.Book.Author.author.service;


import com.kniznica.Book.Author.author.domain.AuthorRepository;
import com.kniznica.Book.Author.author.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author findAuthorById(Long id) throws Exception {
        return authorRepository.findById(id).orElseThrow(() -> new Exception("Author with id %s does not exist".formatted(id.toString())) );
    }


    // TODO: Radi al ne salje natrag exception
    public Author updateAuthor(Author authorToUpdate) throws Exception {
        if(authorRepository.existsById(authorToUpdate.getId())) {
            return authorRepository.save(authorToUpdate);
        }else{
            throw new Exception("Author with id %s does not exist".formatted(authorToUpdate.getId().toString()));
        }

    }

    public void deleteAuthor(Long id) throws Exception {
        if(!authorRepository.existsById(id)){
            throw new Exception("Author with id %s does not exist".formatted(id.toString()));
        }
        authorRepository.deleteById(id);
    }
}
