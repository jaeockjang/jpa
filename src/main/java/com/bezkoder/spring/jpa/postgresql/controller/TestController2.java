package com.bezkoder.spring.jpa.postgresql.controller;

import com.bezkoder.spring.jpa.postgresql.domain.BookRequest;
import com.bezkoder.spring.jpa.postgresql.domain.BookResponse;
import com.bezkoder.spring.jpa.postgresql.dto.GwPage;
import com.bezkoder.spring.jpa.postgresql.service.BookService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api2")
public class TestController2 {

    private final BookService bookService;

    @GetMapping("/{id}")
    public BookResponse getBook(
            @PathVariable(value = "id") Long id
    ) {
        BookResponse response=null;
        try {
            response= bookService.getBook(id);
            log.info("API response:"+response);
            BookResponse.success(response);
        }catch (Exception e) {
            BookResponse.fail(response);
        }

        return  response;
    }

    @GetMapping("/byTitle")
    public GwPage<BookResponse> getBook(
            @Parameter(description = "title", required = false, example = "") String title
    ) {
        GwPage<BookResponse> response = null;
        try {
            log.info("request:-------");
            log.info("bookRequest"+title);
            response = bookService.getBooksByTitle(title);
            log.info("API response:" + response);
            GwPage.success(response);
        } catch (Exception e) {
            GwPage.fail(response);
        }

        return response;
    }

    @PostMapping("/byTitle")
    public GwPage<BookResponse> getBook2(
//            @Parameter(description = "title", required = false, example = "") String title
            @RequestBody BookRequest bookRequest
    ) {
        GwPage<BookResponse> response = null;
        try {
            log.info("request:-------");
            log.info("bookRequest"+bookRequest);
            response = bookService.getBooksByTitle2(bookRequest);
            log.info("API response:" + response);
            GwPage.success(response);
        } catch (Exception e) {
            GwPage.fail(response);
        }

        return response;
    }



}
