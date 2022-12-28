package com.kniznica.Book.Author.author.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long>{
    long countByAllBook_Id(Long id);

//    @Query(value =
//            "SELECT a FROM author a "+
//            "ORDER BY :sortBy"
//            )
//    List<Author> findAll(String sortBy);





}