package com.bezkoder.spring.jpa.postgresql.repository;

import com.bezkoder.spring.jpa.postgresql.model.Book;
import com.bezkoder.spring.jpa.postgresql.model.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface BookStoreRepository extends JpaRepository<BookStore, Long> {

    public List<BookStore> findByName(String name);

    @Transactional
    public void deleteAllByName(String name);

}
