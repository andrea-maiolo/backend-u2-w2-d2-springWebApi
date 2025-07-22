package com.example.a.services;

import com.example.a.entities.Author;
import com.example.a.exceptions.NotfoundException;
import com.example.a.payloads.AuthorPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {


    public List<Author> fakeAuthorDb = new ArrayList<>();

    public Author saveAuthor(AuthorPayload payload) {
        Author newAuthor = new Author(payload.getName(), payload.getSurname(), payload.getEmail()
                , "https://picsum.photos/200/300", payload.getDob());
        this.fakeAuthorDb.add(newAuthor);
        return newAuthor;
    }

    public List<Author> findAll() {
        return fakeAuthorDb;
    }

    public Author findAuthorById(int AuthorId) {
        for (Author current : fakeAuthorDb) {
            if (current.getId() == AuthorId) {
                return current;
            }
        }
        throw new NotfoundException("blog not found");
    }

    public Author modifyAuthor(AuthorPayload payload, int AuthorId) {
        Author found = findAuthorById(AuthorId);
        found.setName(payload.getName());
        found.setSurname(payload.getSurname());
        found.setEmail(payload.getEmail());
        found.setDob(payload.getDob());
        return found;
    }

    public void deleteAuthor(int AuthorId) {
        Author found = findAuthorById(AuthorId);
        fakeAuthorDb.remove(found);
    }


}
