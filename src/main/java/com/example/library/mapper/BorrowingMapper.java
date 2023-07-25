package com.example.library.mapper;

import com.example.library.domain.Borrowing;
import com.example.library.domain.dto.BorrowingDto;
import org.springframework.stereotype.Component;

@Component
public class BorrowingMapper {

    public BorrowingDto mapToBorrowingDto(final Borrowing borrowing) {
        return new BorrowingDto(
                borrowing.getReader().getId(),
                borrowing.getItem().getId(),
                borrowing.getId(),
                borrowing.isPaidForDamaged()
        );
    }
}