package com.kniznica.Book.Author.author.domain;

import com.kniznica.Book.Author.author.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class AuthorRepositoryTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    @Test
    public void findAll_NoInputGiven_shouldReturnAuthorsSortedByName() {
        Pageable page = Pageable.unpaged();
        given(authorRepository.findAll(page)).willReturn(Page.empty());
        Page<Author> authors = authorService.getAllAuthors(page);
        assertThat(authors).isNotNull();
        assertThat(authors).size().isEqualTo(0);
    }
    @Test
    public void updateAuthor_AuthorDoesNotExist_shouldThrowException() {
        Pageable page = Pageable.unpaged();
        given(authorRepository.existsById(1L)).willReturn(false);
        Exception exception = assertThrows(Exception.class, () -> {
            Author authorToUpdate = new Author();
            authorToUpdate.setId(1L);
            authorService.updateAuthor(authorToUpdate);
        });
        assertThat(exception).extracting(Throwable::getMessage)
                .isEqualTo("Author with id %s does not exist".formatted(1L));
    }
}