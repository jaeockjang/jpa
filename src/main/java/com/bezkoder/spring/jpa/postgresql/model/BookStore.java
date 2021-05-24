package com.bezkoder.spring.jpa.postgresql.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class BookStore {
    @Id
    @GeneratedValue
    @Column(name = "BOOKSTORE_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "bookStore" ) //, fetch = FetchType.EAGER )

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name="BOOKSTORE_ID", referencedColumnName = "BOOKSTORE_ID", insertable = false, updatable = false )

    private List<Book> books = new ArrayList<>();

    public void add(Book book) {
        books.add(book);
    }

    @Column(name = "DEL_YN")
    private boolean delYn;

}

