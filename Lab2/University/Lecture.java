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

    public String getGroup() {
        return group;
    }
    public int getTimeSlot() {
        return timeSlot;
    }
    public int getType() {
        return type;
    }
    public Classroom getClassroom() {
        return classroom;
    }
    public Course getCcourse() {
        return course;
    }
}
