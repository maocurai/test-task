package repository;

import exception.ProductNotFoundException;
import model.Product;

import java.util.List;

public interface ProductRepo {

    boolean save(Product product);
    boolean delete(Product product);
    Product findById(Long id) throws ProductNotFoundException;

    List<Product> findAll();

}
