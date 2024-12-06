// Create a Teacher record with the following attributes: id, name, subject.

import java.util.UUID;

public record Teacher (String id, String name, String subject) {

    public Teacher(String name, String subject) {
        this(UUID.randomUUID().toString(), name, subject);

    }
}
