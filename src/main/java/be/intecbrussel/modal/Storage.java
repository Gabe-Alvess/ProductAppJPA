package be.intecbrussel.modal;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Product> storageContent;

    protected Storage() {
        this.storageContent = new ArrayList<>();
    }

    public Storage(String name) {
        this.name = name;
        this.storageContent = new ArrayList<>();
    }

    public void add(Product product) {
        storageContent.add(product);
    }

    public void add(Product... products) {
        for (Product product : products) {
            add(product);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public List<Product> getStorageContent() {
        return storageContent;
    }

    public void setStorageContent(List<Product> storageContent) {
        this.storageContent = storageContent;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "name='" + name + '\'' +
                ", storageContent=" + storageContent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Storage storage)) return false;
        return id == storage.id && Objects.equals(name, storage.name) && Objects.equals(storageContent, storage.storageContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, storageContent);
    }
}
