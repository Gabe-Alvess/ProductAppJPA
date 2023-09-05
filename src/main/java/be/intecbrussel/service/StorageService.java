package be.intecbrussel.service;

import be.intecbrussel.modal.Product;
import be.intecbrussel.modal.Storage;
import be.intecbrussel.repository.IStorageRepository;
import be.intecbrussel.repository.StorageRepository;

public class StorageService implements IStorageService {
    private IStorageRepository sr = new StorageRepository();
    private IProductService ps;

    protected StorageService(ProductService ps) {
        this.ps = ps;
    }

    public StorageService() {
        ps = new ProductService(this);
    }

    @Override
    public void add(Storage storage) {
        for (Product product : storage.getStorageContent()) {
            if (product.getId() == 0) {
                ps.add(product);
            } else {
                ps.update(product);
            }
        }
        sr.create(storage);
    }

    @Override
    public Storage get(Long id) {
        return sr.read(Storage.class, id);
    }

    @Override
    public void update(Storage storage) {
        for (Product product : storage.getStorageContent()) {
            if (product.getId() == 0) {
                ps.add(product);
            } else {
                ps.update(product);
            }
        }

        sr.update(storage);
    }

    @Override
    public void delete(Long id) {
        Storage dbStorage = sr.read(Storage.class, id);

        if (dbStorage != null) {
            sr.delete(Storage.class, id);
        }

    }

    @Override
    public void deleteProductFromStorage(Product product) {
        Storage dbStorage = sr.readStorage(product);

        if (dbStorage != null) {
            dbStorage.getStorageContent().remove(product);
            update(dbStorage);
        }

    }


}