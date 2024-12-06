import java.util.*;

public class TeacherRepo {

    private final Map<String, Teacher> teachers = new HashMap<>();

    public List<Teacher> getAllTeachers() {
        return new ArrayList<>(teachers.values());
    }

    public Teacher save(Teacher teacher) {
        teachers.put(teacher.getId(), teacher);
        return teacher;
    }

    public Optional<Teacher> getTeacherBySubject(String subject) {
        return teachers.values().stream()
                .filter(teacher -> teacher.getSubject().equals(subject))
                .findFirst();
    }
}
