package com.example.library.controller;

import com.example.library.domain.dto.ReaderDto;
import com.example.library.service.ReaderDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/library")
public class ReaderController {

    @Autowired
    private final ReaderDbService readerDbService;

    @Autowired
    public ReaderController(ReaderDbService readerDbService) {
        this.readerDbService = readerDbService;
    }

    @PostMapping(value = "reader")
    public ReaderDto createReader(@RequestBody ReaderDto readerDto) {
        return readerDbService.saveReader(readerDto);
    }
}