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
}
