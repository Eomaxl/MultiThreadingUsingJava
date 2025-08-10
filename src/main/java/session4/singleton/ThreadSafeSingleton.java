package session4.singleton;

public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;   // volatile - don't keep in local, keep the value in in-memory

    private ThreadSafeSingleton() {

    }

    public static ThreadSafeSingleton getInstance() {
        if(instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    public static ThreadSafeSingleton getInstance2() {
        if(instance != null) {
            return instance;
        }

        synchronized (ThreadSafeSingleton.class) {
            if(instance == null) {
                instance = new ThreadSafeSingleton();
            }
        }
        return instance;
    }

    public static ThreadSafeSingleton getInstance3() {

    }
}
