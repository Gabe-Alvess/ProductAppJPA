package be.intecbrussel.service;

import be.intecbrussel.modal.Product;
import be.intecbrussel.repository.IProductRepository;
import be.intecbrussel.repository.ProductRepository;

public class ProductService implements IProductService {
    private IProductRepository pr = new ProductRepository();
    private StorageService ss;

    protected ProductService(StorageService ss) {
        this.ss = ss;
    }

    public ProductService() {
        ss = new StorageService(this);
    }

    @Override
    public void add(Product product) {
        pr.create(product);
    }

    @Override
    public Product get(Long id) {
        return pr.read(Product.class, id);
    }

    @Override
    public void update(Product product) {
        Product dbProduct = get(product.getId());

        if (dbProduct != null && dbProduct.getId() == product.getId()) {
            pr.update(product);
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
        ss.deleteProductFromStorage(product);
        pr.delete(Product.class, product.getId());
    }
}
