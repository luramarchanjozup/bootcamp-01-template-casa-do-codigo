package com.bootcamp.cdd.controllers;

import com.bootcamp.cdd.models.Author;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {
    @GetMapping
    public List<Author> listAuthor () {
        return null;
    }
}
