package com.example.esa_lr4.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "students")
public class Student extends BaseEntity{
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column(name = "unique_id")
   // private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Long department_id;
}
