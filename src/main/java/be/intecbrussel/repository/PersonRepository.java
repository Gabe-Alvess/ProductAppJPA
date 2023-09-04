package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.modal.Person;
import jakarta.persistence.EntityManager;

public class PersonRepository implements IPersonRepository {
    @Override
    public void createPerson(Person person) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();

        em.persist(person);

        em.getTransaction().commit();

        em.close();
    }

    @Override
    public Person readPerson(long id) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        Person dbPerson = em.find(Person.class, id);

        em.close();

        return dbPerson;
    }

    @Override
    public void updatePerson(Person person) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();

        Person mergedPerson = em.merge(person);

        if (mergedPerson.getId() != person.getId()) {
            em.getTransaction().rollback();
        } else {
            em.getTransaction().commit();
        }

        em.close();
    }

    @Override
    public void deletePerson(long id) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();

        em.remove(em.find(Person.class, id));

        em.getTransaction().commit();

        em.close();
    }
}
