package com.example.a.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Setter
@Getter
@ToString

public class Blog {
    @Setter(AccessLevel.NONE)
    private int id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private int timeToRead;

    public Blog(String category, String title, String content, String cover) {
        Random random = new Random();
        this.id = random.nextInt(1, 1000);
        this.category = category;
        this.title = title;
        this.cover = cover;
        this.content = content;
        this.timeToRead = random.nextInt(1, 10);
    }
}
