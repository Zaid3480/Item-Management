package com.itemmanagement.service;

import com.itemmanagement.model.Item;
import com.itemmanagement.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository repository;


    private final List<Item> items = new ArrayList<>();

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public Item addItem(Item item) {
        return repository.save(item);
    }

    public Item getItemById(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
