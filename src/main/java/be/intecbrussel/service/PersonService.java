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
    public void addPerson(Person person) {
        Storage favStorage = person.getFavoriteStorage();

        if (favStorage != null && favStorage.getId() == 0) {
            ss.addStorage(favStorage);
        }

        personRepo.createPerson(person);
    }

    @Override
    public Person getPerson(long id) {
        return personRepo.readPerson(id);
    }

    @Override
    public void updatePerson(Person person) {
        personRepo.updatePerson(person);
    }

    @Override
    public void deletePerson(long id) {
        personRepo.deletePerson(id);
    }
}
