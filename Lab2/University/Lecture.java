public class Lecture {
    private String group;
    private int timeSlot;
    private int type;
    private Classroom classroom;
    private Course course;

    public Lecture(String g, int s, int t) {
        group = g;
        timeSlot = s;
        type = t;
    }

    public void addClassroom(Classroom c) {
        classroom = c;
    }

    public void addCourse(Course c) {
        course = c;
    }
}
