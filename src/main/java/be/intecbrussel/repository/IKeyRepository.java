package be.intecbrussel.repository;

import be.intecbrussel.modal.Key;

public interface IKeyRepository {
    void createKey(Key key);

    Key readKey(long id);

    void updateKey(Key key);

    void deleteKey(long id);
}
