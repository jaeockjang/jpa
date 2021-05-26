package com.bezkoder.spring.jpa.postgresql.repository;

import com.bezkoder.spring.jpa.postgresql.model.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookStoreRepository extends JpaRepository<BookStore, Long>, JpaSpecificationExecutor<BookStore> {

    public List<BookStore> findByName(String name);

    @Transactional
    public void deleteAllByName(String name);

}
