package com.example.library.mapper;

import com.example.library.domain.Reader;
import com.example.library.domain.dto.ReaderDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ReaderMapper {

    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getName(),
                readerDto.getLastName()
        );
    }

    public ReaderDto mapToReaderDto(final Reader reader) {
        return new ReaderDto(
                reader.getName(),
                reader.getLastName(),
                reader.getAccountCreated()
        );
    }
}