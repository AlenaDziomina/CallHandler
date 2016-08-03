package by.grouk.callhandler.utils.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.locks.Lock;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import by.grouk.callhandler.model.MessageTemplate;
import by.grouk.callhandler.utils.exception.processing.factory.ExceptionFactory;

/**
 * Created by Alena_Grouk on 7/28/2016.
 */
@Component
public class FileWriter {

    @Resource
    private LockPool<String> fileLockPool;

    @Resource
    private ExceptionFactory exceptionFactory;

    public void write(MessageTemplate template) {
        String name = template.getDestination().getFileName();
        String charsetName = template.getDestination().getCharset();
        LockedObject<String> lockedPath = fileLockPool.getLockedObject(name, template.getDestination().getFilePath());
        Lock lock = lockedPath.getLock();
        String filePath = lockedPath.getObject();
        try {
            lock.lock();
            Path path = Paths.get(filePath);
            if (!Files.exists(path)) {
                String msg = template.getContent().getHeader() + template.getContent().getMessage();
                Files.write(path, msg.getBytes(charsetName), StandardOpenOption.CREATE);
            } else {
                String msg = template.getContent().getMessage();
                Files.write(path, msg.getBytes(charsetName), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw exceptionFactory.createInternalException(e);
        } finally {
            lock.unlock();
        }
    }
}
