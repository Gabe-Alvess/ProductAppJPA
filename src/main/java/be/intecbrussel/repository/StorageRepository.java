package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.modal.Product;
import be.intecbrussel.modal.Storage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class StorageRepository implements IStorageRepository {

    @Override
    public void createStorage(Storage storage) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();

        if (storage.getId() == 0) {
            em.persist(storage);
        }

        em.getTransaction().commit();

        em.close();
    }

    @Override
    public Storage readStorage(long id) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        Storage dbStorage = em.find(Storage.class, id);

        em.close();

        return dbStorage;
    }

    @Override
    public Storage readStorage(Product product) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        TypedQuery<Storage> query = em.createQuery("select s from tb_storage s join s.storageContent p where p.id = ?1", Storage.class);

        query.setParameter(1, product.getId());

        // Will throw exception if product is not part of a storage
        Storage dbStorage = query.getSingleResult();

        em.close();

        return dbStorage;
    }


    @Override
    public void updateStorage(Storage storage) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();
        Storage mergedStorage = em.merge(storage);

        if (mergedStorage.getId() != storage.getId()) {
            em.getTransaction().rollback();
        } else {
            em.getTransaction().commit();
        }

        em.close();
    }

    @Override
    public void deleteStorage(long id) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();

        em.remove(em.find(Storage.class, id));

        em.getTransaction().commit();

        em.close();
    }
}
