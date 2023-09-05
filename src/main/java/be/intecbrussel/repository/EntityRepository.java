package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import jakarta.persistence.EntityManager;

public class EntityRepository<E> implements IEntityRepository<E> {

    @Override
    public void create(E entity) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public E read(Class<E> returnCLass, Object id) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        E dbEntity = em.find(returnCLass, id);
        em.close();

        return dbEntity;
    }

    @Override
    public void update(E entity) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Class<E> entityClass, Object id) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(entityClass, id));
        em.getTransaction().commit();
        em.close();
    }
}
