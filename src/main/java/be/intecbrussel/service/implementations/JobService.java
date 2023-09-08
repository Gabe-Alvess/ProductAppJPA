package be.intecbrussel.service.implementations;

import be.intecbrussel.model.Job;
import be.intecbrussel.model.Person;
import be.intecbrussel.model.PersonalJob;
import be.intecbrussel.repository.entities.IJobRepository;
import be.intecbrussel.repository.implementations.JobRepository;
import be.intecbrussel.service.entities.IJobService;
import be.intecbrussel.service.entities.IPersonService;

import java.util.List;

public class JobService implements IJobService {
    private IJobRepository jobR = new JobRepository();
    protected IPersonService personS = Service.getPersonService();

    @Override
    public void add(Job job) {
        if (job.getId() != 0) {
            update(job);
        }

//        for (Person employee : job.getEmployees()) {
//            if (employee.getId() == 0) {
//                personS.add(employee);
//            } else {
//                personS.update(employee);
//            }
//        }

        jobR.create(job);
        jobR.update(job);
    }

    @Override
    public Job get(Long id) {
        return jobR.read(Job.class, id);
    }

    @Override
    public void update(Job job) {
//        for (PersonalJob employee : job.getEmployees()) {
//            if (employee.getId() == 0) {
                // TODO DO THIS
                // personS.add(employee);
//            }
//        }

        jobR.update(job);
    }

    @Override
    public void delete(Long id) {
        jobR.delete(Job.class, id);
    }

    @Override
    public void deletePersonFromJob(Person person) {
        List<Job> jobs = jobR.readJobs(person);

        for (Job job : jobs) {
            job.getEmployees().remove(person);
            update(job);
        }
    }
}