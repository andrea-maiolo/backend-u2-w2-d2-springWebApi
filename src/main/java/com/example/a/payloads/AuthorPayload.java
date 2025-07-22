package com.example.a.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class AuthorPayload {
    private String name;
    private String surname;
    private String email;
    private String avatar;
    private LocalDate dob;
}
