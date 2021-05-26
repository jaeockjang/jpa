package com.bezkoder.spring.jpa.postgresql.controller;

import com.bezkoder.spring.jpa.postgresql.dto.BookstoreDTO;
import com.bezkoder.spring.jpa.postgresql.dto.GwPage;
import com.bezkoder.spring.jpa.postgresql.dto.PageParam;
import com.bezkoder.spring.jpa.postgresql.model.*;
import com.bezkoder.spring.jpa.postgresql.repository.*;
import com.bezkoder.spring.jpa.postgresql.service.TestService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

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
    @Autowired
    private LackRepository lackRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmailRepository emailRepository;




    @Autowired
    private TestService testService;


//    @GetMapping("/s00")
//    public Mono<GwPage<BookstoreDTO>> service00(PageParam pageParam){
//
//
//    }





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

    @GetMapping("/t20")
    public boolean test20(){
        BookStore bookStore = new BookStore();
        bookStore.setName("책방");
        BookStore bookStoreNew= bookStoreRepository.saveAndFlush(bookStore);

        Lack lack = new Lack();
        lack.setLackPos("좌20:높이30");
        Lack lackNew= lackRepository.saveAndFlush(lack);


        Book book = new Book();
        book.setTitle("JPA");
        book.setIsbn("isbn-00");
        book.setBookstoreId(bookStoreNew.getId());
        book.setLackId(lackNew.getId());
        bookRepository.saveAndFlush(book);

        return true;

    }

    @GetMapping("/t30")
    public Email test30(){

        Employee employee= new Employee();
        Employee employeeNew= employeeRepository.saveAndFlush(employee);

        Email email= new Email();
        email.setEmployee(employeeNew);
        Email emailNew= emailRepository.save(email);


        return emailNew;

    }

    @GetMapping("/t30-1")
    public List<Employee> test30_1(){
        return employeeRepository.findAll();
    }

    @GetMapping("/t30-2")
    public List<Email> test30_2(){
        return emailRepository.findAll();
    }

    @GetMapping("/t30-3")
    public Optional<Email> test30_3(){
        return emailRepository.findById(146L);
    }

    @GetMapping("/t31")
    public boolean test31(){
        List<Email> emails=new ArrayList<>();

        for(int i=0; i<10; i++) {
            Email email = new Email();

            emails.add(email);
        }
        List<Email> emailsNew= emailRepository.saveAll(emails);
        emailsNew.forEach(System.out::println);

        Employee employee= new Employee();
        employee.setEmails(emailsNew);
        Employee employeeNew= employeeRepository.saveAndFlush(employee);

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
