package com.example.shops.entity;

import lombok.Data;

@Data
public class Shop {
    private String id;
    private String city;
    private String street;
    private String name;
    private String employees;
    private Boolean website;
}