package com.example.a.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Author {
    private int id;
    private String name;
    private String surname;
    private String email;
    private LocalDate dob;
    private String avatar;
}
