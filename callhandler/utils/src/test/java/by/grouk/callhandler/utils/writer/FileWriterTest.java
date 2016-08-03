package by.grouk.callhandler.utils.writer;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.locks.Lock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import by.grouk.callhandler.model.Content;
import by.grouk.callhandler.model.Destination;
import by.grouk.callhandler.model.MessageTemplate;
import by.grouk.callhandler.utils.exception.processing.factory.ExceptionFactory;

/**
 * Created by Alena on 03.08.2016.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(FileWriter.class)
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

        mockStatic(Paths.class);
        mockStatic(Files.class);
    }

    @Test
    public void writeAppend() throws Exception {
        MessageTemplate template = mock(MessageTemplate.class);
        Destination dest = mock(Destination.class);
        Content content = mock(Content.class);
        String name = "name";
        String charsetName = "utf-8";
        String filePath = "filePath";
        LockedObject lockedPath = mock(LockedObject.class);
        Lock lock = mock(Lock.class);
        Path path = mock(Path.class);
        String msg = mock(String.class);
        byte[] bytes = new byte[]{};

        when(template.getDestination()).thenReturn(dest);
        when(dest.getFileName()).thenReturn(name);
        when(dest.getCharset()).thenReturn(charsetName);
        when(dest.getFilePath()).thenReturn(filePath);
        when(fileLockPool.getLockedObject(name, filePath)).thenReturn(lockedPath);
        when(lockedPath.getLock()).thenReturn(lock);
        when(lockedPath.getObject()).thenReturn(filePath);
        when(Paths.get(filePath)).thenReturn(path);
        when(Files.exists(path)).thenReturn(true);
        when(template.getContent()).thenReturn(content);
        when(content.getMessage()).thenReturn(msg);
        when(msg.getBytes(charsetName)).thenReturn(bytes);

        fileWriter.write(template);

        verify(lock).lock();
        verifyStatic(times(1));
        Files.write(path, bytes, StandardOpenOption.APPEND);
        verify(lock).unlock();
    }

    @Test
    public void writeCreate() throws Exception {
        MessageTemplate template = mock(MessageTemplate.class);
        Destination dest = mock(Destination.class);
        Content content = mock(Content.class);
        String name = "name";
        String charsetName = "utf-8";
        String filePath = "filePath";
        LockedObject lockedPath = mock(LockedObject.class);
        Lock lock = mock(Lock.class);
        Path path = mock(Path.class);
        String msg = mock(String.class);
        String header = mock(String.class);
        String msg2 = mock(String.class);
        byte[] bytes = new byte[]{};

        when(template.getDestination()).thenReturn(dest);
        when(dest.getFileName()).thenReturn(name);
        when(dest.getCharset()).thenReturn(charsetName);
        when(dest.getFilePath()).thenReturn(filePath);
        when(fileLockPool.getLockedObject(name, filePath)).thenReturn(lockedPath);
        when(lockedPath.getLock()).thenReturn(lock);
        when(lockedPath.getObject()).thenReturn(filePath);
        when(Paths.get(filePath)).thenReturn(path);
        when(Files.exists(path)).thenReturn(false);
        when(template.getContent()).thenReturn(content);
        when(content.getMessage()).thenReturn(msg);
        when(content.getHeader()).thenReturn(header);
        when(msg.concat(header)).thenReturn(msg2);
        when(msg2.getBytes(charsetName)).thenReturn(bytes);

        fileWriter.write(template);

        verify(lock).lock();
        verifyStatic(times(1));
        Files.write(path, bytes, StandardOpenOption.CREATE);
        verify(lock).unlock();
    }

}