package com.example.library.service;

import com.example.library.domain.Borrowing;
import com.example.library.domain.Item;
import com.example.library.domain.Reader;
import com.example.library.domain.Status;
import com.example.library.domain.dto.BorrowingDto;
import com.example.library.mapper.BorrowingMapper;
import com.example.library.repository.BorrowingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class BorrowingDbService {

    private final BorrowingMapper borrowingMapper;
    private final BorrowingRepository borrowingRepository;
    private final ReaderDbService readerDbService;
    private final ItemDbService itemDbService;


    public BorrowingDto saveBorrowing(final BorrowingDto borrowingDto) {
        Reader reader = readerDbService.getReaderById(borrowingDto.getReaderId());
        Item item = itemDbService.getItemById(borrowingDto.getItemId());
        Borrowing borrowing = new Borrowing(item, reader);
        borrowing.setBorrowedFrom(new Date());
        borrowingRepository.save(borrowing);
        return borrowingMapper.mapToBorrowingDto(borrowing);
    }

    public BorrowingDto returnBook(final BorrowingDto borrowingDto) {
        Borrowing borrowing = getBorrowingById(borrowingDto.getBorrowingId());
        borrowing.setBorrowedTo(new Date());
        if (borrowingDto.isPaidForDamaged()) {
            borrowing.getItem().setStatus(Status.AVAILABLE);
            borrowing.setPaidForDamaged(true);
        }
        borrowingRepository.save(borrowing);
        return borrowingMapper.mapToBorrowingDto(borrowing);
    }

    public Borrowing getBorrowingById(final Long id) {
        return borrowingRepository.findById(id).orElse(null);
    }
}