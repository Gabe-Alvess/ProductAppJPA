package be.intecbrussel.service;

import be.intecbrussel.modal.Product;
import be.intecbrussel.modal.Storage;
import be.intecbrussel.repository.IStorageRepository;
import be.intecbrussel.repository.StorageRepository;

import java.util.List;

public class StorageService implements IStorageService {
    private IStorageRepository sr = new StorageRepository();
    private IProductService ps = new ProductService();

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
}

// Nodig zonder orphanRemoval = true!

//        Storage storage = sr.readStorage(id);

//        for (Product product : storage.getStorageContent()) {
//            if (product.getId() != 0) {
//                ps.deleteProduct(product);
//            }
//        }