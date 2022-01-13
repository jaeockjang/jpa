package com.bezkoder.spring.jpa.postgresql.service;

import com.bezkoder.spring.jpa.postgresql.database.entity.BookEntity;
import com.bezkoder.spring.jpa.postgresql.domain.BookRequest;
import com.bezkoder.spring.jpa.postgresql.domain.BookResponse;
import com.bezkoder.spring.jpa.postgresql.dto.GwPage;
import com.bezkoder.spring.jpa.postgresql.model.Book;
import com.bezkoder.spring.jpa.postgresql.repository.BookRepository;
import com.bezkoder.spring.jpa.postgresql.repository.BookStoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    @Autowired
    private BookStoreRepository bookStoreRepository;
    @Autowired
    private BookRepository bookRepository;

    public BookResponse getBook(Long id) {
        log.info("id:{}",id);
        BookResponse response=null;
        Book book = bookRepository.findById(id).orElse(null);
        if (book !=null) {
            BookEntity bookEntity = BookEntity.builder()
                    .id(book.getId())
                    .title(book.getTitle())
                    .build()
                    ;
             response=BookResponse.builder()
                     .id(bookEntity.getId())
                     .title(bookEntity.getTitle())
                     .build();
        }
        return response;

    }

    public GwPage<BookResponse> getBooksByTitle(String title) {
        log.info("title:{}",title);
        GwPage<BookResponse> responseList=new GwPage<BookResponse>();
        List<Book> books = bookRepository.findByTitle(title);
        if (books !=null) {
            books.forEach(x-> {
                BookResponse response=BookResponse.builder()
                        .id(x.getId())
                        .title(x.getTitle())
                        .build();
                responseList.addElement(response);

            });
        }
        return responseList;

    }

    public GwPage<BookResponse> getBooksByTitle2(BookRequest bookRequest) {
        log.info("title:{}",bookRequest.getTitle());
        GwPage<BookResponse> responseList=new GwPage<BookResponse>();
        List<Book> books = bookRepository.findByTitle(bookRequest.getTitle());
        if (books !=null) {
            responseList.setSize(bookRequest.getSize());
            responseList.setTotalElements(books.size());
            responseList.setTotalPages(books.size() / bookRequest.getSize());
//            responseList.setTotalPages(books);

            books.forEach(x-> {
                BookResponse response=BookResponse.builder()
                        .id(x.getId())
                        .title(x.getTitle())
                        .build();
                responseList.addElement(response);

            });
        }
        return responseList;

    }

}
