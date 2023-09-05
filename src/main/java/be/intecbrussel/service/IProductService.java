package be.intecbrussel.service;

import be.intecbrussel.modal.Product;

public interface IProductService extends IEntityService<Product, Long> {
    void deleteProduct(Product product);
}
