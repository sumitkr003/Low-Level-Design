package implementation.singleton;

// Single pattern using lazy initialization holder class.
// This ensures that we have a lazy initialization without worrying about synchronization
public class LazySingletonIODH {
    private LazySingletonIODH(){};

    private static class RegistryHolder {
        static LazySingletonIODH INSTANCE = new LazySingletonIODH();
    }

    public static LazySingletonIODH getInstance(){
        return RegistryHolder.INSTANCE;
    }

}
