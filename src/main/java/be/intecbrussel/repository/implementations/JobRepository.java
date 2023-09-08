package be.intecbrussel.repository.implementations;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Job;
import be.intecbrussel.model.Person;
import be.intecbrussel.repository.EntityRepository;
import be.intecbrussel.repository.entities.IJobRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class JobRepository extends EntityRepository<Job> implements IJobRepository {

    @Override
    public List<Job> readJobs(Person person) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        TypedQuery<Job> query = em.createQuery("select j from job_tb j join j.employees e where e.id = ?1", Job.class);

        query.setParameter(1, person.getId());

        List<Job> dbJobs = query.getResultList();

        em.close();

        return dbJobs;

    }
}