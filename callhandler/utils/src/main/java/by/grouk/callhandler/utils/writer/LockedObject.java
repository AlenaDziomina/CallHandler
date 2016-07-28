package by.grouk.callhandler.utils.writer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Alena_Grouk on 7/28/2016.
 */
public class LockedObject<T> {
    private final Lock lock = new ReentrantLock();
    private final T object;

    public LockedObject(T object) {
        this.object = object;
    }

    public Lock getLock() {
        return lock;
    }

    public T getObject() {
        return object;
    }
}
