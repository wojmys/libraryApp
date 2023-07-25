package com.example.library.mapper;

import com.example.library.domain.Item;
import com.example.library.domain.dto.ItemDto;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemDto mapToItemDto(final Item item) {
        return new ItemDto(
                item.getId(),
                item.getBook().getId(),
                item.getStatus()
        );
    }
}