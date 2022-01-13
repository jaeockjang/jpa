package com.bezkoder.spring.jpa.postgresql.database.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Builder
@Data
public class BookEntity {

//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
//    private LocalDateTime deletedAt;
    private Long id;
    private String isbn;
    private String title;
    private boolean delYn;

}
