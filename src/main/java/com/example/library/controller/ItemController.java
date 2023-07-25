package com.example.library.controller;

import com.example.library.domain.dto.ItemDto;
import com.example.library.service.ItemDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping("v1/library")
    public class ItemController {

        private final ItemDbService itemDbService;

        @Autowired
        public ItemController(ItemDbService itemDbService) {
            this.itemDbService = itemDbService;
        }

        @PostMapping(value = "item")
        public ItemDto createItem(@RequestBody ItemDto itemDto) {
            return itemDbService.saveItem(itemDto);
        }

        @PutMapping(value = "item")
        public ItemDto updateStatus(@RequestBody ItemDto itemDto) {
            return itemDbService.updateStatus(itemDto);
        }

        @GetMapping(value = "items/count")
        public Long getNumberOfItemsByTitle(@RequestParam String title) {
            return itemDbService.getNumberOfItemsByTitle(title);
        }
    }

