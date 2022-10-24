public class Enrollment {
    private String seminarGroup;
    private Student student;
    private Course course;

    public Enrollment(String sg) {
        seminarGroup = sg;
    }

    public void addStudent(Student s) {
        student = s;
    }

    public void addCourse(Course c) {
        course = c;
    }
}
