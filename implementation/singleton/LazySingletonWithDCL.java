package implementation.singleton;

// DCL - Double Lock Checking
public class LazySingletonWithDCL {

    private LazySingletonWithDCL(){};

    // It can happen that some thread has cached the value of INSTANCE and will always return true for INSTANCE == null.
    // Therefore, we are using volatile
    // volatile forces value read/write from main memory instead of cache.
    private static volatile LazySingletonWithDCL INSTANCE;

    public static LazySingletonWithDCL getInstance(){
        if(INSTANCE == null){
            // Suppose two thread enters this same block simultaneously then we need this block to be synchronized.
            synchronized (LazySingletonWithDCL.class){
                // Double check locking (DCL)
                // The double checked pattern is used to avoid obtaining the lock every time the code is executed.
                // If the call are not happening together then the first condition will fail and the code execution will not execute the locking thus saving resources.
                if(INSTANCE == null){
                    INSTANCE = new LazySingletonWithDCL();
                }
            }
        }
        return INSTANCE;
    }
}
