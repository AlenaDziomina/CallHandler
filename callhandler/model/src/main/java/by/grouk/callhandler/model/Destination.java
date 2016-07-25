package by.grouk.callhandler.model;

import java.util.Objects;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
public class Destination {
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Destination that = (Destination) o;
        return Objects.equals(fileName, that.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName);
    }

    @Override
    public String toString() {
        return "Destination{" +
                "fileName='" + fileName + '\'' +
                '}';
    }
}
