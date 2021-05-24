package com.bezkoder.spring.jpa.postgresql.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "BOOK_ID")
    private Long id;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DEL_YN")
    private boolean delYn;

    @Column(name = "BOOKSTORE_ID")
    private Long bookstoreId;

    @ManyToOne
    @JoinColumn(name="BOOKSTORE_ID", referencedColumnName="BOOKSTORE_ID", insertable = false, updatable = false)
    private BookStore bookStore;
}


