package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.modal.Product;
import be.intecbrussel.modal.Storage;
import jakarta.persistence.EntityManager;

public class ProductRepository implements IProductRepository {

    @Override
    public void createProduct(Product product) {
        //Create
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();

        if (product.getId() == 0) {
            em.persist(product);
        }

        em.getTransaction().commit();

        em.close();
    }

    @Override
    public Product readProduct(long id) {
        // Read
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        Product dbProduct = em.find(Product.class, id);

        em.close();

        return dbProduct;
    }

    @Override
    public void updateProduct(Product product) {
        // Update
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();

        Product mergedProduct = em.merge(product);

        if (!mergedProduct.equals(product)) {
            em.getTransaction().rollback();
        } else {
            em.getTransaction().commit();
        }

        em.close();

    }

    @Override
    public void deleteProduct(Product product) {
        // Delete
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();

        em.remove(em.find(Product.class, product.getId()));

        em.getTransaction().commit();

        em.close();
    }
}
