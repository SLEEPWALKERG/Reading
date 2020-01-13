package com.example.adam.reading;

public class Book {
    private String name;
    private String abstrac;
    private Double price;
    private int id;

    public Book(String name, String abstrac, Double price, int id) {
        this.name = name;
        this.abstrac = abstrac;
        this.price = price;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price.toString();
    }

    public String getAbstrac() {
        return abstrac;
    }
}
