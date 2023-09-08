package be.intecbrussel;

import be.intecbrussel.model.*;
import be.intecbrussel.service.entities.*;
import be.intecbrussel.service.implementations.*;

public class ProductApp {
    public static void main(String[] args) {

        // Product Tests

        IProductService productS = Service.getProductService();

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

        productS.add(p1);
        productS.add(p2);
        productS.add(p3);
        productS.add(p4);

        productS.add(a);
        productS.add(b);
        productS.add(c);
        productS.add(d);

        productS.add(red);
        productS.add(green);
        productS.add(blue);

        // Read

        System.out.println(productS.get(5L));

        // Update

        p2.setName("Tomato");
        productS.update(p2);

        // Delete

        productS.delete(4L);


        // Storage Tests

        IStorageService storageS = Service.getStorageService();

        Storage s1 = new Storage("Fruits And Trains");
        s1.add(p1, p2, p3);

        // Problem
//        s1.add(p1, p2, p3, p4);

        Storage s2 = new Storage("ABC");
        s2.add(a, b, c, d);

        Storage s3 = new Storage("RGB");
        s3.add(red, green, blue);

        Storage s4 = new Storage("Random Product");
        s4.add(new Product("Bread", 2.0, .4));

        // Create
        storageS.add(s1);
        storageS.add(s2);
        storageS.add(s3);
        storageS.add(s4);

        // Read
        System.out.println(storageS.get(2L));

        // Update Storage
        s1.setName("Fruits and no Trains");
        storageS.update(s1);

        // Update product in the storage
        s2.getStorageContent().get(0).setName("A");
        storageS.update(s2);

        // Delete
        storageS.delete(4L);

        // Person Tests

        IPersonService personS = Service.getPersonService();
        Person jean = new Person("Jean");
        jean.setFavoriteStorage(s1);
        jean.setName("Jean Jean");

        Person bob = new Person("Bob");
        bob.setFavoriteStorage(s1);

        Person tom = new Person("Tom");
        tom.setFavoriteStorage(s2);

        Person rudy = new Person("Rudy");
        rudy.setFavoriteStorage(s2);

        // Create

        personS.add(jean);
        personS.add(bob);
        personS.add(tom);
        personS.add(rudy);

        // Read

        System.out.println(personS.get(1L));

        // Update

        personS.update(jean);
        personS.update(bob);
        personS.update(tom);
        personS.update(rudy);

        // Delete

        personS.delete(4L);


        // Key Tests

        IKeyService keyS = Service.getKeyService();
        Key key1 = new Key();
        key1.setStorage(s1);

        Key key2 = new Key();
        key2.setStorage(s2);

        Key key3 = new Key();
        key3.setStorage(s3);

        // Create

        keyS.add(key1);
        keyS.add(key2);
        keyS.add(key3);

        // Read

        System.out.println(keyS.get(1L));

        // Update

        keyS.update(key1);
        keyS.update(key2);
        keyS.update(key3);

        // Delete

        keyS.delete(3L);


        // Job Tests

        IJobService jobS = Service.getJobService();
        Job job1 = new Job("Java Developer", "Develop in java");
        job1.getEmployees().add(jean);
        Job job2 = new Job("Java Developer", "Develop in java");
        job2.getEmployees().add(bob);
        Job job3 = new Job("C# Developer", "Develop in C#");
        job3.getEmployees().add(tom);

        // Create

        jobS.add(job1);
        jobS.add(job2);
        jobS.add(job3);

        // Read

        System.out.println(jobS.get(1L));

        // Update

        job2.setJobTitle(".NET Developer");
        job2.setJobDescription("Develop in .NET");
        jobS.update(job2);

        // Delete

        jobS.delete(3L);

    }
}
