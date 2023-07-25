package com.example.library.mapper;

import com.example.library.domain.Book;
import com.example.library.domain.dto.BookDto;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublicationYear()
        );
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getTitle(),
                book.getAuthor(),
                book.getPublicationYear()
        );
    }
}