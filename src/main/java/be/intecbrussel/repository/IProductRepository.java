package be.intecbrussel.repository;

import be.intecbrussel.modal.Product;
import be.intecbrussel.modal.Storage;

public interface IProductRepository {
    // CREATE
    void createProduct(Product product);

    // READ
    Product readProduct(long id);

    // UPDATE
    void updateProduct(Product product);

    // DELETE
    void deleteProduct(Product product);

}
