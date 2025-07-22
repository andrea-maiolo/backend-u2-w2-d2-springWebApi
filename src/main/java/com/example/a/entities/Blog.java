package com.example.a.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class Blog {
    private int id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private int timeToRead;
}
