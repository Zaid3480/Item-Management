package com.itemmanagement.model;

import lombok.Data;

@Data
public class Item {

    private Long id;
    private String name;
    private String description;
    private double price;

    public Item() {}

}
