package be.intecbrussel.service.implementations;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.entities.IStorageRepository;
import be.intecbrussel.repository.implementations.StorageRepository;
import be.intecbrussel.service.entities.IKeyService;
import be.intecbrussel.service.entities.IPersonService;
import be.intecbrussel.service.entities.IProductService;
import be.intecbrussel.service.entities.IStorageService;

public class StorageService implements IStorageService {
    private IStorageRepository storageR = new StorageRepository();
    protected IProductService productS = Service.getProductService();
    protected IPersonService personS = Service.getPersonService();
    protected IKeyService keyS = Service.getKeyService();

    @Override
    public void add(Storage storage) {
        if (storage.getId() != 0) {
            update(storage);
        }

        storageR.create(storage);

        for (Product product : storage.getStorageContent()) {
            if (product.getId() == 0) {
                productS.add(product);
            } else {
                productS.update(product);
            }
        }
    }

    @Override
    public Storage get(Long id) {
        return storageR.read(Storage.class, id);
    }

    @Override
    public void update(Storage storage) {
        for (Product product : storage.getStorageContent()) {
            if (product.getId() == 0) {
                productS.add(product);
            }
        }

        storageR.update(storage);
    }

    @Override
    public void delete(Long id) {
        Storage dbStorage = get(id);

        if (dbStorage != null) {
            deleteStorage(dbStorage);
        }


    }

    @Override
    public void deleteStorage(Storage storage) {
        if (storage.getId() == 0) {
            return;
        }

        keyS.deleteKeyByStorage(storage);

        personS.deleteStorageFromPerson(storage);

        productS.deleteStorageFromProduct(storage);

        storageR.delete(Storage.class, storage.getId());
    }

    @Override
    public void deleteProductFromStorage(Product product) {
        Storage dbStorage = storageR.readStorage(product);

        if (dbStorage != null) {
            dbStorage.getStorageContent().remove(product);
            update(dbStorage);
        }

    }


}