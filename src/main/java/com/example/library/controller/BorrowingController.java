package com.example.library.controller;

import com.example.library.domain.dto.BorrowingDto;
import com.example.library.service.BorrowingDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/library")
public class BorrowingController {

    private final BorrowingDbService borrowingDbService;

    @Autowired
    public BorrowingController(BorrowingDbService borrowingDbService) {
        this.borrowingDbService = borrowingDbService;
    }

    @PostMapping(value = "borrowing")
    public BorrowingDto createBorrowing(@RequestBody BorrowingDto borrowingDto) {
        return borrowingDbService.saveBorrowing(borrowingDto);
    }

    @PutMapping(value = "returnBook")
    public BorrowingDto returnBook(@RequestBody BorrowingDto borrowingDto) {
        return borrowingDbService.returnBook(borrowingDto);
    }
}
