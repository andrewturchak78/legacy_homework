package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(3, "Война и мир","600","Толстой");
    Book book2 = new Book(6, "Преступление и наказние","700","Достоевский");
    Book book3 = new Book(5, "Бедная Лиза","400","Карамзин");
    Book book4 = new Book(7, "Муму","800","Тургенев");
    Book book5 = new Book(8, "Портрет Дориана Грея","750","Уайльд");

    Smartphone phone1 = new Smartphone(10, "Iphone X", "5500", "Apple");
    Smartphone phone2 = new Smartphone(11, "Samsung Galaxy", "1500", "Samsung");
    Smartphone phone3 = new Smartphone(12, "Realme XT", "1000", "Realme");
    Smartphone phone4 = new Smartphone(13, "Huawei", "3500", "Huawei");
    Smartphone phone5 = new Smartphone(14, "Nokia", "500", "Nokia");



    @Test
    public void shouldAddProduct1() {
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(phone4);
        manager.add(phone5);

        Product[] expected = {phone1,phone2,phone3,phone4,phone5};
        Product[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldAddProduct2() {
        manager.add(phone1);

        Product[] expected = new Product[] {phone1};
        Product[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldAddProducts3() {
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(phone4);
        manager.add(phone5);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        Product[] expected = new Product[] {phone1,phone2,phone3,phone4,phone5,book1,book2,book3,book4,book5};
        Product[] actual = manager.findAll();
        Assertions.assertArrayEquals(actual,expected);
    }
    @Test
    public void shouldAddProducts4() {
        manager.add(book4);
        manager.add(book2);
        manager.add(book1);
        Product[] expected = new Product[] {book4,book2,book1};
        Product[] actual = manager.findAll();
        Assertions.assertArrayEquals(actual,expected);
    }
    @Test
    public void shouldRemoveById() {
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(phone4);
        manager.add(phone5);
        repo.removeById(12);
        Product[] expected = {phone1,phone2,phone4,phone5};
        Product[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldSearch() {
        manager.add(phone5);
        String name = "Nokia";
        Product[] expected = {phone5};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(actual,expected);
    }
    @Test
    public void shouldSearch2() {
        manager.add(book3);
        String name = "Жмурки";
        Product[] expected = {};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(actual,expected);
    }
    @Test
    public void shouldSearch3() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        String name = "Война и мир";
        Product[] expected = {book1};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(actual,expected);
    }
}
