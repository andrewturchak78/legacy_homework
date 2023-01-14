package org.example;

public class ProductManager {

    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.addProduct(product);
    }
    public Product [] findAll() {
        return repo.findAll();
    }

    public Product[] searchBy(String search) {
        Product[] result = new Product[0];
        for (Product product : repo.findAll()) {
            if (matches(product, search)) {
                Product[] tmp = new Product[result.length + 1];
                tmp[result.length] = product;
                result = tmp;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getTitle().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
