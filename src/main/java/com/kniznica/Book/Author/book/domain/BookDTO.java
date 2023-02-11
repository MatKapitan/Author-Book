package com.kniznica.Book.Author.book.domain;

import java.time.LocalDateTime;

public class BookDTO {


    private Long id;
    private String title;
    private String isbn;
    private String genre;
    private LocalDateTime publishingDate;


    public BookDTO(Long id, String title, String isbn, String genre, LocalDateTime publishingDate) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;
        this.publishingDate = publishingDate;
    }

    public BookDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDateTime getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDateTime publishingDate) {
        this.publishingDate = publishingDate;
    }
}
