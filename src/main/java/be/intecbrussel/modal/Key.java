package be.intecbrussel.modal;

import jakarta.persistence.*;

@Entity(name = "key_tb")
public class Key {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Storage storage;

    public long getId() {
        return id;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Key{" +
                "id=" + id +
                ", storage=" + storage +
                '}';
    }
}
