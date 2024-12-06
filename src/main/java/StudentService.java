/*
Step 1: Extend the StudentDB with a findById method with a parameter id that returns
a Student. For the self-confident: If you want to proceed test-driven (TDD, test-driven
 development), you can also start with step 3.
Step 2: The findById method should throw an appropriate exception if no student with
the Id exists. Also consider what the "appropriate exception" might be. A
Checked Exception or an Unchecked Exception? An instance of a predefined or
a self-written exception class?
Step 3: Write at least one test that verifies this behavior.*/

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class StudentService {

    private final StudentRepo sr = new StudentRepo();
    private final CourseRepo cr = new CourseRepo();
    private final TeacherRepo tr = new TeacherRepo();

    private String generateId() {
        return UUID.randomUUID().toString();
    }

    public Student addNewStudent(Student newStudent) {
        Student studentToSave = newStudent.toBuilder()
                .id(generateId())
                .build();
        return sr.save(studentToSave);
    }

    public List<Student> getAllStudents() {
        return sr.getAllStudents();
    }

    public Student findStudentById(String number) throws StudentNotFoundException {
        Optional<Student> student = sr.findStudentById(number);
        if (student.isEmpty()) {
            throw new StudentNotFoundException("Student with id " + number + " not found");
        }
        return student.get();
    }

    public Course addNewCourse(Course newCourse) {
        Course courseToSave = newCourse.toBuilder()
                .id(generateId())
                .build();
        return cr.save(courseToSave);
    }

    public List<Course> getAllCourses() {
        return cr.getAllCourses();
    }

    public Teacher addNewTeacher(Teacher newTeacher) {
        Teacher teacherToSave = newTeacher.toBuilder()
                .id(generateId()).build();
        return tr.save(teacherToSave);
    }

    public List<Teacher> getAllTeachers() {
        return tr.getAllTeachers();
    }

    public Teacher getTeacherBySubject(String subject) throws TeacherNotFoundException {
        return tr.getTeacherBySubject(subject)
                .orElseThrow(() -> new TeacherNotFoundException("Teacher with subject " + subject + " not found"));
    }


}
