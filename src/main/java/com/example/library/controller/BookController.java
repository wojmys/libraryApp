package com.example.library.controller;

import com.example.library.domain.dto.BookDto;
import com.example.library.service.BookDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/library")
@RequiredArgsConstructor
public class BookController {

    private final BookDbService bookDbService;

    @PostMapping(value = "book")
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return bookDbService.saveBook(bookDto);
    }

}
