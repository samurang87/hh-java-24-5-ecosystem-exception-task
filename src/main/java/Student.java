import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Student {
    private final String id;
    private final String name;
    private final String address;
    private final double gpa;
}
