package keyValueStoreTransactional;

public class TransactionalKeyStoreDriver {
    public static void main(String[] args) throws Exception {
        TransactionalKeyValueStore store = new TransactionalKeyValueStore();
        store.showAll();
        store.set("key1", "value1");
        store.set("key2", "value2");
        store.showAll();
        System.out.println("Showing value for key2 : " + " -> " + store.get("key2"));
        store.set("key3", "value3");
        store.set("key2", "value4");
        store.showAll();
        store.unset("key1");
        store.showAll();
    }
}
