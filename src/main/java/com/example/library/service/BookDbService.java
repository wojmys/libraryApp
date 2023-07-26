package com.example.library.service;

import com.example.library.domain.Book;
import com.example.library.domain.dto.BookDto;
import com.example.library.mapper.BookMapper;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class BookDbService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;


    public BookDto saveBook(final BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        bookRepository.save(book);
        return bookMapper.mapToBookDto(book);
    }

    public Book getBookById(final Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}