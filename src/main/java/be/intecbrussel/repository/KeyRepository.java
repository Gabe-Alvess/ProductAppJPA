package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.modal.Key;
import jakarta.persistence.EntityManager;

public class KeyRepository implements IKeyRepository {
    @Override
    public void createKey(Key key) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();

        em.persist(key);

        em.getTransaction().commit();

        em.close();
    }

    @Override
    public Key readKey(long id) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        Key dbKey = em.find(Key.class, id);

        em.close();

        return dbKey;
    }

    @Override
    public void updateKey(Key key) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();

        Key mergedKey = em.merge(key);

        if (mergedKey.getId() != key.getId()) {
            em.getTransaction().rollback();
        } else {
            em.getTransaction().commit();
        }

        em.close();
    }

    @Override
    public void deleteKey(long id) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();

        em.remove(em.find(Key.class, id));

        em.getTransaction().commit();

        em.close();
    }
}
