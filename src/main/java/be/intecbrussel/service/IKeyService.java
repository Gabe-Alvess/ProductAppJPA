package be.intecbrussel.service;

import be.intecbrussel.modal.Key;

public interface IKeyService {
    void addKey(Key key);

    Key getKey(long id);

    void updateKey(Key key);

    void deleteKey(long id);
}
