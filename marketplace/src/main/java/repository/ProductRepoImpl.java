package repository;

import data.DataSource;
import exception.ProductNotFoundException;
import model.Product;

import java.util.List;

public class ProductRepoImpl implements ProductRepo {

    private static Long idGenerator = 0l;

    @Override
    public boolean save(Product product) {
        product.setId(idGenerator);
        ++idGenerator;
        return DataSource.products.add(product);
    }

    @Override
    public boolean delete(Product product) {
        DataSource.purchases.entrySet().stream()
                .filter(x -> x.getValue().contains(product))
                .forEach(x -> DataSource.purchases.get(x.getKey()).remove(product));
        return DataSource.products.remove(product);
    }

    @Override
    public Product findById(Long id) throws ProductNotFoundException {
        return DataSource.products.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public List<Product> findAll() {
        return DataSource.products;
    }
}
