package be.intecbrussel.service.implementations;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.entities.IProductRepository;
import be.intecbrussel.repository.implementations.ProductRepository;
import be.intecbrussel.service.entities.IProductService;

public class ProductService implements IProductService {
    private IProductRepository productR = new ProductRepository();
    protected StorageService storageS = Service.getStorageService();

    @Override
    public void add(Product product) {
        if (product.getId() != 0) {
            update(product);
        }
        productR.create(product);
    }

    @Override
    public Product get(Long id) {
        return productR.read(Product.class, id);
    }

    @Override
    public void update(Product product) {
        Product dbProduct = get(product.getId());

        if (dbProduct != null && dbProduct.getId() == product.getId()) {
            productR.update(product);
        }
    }

    @Override
    public void delete(Long id) {
        Product dbProduct = get(id);

        if (dbProduct != null) {
            deleteProduct(dbProduct);
        }
    }

    @Override
    public void deleteProduct(Product product) {
        if (product.getId() == 0) {
            return;
        }

        storageS.deleteProductFromStorage(product);

        productR.delete(Product.class, product.getId());
    }

    @Override
    public void deleteStorageFromProduct(Storage storage) {
        Product dbProduct = productR.readProduct(storage);

        if (dbProduct != null) {
            Storage dbProductStorage = dbProduct.getStorage();
            dbProductStorage.setId(0);
            update(dbProduct);
        }
    }


}
