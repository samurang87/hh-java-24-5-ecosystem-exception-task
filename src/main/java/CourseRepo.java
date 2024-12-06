import java.util.*;

public class CourseRepo {

    private final Map<String, Course> courses = new HashMap<>();

    public List<Course> getAllCourses() {
        return new ArrayList<>(courses.values());
    }

    public Course save(Course course) {
        courses.put(course.getId(), course);
        return course;
    }
}
