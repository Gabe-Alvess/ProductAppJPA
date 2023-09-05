package be.intecbrussel.repository;

import be.intecbrussel.modal.Product;

public class ProductRepository extends EntityRepository<Product> implements IProductRepository {
    @Override
    public void create(Product product) {
        if (product.getId() == 0) {
            super.create(product);
        }
    }
}
