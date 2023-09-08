package be.intecbrussel.repository.implementations;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.EntityRepository;
import be.intecbrussel.repository.entities.IProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class ProductRepository extends EntityRepository<Product> implements IProductRepository {

    @Override
    public Product readProduct(Storage storage) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        TypedQuery<Product> query = em.createQuery("select p from product_tb p join p.storage s where s.id = ?1", Product.class);

        query.setParameter(1, storage.getId());

        Product dbProduct;

        try {
            // Will throw exception if product is not part of a storage
            dbProduct = query.getSingleResult();
        } catch (NoResultException e) {
            dbProduct = null;
        }

        em.close();

        return dbProduct;
    }
}
