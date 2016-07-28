package by.grouk.callhandler.model;

import java.util.Objects;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
public class Destination {
    private String fileName;
    private String filePath;
    private String charset;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Destination that = (Destination) o;
        return Objects.equals(fileName, that.fileName) &&
                Objects.equals(filePath, that.filePath) &&
                Objects.equals(charset, that.charset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, filePath, charset);
    }

    @Override
    public String toString() {
        return "Destination{" +
                "fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", charset='" + charset + '\'' +
                '}';
    }
}
