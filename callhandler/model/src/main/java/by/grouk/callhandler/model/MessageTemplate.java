package by.grouk.callhandler.model;

import java.util.Objects;

/**
 * Created by Alena_Grouk on 7/22/2016.
 */
public class MessageTemplate {
    private Destination destination;
    private Content content;

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MessageTemplate that = (MessageTemplate) o;
        return Objects.equals(destination, that.destination) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, content);
    }

    @Override
    public String toString() {
        return "MessageTemplate{" +
                "destination=" + destination +
                ", content=" + content +
                '}';
    }
}
