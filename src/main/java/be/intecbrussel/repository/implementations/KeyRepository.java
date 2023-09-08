package be.intecbrussel.repository.implementations;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Key;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.EntityRepository;
import be.intecbrussel.repository.entities.IKeyRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class KeyRepository extends EntityRepository<Key> implements IKeyRepository {

    @Override
    public Key readKey(Storage storage) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        TypedQuery<Key> query = em.createQuery("select k from key_tb k join k.storage s where s.id = ?1", Key.class);

        query.setParameter(1, storage.getId());

        Key dbKey;

        try {
            // Will throw exception if product is not part of a storage
            dbKey = query.getSingleResult();
        } catch (NoResultException e) {
            dbKey = null;
        }

        em.close();

        return dbKey;
    }
}
