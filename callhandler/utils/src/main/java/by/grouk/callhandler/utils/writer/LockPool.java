package by.grouk.callhandler.utils.writer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.stereotype.Component;

/**
 * Created by Alena_Grouk on 7/28/2016.
 */
@Component
public class LockPool<T> {
    private final Map<String, LockedObject<T>> pool = new HashMap<>();
    private final Lock lock = new ReentrantLock();

    public LockedObject<T> getLockedObject(String key, T object){
        return Optional.ofNullable(pool.get(key)).orElse(addLock(key, object));
    }

    private LockedObject<T> addLock(String key, T object) {
        try {
            lock.lock();
            return Optional.ofNullable(pool.get(key)).orElse(createLock(key, object));
        } finally {
            lock.unlock();
        }
    }

    private LockedObject<T> createLock(String key, T object) {
        LockedObject<T> lockedObject = new LockedObject<T>(object);
        pool.put(key, lockedObject);
        return lockedObject;
    }
}
