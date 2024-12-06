import lombok.Builder;
import lombok.Data;
import lombok.With;

@Builder
@With
@Data
public class Student {
    private final String id;
    private final String name;
    private final String address;
    private final double gpa;
}
