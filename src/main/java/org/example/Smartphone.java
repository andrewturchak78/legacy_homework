package org.example;

public class Smartphone extends Product {
    protected String manufacturer;


    public Smartphone(int id, String title, String price, String manufacturer){
        super(id,title,price);
        this.manufacturer = manufacturer;
    }
}
