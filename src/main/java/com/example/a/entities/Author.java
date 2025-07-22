package com.example.a.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Random;

@Getter
@Setter
@ToString

public class Author {
    @Setter(AccessLevel.NONE)
    private int id;
    private String name;
    private String surname;
    private String email;
    private LocalDate dob;
    private String avatar;

    public Author(String name, String surname, String email, String avatar, LocalDate dob) {
        Random random = new Random();
        this.id = random.nextInt(1, 1000);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.avatar = avatar;
        this.dob = dob;
    }
}
