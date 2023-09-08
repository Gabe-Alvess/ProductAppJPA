package be.intecbrussel.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "storage_tb")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "storage", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
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
        if (product.getStorage() != this) {
            product.setStorage(this);
        }
    }

    public void add(Product... products) {
        for (Product product : products) {
            add(product);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getStorageContent() {
        return storageContent;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "name='" + name + '\'' +
                ", storageContent=" + storageContent +
                '}';
    }
}
