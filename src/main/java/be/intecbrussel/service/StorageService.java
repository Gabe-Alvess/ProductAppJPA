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

    public StorageService () {
        ps = new ProductService(this);
    }

    @Override
    public void addStorage(Storage storage) {
        for (Product product : storage.getStorageContent()) {
            if (product.getId() == 0) {
                ps.addProduct(product);
            } else {
                ps.updateProduct(product);
            }
        }
        sr.createStorage(storage);
    }

    @Override
    public Storage getStorage(long id) {
        return sr.readStorage(id);
    }

    @Override
    public void updateStorage(Storage storage) {
        for (Product product : storage.getStorageContent()) {
            if (product.getId() == 0) {
                ps.addProduct(product);
            } else {
                ps.updateProduct(product);
            }
        }
        sr.updateStorage(storage);
    }

    @Override
    public void deleteStorage(long id) {
        Storage dbStorage = sr.readStorage(id);

        if (dbStorage != null) {
            sr.deleteStorage(id);
        }
    }

    @Override
    public void deleteProductFromStorage(Product product) {
        Storage dbStorage = sr.readStorage(product);

        dbStorage.getStorageContent().remove(product);

        updateStorage(dbStorage);
    }


}