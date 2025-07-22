package com.example.a.services;

import com.example.a.entities.Blog;
import com.example.a.exceptions.NotfoundException;
import com.example.a.payloads.BlogPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    public List<Blog> fakeBlogDb = new ArrayList<>();

    public Blog saveBlog(BlogPayload payload) {
        Blog newBlog = new Blog(payload.getCategory(), payload.getTitle(), payload.getContent(), "https://picsum.photos/200/300");
        this.fakeBlogDb.add(newBlog);
        System.out.println("blog " + newBlog.getTitle() + " added");
        return newBlog;
    }

    public List<Blog> findAll() {
        return fakeBlogDb;
    }

    public Blog findBlogById(int blogId) {
        for (Blog current : fakeBlogDb) {
            if (current.getId() == blogId) {
                return current;
            }
        }
        throw new NotfoundException("blog not found");
    }

    public Blog modifyBlog(BlogPayload payload, int blogId) {
        Blog found = findBlogById(blogId);
        found.setCategory(payload.getCategory());
        found.setTitle(payload.getTitle());
        found.setContent(payload.getContent());
        return found;
    }


}
