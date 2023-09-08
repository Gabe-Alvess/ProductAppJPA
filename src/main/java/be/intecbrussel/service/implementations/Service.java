package be.intecbrussel.service.implementations;

public class Service {
    private static JobService jobService = new JobService();
    private static KeyService keyService = new KeyService();
    private static PersonService personService = new PersonService();
    private static ProductService productService = new ProductService();
    private static StorageService storageService = new StorageService();

    static {
        jobService.personS = personService;

        keyService.storageS = storageService;

        personService.storageS = storageService;

        productService.storageS = storageService;

        storageService.keyS = keyService;
        storageService.productS = productService;
        storageService.personS = personService;
    }

    public static JobService getJobService() {
        return jobService;
    }

    public static KeyService getKeyService() {
        return keyService;
    }

    public static PersonService getPersonService() {
        return personService;
    }

    public static ProductService getProductService() {
        return productService;
    }

    public static StorageService getStorageService() {
        return storageService;
    }
}
