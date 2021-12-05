package com.example.cscb07_project;

public class Product {
    public String name;
    public double price;
    public int inventory_quantity;
    public String introduction;

    public Product(String name, double price, int inventory_quantity) {
        this.name = name;
        this.price = price;
        this.inventory_quantity = inventory_quantity;
    }
}
