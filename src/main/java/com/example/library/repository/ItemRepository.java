package com.example.library.repository;

import com.example.library.domain.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    Long countAllByBook_Title(String title);
}