package be.intecbrussel;

import be.intecbrussel.modal.Key;
import be.intecbrussel.modal.Person;
import be.intecbrussel.modal.Product;
import be.intecbrussel.modal.Storage;
import be.intecbrussel.service.*;

public class ProductApp {
    public static void main(String[] args) {

        // Product Tests

        IProductService ps = new ProductService();

        Product p1 = new Product("Apple", 1.50, 2.75);
        Product p2 = new Product("Potato is now a fruit", 0.95, 0.55);
        Product p3 = new Product("Banana", 3.60, 4.50);
        Product p4 = new Product("Train", 50, 60);

        Product a = new Product("a", 1.0, 0.1);
        Product b = new Product("b", 1.0, 0.1);
        Product c = new Product("c", 1.0, 0.1);
        Product d = new Product("d", 1.0, 0.1);

        Product red = new Product("red", 1.0, 0.1);
        Product green = new Product("green", 1.0, 0.1);
        Product blue = new Product("blue", 1.0, 0.1);

        // Create

        ps.add(p1);
        ps.add(p2);
        ps.add(p3);
        ps.add(p4);

        ps.add(a);
        ps.add(b);
        ps.add(c);
        ps.add(d);

        ps.add(red);
        ps.add(green);
        ps.add(blue);

        // Read

        System.out.println(ps.get(5L));

        // Update

        p2.setName("Tomato");
        ps.update(p2);

        // Delete

        ps.delete(4L);


        // Storage Tests

        IStorageService ss = new StorageService();

        Storage s1 = new Storage("Fruits And Trains");
        // Problem
//        s1.add(p1, p2, p3, p4);
        s1.add(p1, p2, p3);

        Storage s2 = new Storage("ABC");
        s2.add(a, b, c, d);

        Storage s3 = new Storage("RGB");
        s3.add(red, green, blue);

        Storage s4 = new Storage("Random Product");
        s4.add(new Product("Bread", 2.0, .4));

        // Create
        ss.add(s1);
        ss.add(s2);
        ss.add(s3);
        ss.add(s4);

        // Read
        System.out.println(ss.get(2L));

        // Update Storage
        s1.setName("Fruits and no Trains");
        ss.update(s1);

        // Update product in the storage
        s2.getStorageContent().get(0).setName("A");
        ss.update(s2);

        // Delete
        ss.delete(4L);

        // Person Tests

        IPersonService personService = new PersonService();
        Person jean = new Person("Jean");
        Person bob = new Person("Bob");
        Person tom = new Person("Tom");

        // Create

        personService.add(jean);
        personService.add(bob);
        personService.add(tom);

        // Read

        System.out.println(personService.get(1L));

        // Update

        jean.setFavoriteStorage(s1);
        jean.setName("Jean Jean");
        personService.update(jean);

        bob.setFavoriteStorage(s1);
        personService.update(bob);

        tom.setFavoriteStorage(s2);
        personService.update(tom);

        // Delete

        personService.delete(3L);

        // Key Tests

        IKeyService ks = new KeyService();
        Key key1 = new Key();
        Key key2 = new Key();
        Key key3 = new Key();

        // Create

        ks.add(key1);
        ks.add(key2);
        ks.add(key3);

        // Read

        System.out.println(ks.get(1L));

        // Update

        key1.setStorage(s1);
        key2.setStorage(s2);
        key3.setStorage(s3);

        ks.update(key1);
        ks.update(key2);
        ks.update(key3);

        // Delete

        ks.delete(3L);
    }
}
