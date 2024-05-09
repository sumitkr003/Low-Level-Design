package keyValueStoreTransactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Stack;

public class TransactionalKeyValueStore {
    public class Transaction {
        private Long transactionId;
        private HashMap<String, String> changes;
        private boolean active;
        public Transaction() {
            this.transactionId = new Date().getTime();
            changes = new HashMap<>();
            active = true;
        }
        public synchronized void addChange(String key, String value) {
            this.changes.put(key, value);
        }
        public void completeTransaction() {
            this.active = false;
        }
    }

    private HashMap<String, String> store;
    private Stack<Transaction> transactionStack;

    public TransactionalKeyValueStore() {
        this.store = new HashMap<>();
        this.transactionStack = new Stack<>();
    }

    public Long beginTransaction() throws Exception {
        if(!this.transactionStack.isEmpty() && this.transactionStack.peek().active) {
            throw new Exception("There is already an active transaction on store");
        }
        Transaction transaction = new Transaction();
        transactionStack.add(transaction);
        return transaction.transactionId;
    }

    public synchronized void commitCurrentTransaction() throws Exception {
        if(this.transactionStack.isEmpty() || !this.transactionStack.peek().active) {
            throw new Exception("No Active transaction found");
        }
        Transaction currTransaction = transactionStack.peek();
        store.putAll(currTransaction.changes);
        currTransaction.completeTransaction();
        return;
    }

    public void rollback() throws Exception {
        if(this.transactionStack.isEmpty() || !this.transactionStack.peek().active) {
            throw new Exception("No Active transaction found");
        }
        transactionStack.pop();
        return;
    }

    public String get(String key) throws Exception {
        if(!store.containsKey(key)) {
            throw new Exception("Key not Found for key : "+ key);
        }
        return store.get(key);
    }

    public void set(String key, String value) throws Exception {
        try {
            beginTransaction();
            Transaction currTransaction = transactionStack.peek();
            currTransaction.addChange(key, value);
            commitCurrentTransaction();
        } catch (Exception e) {
            rollback();
            throw e;
        }
        return;
    }

    public void unset(String key) throws Exception {
        this.set(key, null);
    }

    public void showAll() throws Exception {
        System.out.println("Showing All Key Values in Store : ");
        for(String key : store.keySet()) {
            System.out.println(key + " -> " + get(key));
        }
    }
}
