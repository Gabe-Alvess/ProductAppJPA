package be.intecbrussel.service;

import be.intecbrussel.modal.Person;
import be.intecbrussel.modal.Storage;
import be.intecbrussel.repository.IPersonRepository;
import be.intecbrussel.repository.PersonRepository;

public class PersonService implements IPersonService {
    private IPersonRepository personRepo = new PersonRepository();
    private IStorageService ss;

    protected PersonService(StorageService ss) {
        this.ss = ss;
    }

    public PersonService() {
        this.ss = new StorageService();
    }

    @Override
    public void add(Person person) {
        Storage favStorage = person.getFavoriteStorage();

        if (favStorage != null && favStorage.getId() == 0) {
            ss.add(favStorage);
        }

        personRepo.create(person);
    }

    @Override
    public Person get(Long id) {
        return personRepo.read(Person.class, id);
    }

    @Override
    public void update(Person person) {
        personRepo.update(person);
    }

    @Override
    public void delete(Long id) {
        Person person = get(id);
        person.setFavoriteStorage(null);
        update(person);

        personRepo.delete(Person.class, id);
    }
}
