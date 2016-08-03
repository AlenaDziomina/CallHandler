package by.grouk.callhandler.utils.writer;

import by.grouk.callhandler.model.MessageTemplate;
import by.grouk.callhandler.utils.exception.processing.factory.ExceptionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.annotation.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.locks.Lock;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by Alena on 03.08.2016.
 */
@RunWith(PowerMockRunner.class)
public class FileWriterTest {

    private FileWriter fileWriter;
    private LockPool<String> fileLockPool;
    private ExceptionFactory exceptionFactory;


    @Before
    public void setup() throws Exception {
        fileWriter = new FileWriter();
        fileLockPool = mock(LockPool.class);
        exceptionFactory = mock(ExceptionFactory.class);
        MemberModifier.field(FileWriter.class, "fileLockPool").set(fileWriter , fileLockPool);
        MemberModifier.field(FileWriter.class, "exceptionFactory").set(fileWriter , exceptionFactory);
    }

    @Test
    public void write() throws Exception {
        MessageTemplate template = mock(MessageTemplate.class);
        String name = "name";
        String charsetName = "charset";
        String filePath = "filePath";
        LockedObject lockedPath = mock(LockedObject.class);
        Lock lock = mock(Lock.class);

        when(template.getDestination().getFileName()).thenReturn(name);
        when(template.getDestination().getCharset()).thenReturn(charsetName);
        when(template.getDestination().getFilePath()).thenReturn(filePath);
        when(fileLockPool.getLockedObject(name, filePath)).thenReturn(lockedPath);
        when(lockedPath.getLock()).thenReturn(lock);
        when(lockedPath.getObject()).thenReturn(filePath);


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