package be.intecbrussel.service;

import be.intecbrussel.modal.Key;
import be.intecbrussel.repository.IKeyRepository;
import be.intecbrussel.repository.KeyRepository;

public class KeyService implements IKeyService {
    private IKeyRepository kr = new KeyRepository();
    private StorageService ss;

    protected KeyService(StorageService ss) {
        this.ss = ss;
    }

    public KeyService() {
        this.ss = new StorageService();
    }

    @Override
    public void addKey(Key key) {
        if (key.getStorage() != null && key.getStorage().getId() == 0) {
            ss.addStorage(key.getStorage());
        }

        kr.createKey(key);
    }

    @Override
    public Key getKey(long id) {
        return kr.readKey(id);
    }

    @Override
    public void updateKey(Key key) {
        kr.updateKey(key);
    }

    @Override
    public void deleteKey(long id) {
        kr.deleteKey(id);
    }
}
