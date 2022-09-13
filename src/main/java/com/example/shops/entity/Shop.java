package com.example.shops.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String street;
    private String name;
    private String employees;

    private Boolean website;

    public Shop(String city, String street, String name, String employees, Boolean website) {
        this.city = city;
        this.street = street;
        this.name = name;
        this.employees = employees;
        this.website = website;
    }

}
