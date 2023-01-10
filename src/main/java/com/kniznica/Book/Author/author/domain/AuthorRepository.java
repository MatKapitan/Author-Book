package com.kniznica.Book.Author.author.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface AuthorRepository extends JpaRepository<Author,Long>{


    @Query(value = """
            SELECT a FROM Author a
            ORDER BY :sortBy"""
            )
    List<Author> findAll(String sortBy);

    @Query(value = """
            select count(*) 
            from author_book ab 
            where author_id =:id
            """, nativeQuery = true)
    long countByAllBook_AllAuthors_Id(Long id);







}