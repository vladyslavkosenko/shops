package com.example.shops;

public class Shop {
    String id;
    String city;
    String street;
    String name;
    String employees;
    Boolean website;

    public Shop(String id, String city, String street, String name, String employees, Boolean website) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.name = name;
        this.employees = employees;
        this.website = website;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }

    public Boolean getWebsite() {
        return website;
    }

    public void setWebsite(Boolean website) {
        this.website = website;
    }
}