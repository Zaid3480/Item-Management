package com.itemmanagement.repository;

import com.itemmanagement.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ItemRepository {

    private final List<Item> items = new ArrayList<>();

    public Item save(Item item) {
        items.add(item);
        return item;
    }

    public Optional<Item> findById(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }
}
