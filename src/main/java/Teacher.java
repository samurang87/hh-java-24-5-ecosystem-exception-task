import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@AllArgsConstructor
@Data
public class Teacher {
    private final String id;
    private final String name;
    private final String subject;

}
