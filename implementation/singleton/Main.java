package implementation.singleton;

public class Main {

    public static void main(String args[]){
        EagerSingleton singleton1 = EagerSingleton.getInstance();
        EagerSingleton singleton2 = EagerSingleton.getInstance();
        System.out.println(singleton1 == singleton2); // true

        LazySingletonWithDCL lazySingleton1 = LazySingletonWithDCL.getInstance();
        LazySingletonWithDCL lazySingleton2 = LazySingletonWithDCL.getInstance();
        System.out.println(lazySingleton1 == lazySingleton2); // true

        LazySingletonIODH lazySingleton3 = LazySingletonIODH.getInstance();
        LazySingletonIODH lazySingleton4 = LazySingletonIODH.getInstance();
        System.out.println(lazySingleton3 == lazySingleton4); // true
    }
}