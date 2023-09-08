package be.intecbrussel.service.entities;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import be.intecbrussel.service.IEntityService;

public interface IStorageService extends IEntityService<Storage, Long> {
    void deleteStorage(Storage storage);
    void deleteProductFromStorage(Product product);
}
