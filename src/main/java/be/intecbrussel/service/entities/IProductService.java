package be.intecbrussel.service.entities;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import be.intecbrussel.service.IEntityService;

public interface IProductService extends IEntityService<Product, Long> {
    void deleteProduct(Product product);
    void deleteStorageFromProduct(Storage storage);
}
