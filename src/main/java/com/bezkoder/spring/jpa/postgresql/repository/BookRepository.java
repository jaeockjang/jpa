package com.bezkoder.spring.jpa.postgresql.repository;

import com.bezkoder.spring.jpa.postgresql.model.Book;
import com.bezkoder.spring.jpa.postgresql.model.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> , JpaSpecificationExecutor<Book> {

    public <Optional> Book findByTitle(String title);

    @Transactional
    public void deleteAllByTitle(String title);

    @Transactional
    public void deleteAllByBookStore(BookStore bookStore);

    public List<Book> findAllByBookStore(BookStore bookStore);


}
