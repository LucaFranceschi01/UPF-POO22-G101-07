import java.util.*;

public class Course {
    private String name;
    private LinkedList<Enrollment> enrollments;
    private LinkedList<Assignment> assignments;
    private LinkedList<Lecture> lectures;

    public Course(String n) {
        name = n;
        enrollments = new LinkedList<Enrollment>();
        assignments = new LinkedList<Assignment>();
        lectures = new LinkedList<Lecture>();
    }

    public void addEnrollment(Enrollment e) {
        enrollments.add(e); 
    }

    public void addAssignment(Assignment a) {
        assignments.add(a);
    }

    public void addLecture(Lecture l) {
        lectures.add(l);
    }

    public String getName() {
        return name;
    }

    public LinkedList<Enrollment> getEnrollments() {
        return enrollments;
    }

    public LinkedList<Assignment> getAssignments() {
        return assignments;
    }

    public LinkedList<Lecture> getLectures() {
        return lectures;
    }
}
