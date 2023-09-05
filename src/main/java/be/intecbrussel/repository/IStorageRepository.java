package be.intecbrussel.repository;

import be.intecbrussel.modal.Product;
import be.intecbrussel.modal.Storage;

public interface IStorageRepository extends IEntityRepository<Storage> {
    Storage readStorage(Product product);
}
