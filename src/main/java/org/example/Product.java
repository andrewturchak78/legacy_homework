package org.example;

public class Product {
    private int id;
    private String title;
    private String price;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public Product(int id, String title, String price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
}
