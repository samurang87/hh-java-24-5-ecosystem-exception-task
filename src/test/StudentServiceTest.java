import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentServiceTest {

    @Test
    void findStudentById_returnsStudentWhenIdFound() {
        Student student = Student.builder()
                .name("Alice")
                .build();
        StudentService studentService = new StudentService();
        Student savedStudent = studentService.addNewStudent(student);

        Student result = studentService.findStudentById(savedStudent.id());

        Assertions.assertEquals(savedStudent, result);
    }

    @Test
    void findStudentById_throwsExceptionWhenIdNotFound() {
        StudentService studentService = new StudentService();

        Assertions.assertThrows(StudentNotFoundException.class, () -> {
            studentService.findStudentById("1");
        });
    }
}
