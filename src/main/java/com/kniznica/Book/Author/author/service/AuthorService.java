package com.kniznica.Book.Author.author.service;


import com.kniznica.Book.Author.author.domain.AuthorDTO;
import com.kniznica.Book.Author.author.domain.AuthorRepository;
import com.kniznica.Book.Author.author.domain.Author;
import com.kniznica.Book.Author.book.domain.Book;
import com.kniznica.Book.Author.book.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;




    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    public List<Author> getAllAuthors(String sortBy){
        return authorRepository.findAll(sortBy);
    }

    public AuthorDTO findAuthorById(Long id) throws Exception {
        Author x = authorRepository.findById(id).orElseThrow(() -> new Exception("Author with id %s does not exist".formatted(id.toString())) );
        return authorDtoTransformer(x);
    }


    // TODO:
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

    @Transactional
    public void addBookToAuthor(Long authorId, Long bookId) {
        Author joinAuthor = authorRepository.findById(authorId).orElseThrow(() -> new IllegalArgumentException("Author not found"));
        Book joinBook = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Book not found"));
        joinBook.allAuthors.add(joinAuthor);
        bookRepository.save(joinBook);
    }

    AuthorDTO authorDtoTransformer(Author author){
        AuthorDTO newAuthor = new AuthorDTO();
        newAuthor.setName(author.getName());
        newAuthor.setId(author.getId());
        newAuthor.setCountOfBooks(authorRepository.countByAllBook_AllAuthors_Id(author.getId()));
        return newAuthor;
    }


}
