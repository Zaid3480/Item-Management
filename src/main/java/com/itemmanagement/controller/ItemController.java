package com.itemmanagement.controller;

import com.itemmanagement.model.Item;
import com.itemmanagement.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    // Add new item
    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody Item item) {

        if (item.getName() == null || item.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Item name is required");
        }

        if (item.getPrice() <= 0) {
            return ResponseEntity.badRequest().body("Price must be greater than 0");
        }

        return ResponseEntity.ok(service.addItem(item));
    }

    // Get item by ID
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        return ResponseEntity.ok(service.getItemById(id));
    }


}
