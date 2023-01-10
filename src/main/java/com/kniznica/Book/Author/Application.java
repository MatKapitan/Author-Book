package com.kniznica.Book.Author;

import com.kniznica.Book.Author.author.domain.Author;
import com.kniznica.Book.Author.author.domain.AuthorRepository;
import com.kniznica.Book.Author.author.service.AuthorService;
import com.kniznica.Book.Author.book.domain.Book;
import com.kniznica.Book.Author.book.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Application {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorService authorService;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	ApplicationRunner appStarted() {
		return args -> {
			Author ivan = this.authorRepository.save(createAuthor("Ivan"));
			this.authorRepository.save(createAuthor("Luka"));
			Book book1 = this.bookRepository.save(createBook("Suma stiborova", "3q412q542-2352", "fantasy"));
			Book book2 = this.bookRepository.save(createBook("Petar Pan", "sefsfs-234", "fantasy"));
			this.authorService.addBookToAuthor(ivan.getId(), book1.getId() );
			this.authorService.addBookToAuthor(ivan.getId(), book2.getId() );

		};
	}

	private Author createAuthor(String name) {
		Author author = new Author();
		author.setName(name);
		return author;
	}


	private Book createBook(String title, String isbn, String genre){
		return new Book(title,isbn,genre);

	}

}
