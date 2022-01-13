package com.bezkoder.spring.jpa.postgresql.controller;

import com.bezkoder.spring.jpa.postgresql.model.Book;
import com.bezkoder.spring.jpa.postgresql.model.BookStore;
import com.bezkoder.spring.jpa.postgresql.repository.BookRepository;
import com.bezkoder.spring.jpa.postgresql.repository.BookStoreRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:8081")
@Log4j2
@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private BookStoreRepository bookStoreRepository;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/t00")
    public boolean test00(){
        BookStore bookStore = new BookStore();
        bookStore.setName("책방");
        BookStore bookStoreNew= bookStoreRepository.saveAndFlush(bookStore);

        Book book = new Book();
        book.setTitle("JPA");
        book.setIsbn("isbn-00");
//        Book bookNew= bookRepository.saveAndFlush(book);

//        bookStore.add(bookNew);
//        BookStore bookStoreNew= bookStoreRepository.saveAndFlush(bookStore);

        // 변경부분

//        book.setBookStore(bookStoreNew);
        book.setBookstoreId(bookStoreNew.getId());

        bookRepository.saveAndFlush(book);

        return true;

    }

    @GetMapping("/t00-1")
    public boolean test000(){
        BookStore bookStore = new BookStore();
        bookStore.setName("책방");
        BookStore bookStoreNew= bookStoreRepository.saveAndFlush(bookStore);

        List<Book> books = new ArrayList<>();
        for(int i=0; i<10; i++) {
            Book book = new Book();
            book.setTitle("JPA"+ i);
            book.setIsbn("isbn-00"+i);
            book.setBookstoreId(bookStoreNew.getId());
            books.add(book);
        }
        bookRepository.saveAll(books);

        return true;

    }

    @GetMapping("/t01")
    public ResponseEntity<List<BookStore>> test01() {
        List<BookStore> bookStores = bookStoreRepository.findByName("책방");
        return ResponseEntity.ok(bookStores);
    }




    @GetMapping("/t02")
    public boolean test02() {
        try {
            List<BookStore> bookStores = bookStoreRepository.findByName("책방");

            bookRepository.deleteAllByTitle("JPA");

            BookStore bookStore1= bookStores.get(0);
            System.out.println("name:" + bookStore1.getName());

            bookStore1.setDelYn(true);
            bookStoreRepository.saveAndFlush(bookStore1);

            return true;
        }catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            return false;
        }
    }

    @GetMapping("/t03/{bookStoreId}")
    public boolean test03(@PathVariable("bookStoreId") Long bookStoreId) {
        try {

            log.info("bookStoreId:"+bookStoreId);
            BookStore bookStore= new BookStore();
            bookStore.setId(bookStoreId);
//            bookRepository.deleteAllByBookStore(bookStore);

//            bookRepository.flush();

//            bookRepository.deleteById(20L);

            List<Book> books= bookRepository.findAllByBookStore(bookStore);
            books.forEach( x -> {

                System.out.println("Book id:" + x.getId());

            });
            if (!ObjectUtils.isEmpty(books)) {
                bookRepository.deleteAll(books);
                return true;
            }

            return false;
        }catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            return false;
        }
    }


    @GetMapping("/t04/{bookStoreId}")
    public boolean test04(@PathVariable("bookStoreId") Long bookStoreId) {
        try {

            log.info("bookStoreId:"+bookStoreId);
            BookStore bookStore= new BookStore();
            bookStore.setId(bookStoreId);

            bookRepository.deleteAllByBookStore(bookStore);

            return true;
        }catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            return false;
        }
    }


    @GetMapping("/t05/{bookStoreName}")
    public boolean test05(@PathVariable("bookStoreName") String bookStoreName) {
        try {

            log.info("bookStoreName:"+bookStoreName);

            bookStoreRepository.deleteAllByName(bookStoreName);

            return true;
        }catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            return false;
        }
    }

    @GetMapping("/t06/{bookStoreId}")
    public boolean test06(@PathVariable("bookStoreId") Long bookStoreId) {
        try {

            log.info("bookStoreId:"+bookStoreId);
            BookStore bookStore= new BookStore();
            bookStore.setId(bookStoreId);

            Book book = new Book();
            book.setIsbn("abcd-isbn");
            book.setTitle("Title-Jay");
            book.setBookStore(bookStore);

            bookRepository.save(book);

            return true;
        }catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            return false;
        }
    }


}
