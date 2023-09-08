package be.intecbrussel.service.implementations;

import be.intecbrussel.model.Key;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.entities.IKeyRepository;
import be.intecbrussel.repository.implementations.KeyRepository;
import be.intecbrussel.service.entities.IKeyService;

public class KeyService implements IKeyService {
    private IKeyRepository keyR = new KeyRepository();
    protected StorageService storageS = Service.getStorageService();

    @Override
    public void add(Key key) {
        if (key.getId() != 0) {
            update(key);
        }

        Storage storage = key.getStorage();

        if (storage != null && storage.getId() == 0) {
            storageS.add(storage);
        } else if (storage != null) {
            storageS.update(storage);
        }

        keyR.create(key);
    }

    @Override
    public Key get(Long id) {
        return keyR.read(Key.class, id);
    }

    @Override
    public void update(Key key) {
        Storage storage = key.getStorage();

        if (storage != null && storage.getId() == 0) {
            storageS.add(storage);
        }

        keyR.update(key);
    }

    @Override
    public void delete(Long id) {
        keyR.delete(Key.class, id);
    }

    @Override
    public void deleteKeyByStorage(Storage storage) {
        Key key = keyR.readKey(storage);

        if (key != null) {
            delete(key.getId());
        }
    }
}
