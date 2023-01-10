package com.kniznica.Book.Author.author.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void findAll_NoInputGiven_shouldReturnAuthorsSortedByName() {
        List<Author> authors = authorRepository.findAll();
        assertThat(authors).isNotNull();
        System.out.println(authors);
    }
}