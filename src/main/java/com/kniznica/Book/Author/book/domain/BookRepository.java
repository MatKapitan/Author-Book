package com.kniznica.Book.Author.book.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository <Book , Long> {


        @Modifying
        @Query(value = """
        update book\s
        set publishing_date = now()\s
        where id =:id
        """, nativeQuery = true)
        void publishBookQuery(Long id);

//        @Query(value = """
//                select *
//                from book b
//                left join author_book ab on b.id = ab.book_id
//                left join author a  on ab.author_id  = author.id
//                where b.genre like ?1
//                or b.isbn like ?1
//                or b.title like ?1
//                or a."name" like ?1;
//                """, nativeQuery = true)

        @Query(value = """
                  select b.id , b.genre , b.isbn , b.publishing_date, b.title
                  from book b
                  left join author_book ab on b.id = ab.book_id
                  left join author a  on ab.author_id  = a.id
                  where b.genre ilike %:attribute%
                  or b.isbn ilike %:attribute%
                  or b.title ilike %:attribute%
                  or a."name" ilike %:attribute%
                """, nativeQuery = true)
        List<Book> getBookByAny(@Param("attribute")String searchAttribute);











}
