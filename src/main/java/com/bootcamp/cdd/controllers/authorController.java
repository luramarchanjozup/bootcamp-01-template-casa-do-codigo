package com.bootcamp.cdd.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/author")
public class authorController {
    @GetMapping
    public String listAuthor () {
        return "alo";
    }
}
