import java.util.*;

public class Assignment {
    private LinkedList<String> groups;
    private Teacher teacher;
    private Course course;

    public Assignment(LinkedList<String> g) {
        groups = g;
    }

    public void addTeacher(Teacher t) {
        teacher = t;
    }

    public void addCourse(Course c) {
        course = c;
    }
}
