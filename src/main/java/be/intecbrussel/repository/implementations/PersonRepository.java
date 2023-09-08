package be.intecbrussel.repository.implementations;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Person;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.EntityRepository;
import be.intecbrussel.repository.entities.IPersonRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PersonRepository extends EntityRepository<Person> implements IPersonRepository {

    @Override
    public List<Person> readPeople(Storage favStorage) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        TypedQuery<Person> query = em.createQuery("select p from person_tb p join p.favoriteStorage s where s.id = ?1", Person.class);

        query.setParameter(1, favStorage.getId());

        List<Person> dbPeople = query.getResultList();

        em.close();

        return dbPeople;
    }
}
