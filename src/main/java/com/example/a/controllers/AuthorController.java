package com.example.a.controllers;


import com.example.a.entities.Author;
import com.example.a.payloads.AuthorPayload;
import com.example.a.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAuthor() {
        return this.authorService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody AuthorPayload payload) {
        return this.authorService.saveAuthor(payload);
    }

    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable int authorId) {
        return this.authorService.findAuthorById(authorId);
    }

    @PutMapping("/{authorId}")
    public Author modifyAuthor(@RequestBody AuthorPayload payload, @PathVariable int authorId) {
        return this.authorService.modifyAuthor(payload, authorId);
    }

    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int authorId) {
        this.authorService.deleteAuthor(authorId);
    }


}
