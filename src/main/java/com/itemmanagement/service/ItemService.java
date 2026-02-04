package com.itemmanagement.service;

import com.itemmanagement.model.Item;
import com.itemmanagement.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public Item addItem(Item item) {
        return repository.save(item);
    }

    public Item getItemById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }
}
