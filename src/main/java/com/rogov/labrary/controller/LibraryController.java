package com.rogov.labrary.controller;


import com.rogov.labrary.dto.OptionFilter;
import com.rogov.labrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class LibraryController {


    private final BookService bookService;

    @Autowired
    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = "/book/book.csv", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getCsvBook(@Valid @RequestBody OptionFilter optionFilter, HttpServletResponse response) {


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "text/plain; charset=utf-8");

        ResponseEntity<String> stringResponseEntity = new ResponseEntity<>(bookService.getCsvBooks(optionFilter), httpHeaders, HttpStatus.OK);
        return stringResponseEntity;
    }
}
