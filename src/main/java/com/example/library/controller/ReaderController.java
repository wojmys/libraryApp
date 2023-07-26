package com.example.library.controller;

import com.example.library.domain.dto.ReaderDto;
import com.example.library.service.ReaderDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/library")
public class ReaderController {

    private final ReaderDbService readerDbService;

    @PostMapping(value = "reader")
    public ReaderDto createReader(@RequestBody ReaderDto readerDto) {
        return readerDbService.saveReader(readerDto);
    }
}