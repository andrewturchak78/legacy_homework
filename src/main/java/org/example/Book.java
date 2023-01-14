package org.example;

public class Book extends Product{

    protected String author;

    public Book(int id, String title, String price, String author){
        super(id,title,price);
        this.author = author;
    }
}
