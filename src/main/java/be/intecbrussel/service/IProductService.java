package be.intecbrussel.service;

import be.intecbrussel.modal.Product;
import be.intecbrussel.modal.Storage;

public interface IProductService {
    // CREATE
    void addProduct(Product product);

    // READ
    Product getProduct(long id);

    // UPDATE
    void updateProduct(Product product);

    // DELETE
    void deleteProduct(long id, Storage storage);

    void deleteProduct(Product product, Storage storage);
}
