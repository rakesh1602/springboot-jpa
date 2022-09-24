package com.example.learnWithDogesh.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BooksController {

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getBooks() {
        return "this is book testing";
    }
}
