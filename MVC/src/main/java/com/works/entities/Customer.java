package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @Column(length = 100)
    @Size(min = 3, max = 100)
    @NotEmpty
    @NotNull
    private String name;

    @Column(unique = true, length = 500)
    @Email
    @NotEmpty
    @NotNull
    private String email;

    @Column(length = 500)
    @NotEmpty
    @NotNull
    private String password;

    //@Max(99)
    //@Min(18)
    //@NotNull
    private Integer age;

}
