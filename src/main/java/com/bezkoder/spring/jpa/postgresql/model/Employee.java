package com.bezkoder.spring.jpa.postgresql.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    /** mappedBy가 지정되어 주인이 아니므로 입력을 할 수 없다. */
//    @OneToMany(fetch = FetchType.LAZY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
//    @OneToMany( mappedBy = "employee")
    private List<Email> emails=new ArrayList<>();

}