package by.grouk.callhandler.model;

import java.util.Objects;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
public class Content {
    private String header;
    private String message;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Content content = (Content) o;
        return Objects.equals(header, content.header) && Objects.equals(message, content.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, message);
    }

    @Override
    public String toString() {
        return "Content{" +
                "header='" + header + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
