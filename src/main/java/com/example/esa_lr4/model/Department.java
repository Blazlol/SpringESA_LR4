package com.example.esa_lr4.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "departments")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department extends BaseEntity{
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long unique_id;
    private String title;
    private String leader;

}

