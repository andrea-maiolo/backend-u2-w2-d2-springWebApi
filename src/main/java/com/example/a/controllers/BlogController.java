package com.example.a.controllers;

import com.example.a.entities.Blog;
import com.example.a.payloads.BlogPayload;
import com.example.a.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping
    public List<Blog> getBlogs() {
        return this.blogService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Blog addBlog(@RequestBody BlogPayload payload) {
        return this.blogService.saveBlog(payload);
    }

    @GetMapping("/{blogId}")
    public Blog getBlogById(@PathVariable int blogId) {
        return this.blogService.findBlogById(blogId);
    }

    @PutMapping("/{blogId}")
    public Blog modifyBlog(@RequestBody BlogPayload payload, @PathVariable int blogId) {
        return this.blogService.modifyBlog(payload, blogId);
    }

    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlog(@PathVariable int blogId) {
        this.blogService.deleteBlog(blogId);
    }

}
