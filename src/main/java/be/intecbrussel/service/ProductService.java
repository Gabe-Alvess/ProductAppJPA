package be.intecbrussel.service;

import be.intecbrussel.modal.Product;
import be.intecbrussel.modal.Storage;
import be.intecbrussel.repository.IProductRepository;
import be.intecbrussel.repository.ProductRepository;

public class ProductService implements IProductService {
    private IProductRepository pr = new ProductRepository();

    @Override
    public void addProduct(Product product) {
        pr.createProduct(product);
    }

    @Override
    public Product getProduct(long id) {
        return pr.readProduct(id);
    }

    @Override
    public void updateProduct(Product product) {
        pr.updateProduct(product);
    }

    @Override
    public void deleteProduct(long id, Storage storage) {
        Product dbProduct = pr.readProduct(id);

        if (dbProduct != null) {
            pr.deleteProduct(id, storage);
        }
    }

    @Override
    public void deleteProduct(Product product, Storage storage) {
        Product dbProduct = pr.readProduct(product.getId());

        if (dbProduct != null) {
            pr.deleteProduct(product, storage);
        }
    }
}
