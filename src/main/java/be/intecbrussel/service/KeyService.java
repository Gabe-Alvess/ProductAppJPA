package be.intecbrussel.service;

import be.intecbrussel.modal.Key;
import be.intecbrussel.modal.Storage;
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
    public void add(Key key) {
        Storage storage = key.getStorage();

        if (storage != null && storage.getId() == 0) {
            ss.add(storage);
        }

        kr.create(key);
    }

    @Override
    public Key get(Long id) {
        return kr.read(Key.class, id);
    }

    @Override
    public void update(Key key) {
        kr.update(key);
    }

    @Override
    public void delete(Long id) {
        Key key = get(id);
        key.setStorage(null);
        update(key);

        kr.delete(Key.class, id);
    }
}
