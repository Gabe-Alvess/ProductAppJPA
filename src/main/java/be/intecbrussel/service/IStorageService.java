package be.intecbrussel.service;

import be.intecbrussel.modal.Product;
import be.intecbrussel.modal.Storage;

public interface IStorageService extends IEntityService<Storage, Long> {
    void deleteProductFromStorage(Product product);
}
