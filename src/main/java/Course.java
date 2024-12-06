/* Step 4: Create a class Course with the following attributes: id, name, teacher,
 students.
 Step 4.5: Use the appropriate Lombok annotations to generate getters, setters,
 equals, hashCode, toString, and constructors for the entity.
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder(toBuilder = true)
@AllArgsConstructor
@Data
public class Course {
    private final String id;
    private String name;
    private Teacher teacher;
    private List<Student> students;
}
