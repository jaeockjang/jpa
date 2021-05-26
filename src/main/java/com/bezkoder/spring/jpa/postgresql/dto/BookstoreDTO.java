package com.bezkoder.spring.jpa.postgresql.dto;

import com.bezkoder.spring.jpa.postgresql.model.Book;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BookstoreDTO extends BaseResultDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 8985345195223610713L;

    private Long id;
    private String name;
    private List<Book> books = new ArrayList<>();

}
