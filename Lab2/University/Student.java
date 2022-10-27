import java.util.*;

public class Student {
    private String name;
    private int nia;
    private LinkedList<Enrollment> enrollments;

    public Student(String n, int code) {
        name = n;
        nia = code;
        enrollments = new LinkedList<Enrollment>();
    }

    public void addEnrollment(Enrollment e) {
        enrollments.add(e); 
    }

    public String getName() {
        return name;
    }

    public int getNia() {
        return nia;
    }

    public LinkedList<Enrollment> getEnrollments() {
        return enrollments;
    }

    public String toString() {
        return name;
    }

    public LinkedList<Course> coursesOfStudent() { // for all enrollments, returns a list of courses
        LinkedList<Course> courses = new LinkedList<Course>();
        for(int i=0; i<enrollments.size(); i++) {
            courses.add(enrollments.get(i).getCourse());
        }
        return courses;
    }
}