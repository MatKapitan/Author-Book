package com.kniznica.Book.Author.book.domain;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        Page<Book> getBookByAny(@Param("attribute")String searchAttribute, @Param("page") Pageable page);











}
