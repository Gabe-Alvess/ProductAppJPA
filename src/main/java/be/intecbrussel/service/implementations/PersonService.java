package be.intecbrussel.service.implementations;

import be.intecbrussel.model.Person;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.entities.IPersonRepository;
import be.intecbrussel.repository.implementations.PersonRepository;
import be.intecbrussel.service.entities.IJobService;
import be.intecbrussel.service.entities.IPersonService;
import be.intecbrussel.service.entities.IStorageService;

import java.util.List;

public class PersonService implements IPersonService {
    private IPersonRepository personR = new PersonRepository();
    protected IStorageService storageS = Service.getStorageService();
    protected IJobService jobS = Service.getJobService();

    @Override
    public void add(Person person) {
        if (person.getId() != 0) {
            update(person);
        }

        Storage favStorage = person.getFavoriteStorage();

        if (favStorage != null && favStorage.getId() == 0) {
            storageS.add(favStorage);
        } else if (favStorage != null) {
            storageS.update(favStorage);
        }

        personR.create(person);
    }

    @Override
    public Person get(Long id) {
        return personR.read(Person.class, id);
    }

    @Override
    public void update(Person person) {
        Storage favStorage = person.getFavoriteStorage();

        if (favStorage != null && favStorage.getId() == 0) {
            storageS.add(favStorage);
        }

        personR.update(person);
    }

    @Override
    public void delete(Long id) {
        jobS.deletePersonFromJob(get(id));
        personR.delete(Person.class, id);
    }

    @Override
    public void deleteStorageFromPerson(Storage storage) {
        List<Person> dbPeople = personR.readPeople(storage);

        for (Person dbPerson : dbPeople) {
            dbPerson.setFavoriteStorage(null);
            update(dbPerson);
        }

    }
}
