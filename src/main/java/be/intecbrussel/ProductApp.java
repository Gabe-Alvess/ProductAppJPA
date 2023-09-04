package be.intecbrussel;

import be.intecbrussel.modal.Key;
import be.intecbrussel.modal.Person;
import be.intecbrussel.modal.Product;
import be.intecbrussel.modal.Storage;
import be.intecbrussel.service.*;

public class ProductApp {
    public static void main(String[] args) {
        // Product Table

        Product p1 = new Product("Apple", 1.50, 2.75);
        Product p2 = new Product("Potato is now a fruit", 0.95, 0.55);
        Product p3 = new Product("Banana", 3.60, 4.50);
        Product p4 = new Product("Train", 50, 60);

        Storage s1 = new Storage("Fruits And Trains");
        s1.add(p1, p2, p3, p4);

        Product a = new Product("a", 1.0, 0.1);
        Product b = new Product("b", 1.0, 0.1);
        Product c = new Product("c", 1.0, 0.1);
        Product d = new Product("d", 1.0, 0.1);

        Storage s2 = new Storage("ABC");
        s2.add(a, b, c, d);

        Product red = new Product("red", 1.0, 0.1);
        Product green = new Product("green", 1.0, 0.1);
        Product blue = new Product("blue", 1.0, 0.1);

        Storage s3 = new Storage("RGB");
        s3.add(red, green, blue);

        IStorageService ss = new StorageService();

        // Storage Tests

        // Create
        ss.addStorage(s1);
        ss.addStorage(s2);
        ss.addStorage(s3);

        ss.addStorage(s1);

        // Read
        System.out.println(ss.getStorage(2));

        // Update Storage
        ss.getStorage(1);
        System.out.println(s1);
        s1.setName("Fruits and no Trains");
        ss.updateStorage(s1);

        // Update product in the storage
        System.out.println(s1);
        s2.getStorageContent().get(0).setName("A");
        ss.updateStorage(s2);

        // Delete
        ss.deleteStorage(3);

        ss.deleteStorage(3);

        // Product Tests

        IProductService ps = new ProductService();

        // Create
        ps.addProduct(p2);
        ps.addProduct(new Product("Black", 1.0, 0.1));

        // Read
        System.out.println(ps.getProduct(5));

        // Update
        p2.setName("Tomato");
        ps.updateProduct(p2);

        // Delete
        ps.deleteProduct(4);
        ps.deleteProduct(d);

        // Person Tests

        IPersonService personService = new PersonService();
        Person jean = new Person("Jean");
        Person bob = new Person("Bob");

        // Create

        personService.addPerson(jean);
        personService.addPerson(bob);

        // Read

        System.out.println(personService.getPerson(1));

        // Update

        jean.setFavoriteStorage(s1);
        jean.setName("Jean Jean");
        personService.updatePerson(jean);

        // Delete

        personService.deletePerson(2);

        // Key Tests

        IKeyService ks = new KeyService();
        Key key1 = new Key();
        Key key2 = new Key();

        // Create

        ks.addKey(key1);
        ks.addKey(key2);

        // Read

        System.out.println(ks.getKey(1));

        // Update

        key1.setStorage(s1);
        key2.setStorage(s2);
        ks.updateKey(key1);
        ks.updateKey(key2);

        // Delete

        ks.deleteKey(2);

    }
}
