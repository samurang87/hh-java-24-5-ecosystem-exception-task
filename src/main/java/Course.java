/* Step 4: Create a class Course with the following attributes: id, name, teacher,
 students.
 Step 4.5: Use the appropriate Lombok annotations to generate getters, setters,
 equals, hashCode, toString, and constructors for the entity.
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Data
public class Course {
    private final String id;
    private String name;
    private Teacher teacher;
    private List<Student> students;

    @Builder
    private Course(String name, Teacher teacher, List<Student> students) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.teacher = teacher;
        this.students = students;
    }
}
