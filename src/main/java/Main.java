import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        Student student1 = studentService.addNewStudent(Student.builder()
                .name("Florian")
                .address("Musterstraße 42, 10337 Berlin")
                .build());

        System.out.println(
                "Student with id " + student1.getId() +
                        "is " + studentService.findStudentById(student1.getId()));

        Student student2 = studentService.addNewStudent(Student.builder()
                .name("Alice")
                .address("Alexanderplatz 12, 10117 Berlin")
                .build());

        Student student3 = studentService.addNewStudent(Student.builder()
                .name("Bob")
                .address("Karl-Marx-Allee 1, 10247 Berlin")
                .build());

        Student student4 = studentService.addNewStudent(Student.builder()
                .name("Charlie")
                .address("Kurfürstendamm 1, 12117 Berlin")
                .build());

        ArrayList<Student> enrolledStudents = new ArrayList<>(List.of(student1, student2, student3, student4));

        System.out.println("All students: " + studentService.getAllStudents());

        Teacher philologyTeacher = studentService.addNewTeacher(Teacher.builder()
                .name("Mr. Smith")
                .subject("philology")
                .build());

        Teacher rethoricTeacher = studentService.addNewTeacher(Teacher.builder()
                .name("Mrs. Johnson")
                .subject("rhetoric")
                .build());

        System.out.println("All teachers: " + studentService.getAllTeachers());

        System.out.println("Philology is taught by: " + studentService.getTeacherBySubject("philology"));
        System.out.println("Rhetoric is taught by: " + studentService.getTeacherBySubject("rhetoric"));

        Course philology101 = Course.builder()
                .name("Introduction to Philology")
                .teacher(philologyTeacher)
                .students(enrolledStudents.subList(1, 3))
                .build();

        Course rhetoric101 = Course.builder()
                .name("Introduction to Rhetoric")
                .teacher(rethoricTeacher)
                .students(enrolledStudents.subList(0, 2))
                .build();

        for (Course course : List.of(philology101, rhetoric101)) {
            studentService.addNewCourse(course);
        }

        System.out.println("All courses: " + studentService.getAllCourses());
    }
}
