import java.util.Arrays;

public class Assignment {
    private String[] groups;
    private Teacher teacher;
    private Course course;

    public Assignment(String[] g) {
        groups = g;
    }

    public void addTeacher(Teacher t) {
        teacher = t;
    }

    public void addCourse(Course c) {
        course = c;
    }

    public String[] getGroups() {
        return groups;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Course getCourse() {
        return course;
    }

    public String toString() {
        return Arrays.toString(getGroups());
    }
}
