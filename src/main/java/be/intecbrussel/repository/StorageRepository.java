package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.modal.Product;
import be.intecbrussel.modal.Storage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class StorageRepository extends EntityRepository<Storage> implements IStorageRepository {

    @Override
    public void create(Storage storage) {
        if (storage.getId() == 0) {
            super.create(storage);
        }
    }

    @Override
    public Storage readStorage(Product product) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        TypedQuery<Storage> query = em.createQuery("select s from tb_storage s join s.storageContent p where p.id = ?1", Storage.class);

        query.setParameter(1, product.getId());

        Storage dbStorage;

        try {
            // Will throw exception if product is not part of a storage
            dbStorage = query.getSingleResult();
        } catch (NoResultException e) {
            dbStorage = null;
        }

        em.close();

        return dbStorage;
    }

    @Override
    public void update(Storage storage) {
        if (storage.getId() != 0) {
            super.update(storage);
        }
    }
}
