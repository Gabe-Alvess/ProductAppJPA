package be.intecbrussel.repository;

import be.intecbrussel.modal.Storage;

public interface IStorageRepository {
    // CREATE
    void createStorage(Storage storage);

    // READ
    Storage readStorage(long id);

    // UPDATE
    void updateStorage(Storage storage);

    // DELETE
    void deleteStorage(long id);
}
