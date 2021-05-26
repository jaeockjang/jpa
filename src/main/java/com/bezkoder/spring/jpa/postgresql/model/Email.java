package com.bezkoder.spring.jpa.postgresql.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Email implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    /** 굳이 이것이 필요할까?   referencedColumnName  @JoinColumn(name="BOOKSTORE_ID", referencedColumnName = "BOOKSTORE_ID", insertable = false, updatable = false )*/
//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}