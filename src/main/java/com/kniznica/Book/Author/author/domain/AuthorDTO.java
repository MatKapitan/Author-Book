package com.kniznica.Book.Author.author.domain;

public class AuthorDTO {

    private Long id;

    private String name;

    private Long countOfBooks;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCountOfBooks() {
        return countOfBooks;
    }

    public void setCountOfBooks(Long countOfBooks) {
        this.countOfBooks = countOfBooks;
    }
}

