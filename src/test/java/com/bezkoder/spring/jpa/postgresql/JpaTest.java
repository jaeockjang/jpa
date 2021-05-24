package com.bezkoder.spring.jpa.postgresql;

import com.bezkoder.spring.jpa.postgresql.model.Book;
import com.bezkoder.spring.jpa.postgresql.model.BookStore;
import com.bezkoder.spring.jpa.postgresql.repository.BookRepository;
import com.bezkoder.spring.jpa.postgresql.repository.BookStoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
public class JpaTest {
    @Autowired
    private BookStoreRepository bookStoreRepository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    @Transactional
    public void testNew() {


        BookStore bookStore = new BookStore();
        bookStore.setName("책방");
        bookStoreRepository.save(bookStore);

        Book book = new Book();
        book.setTitle("JPA");
        // 변경부분
        book.setBookStore(bookStore);
        bookRepository.save(book);




    }



    @Test
    @Transactional
    public void test() {
//        BookStore bookStore = new BookStore();
//        bookStore.setName("책방");
//        bookStoreRepository.save(bookStore);
//        Book book = new Book();
//        book.setTitle("JPA");
//        bookStore.add(book);
//        bookRepository.save(book);


//        BookStore bookStore = new BookStore();
//        bookStore.setName("책방");
//        bookStoreRepository.save(bookStore);
//
//        Book book = new Book();
//        book.setTitle("JPA");
//        // 변경부분
//        book.setBookStore(bookStore);
//        bookRepository.save(book);


//        Book book = new Book();
//        book.setTitle("JPA");

//         Book book=bookRepository.findByTitle("JPA");
//          System.out.println(book.toString());

//         bookStoreRepository.deleteAllByBooks(book);

//        bookRepository.deleteAllByTitle("JPA");

//         Book book=bookRepository.findByTitle("JPA");
//         bookRepository.deleteById(book.getId());

//        Optional<BookStore> bookStore = bookStoreRepository.findByName("책방");
//        if (bookStore.isPresent()) {
//
//            bookRepository.deleteAllByTitle("JPA");
//
//            BookStore bookStore1= bookStore.get();
//            System.out.println(bookStore1);
//            bookStore1.setDelYn(true);
//            bookStoreRepository.saveAndFlush(bookStore1);
//
//
//        } else {
//            System.out.println("no data.");
//
//        }


    }

}

