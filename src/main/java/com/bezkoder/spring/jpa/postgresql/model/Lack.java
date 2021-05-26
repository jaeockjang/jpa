package com.bezkoder.spring.jpa.postgresql.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Lack {

    @Id
    @GeneratedValue
    @Column(name = "LACK_ID")
    private Long id;

    @Column(name = "LACK_POS")
    private String lackPos;

    @OneToMany(mappedBy = "lack" )
    private List<Book> books = new ArrayList<>();

    public void add(Book book) {
        books.add(book);
    }

}
