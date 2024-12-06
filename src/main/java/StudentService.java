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

    private final StudentRepo repo = new StudentRepo();

    public Student addNewStudent(Student newStudent) {
        Student studentToSave = Student.builder().id(UUID.randomUUID().toString()).build();
        return repo.save(studentToSave);
    }

    public List<Student> getAllStudents(){
        return repo.getAllStudents();
    }

    public Student findStudentById(String number) throws StudentNotFoundException {
        Optional<Student> student = repo.findStudentById(number);
        if (student.isEmpty()) {
            throw new StudentNotFoundException("Student with id " + number + " not found");
        }
        return student.get();
    }
}
