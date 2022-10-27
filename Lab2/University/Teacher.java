import java.util.*;

public class Teacher {
    private String name;
    private LinkedList<Assignment> assignments;

    public Teacher(String n) {
        name = n;
        assignments = new LinkedList<Assignment>();
    }

    public void addAssignment(Assignment a) {
        assignments.add(a);
    }

    public String getName() {
        return name;
    }

    public LinkedList<Assignment> getAssignments() {
        return assignments;
    }

    public String toString() {
        return name;
    }

    /*public LinkedList<Student> studentsOfTeacher() { // from all assignments, returns a list of teachers
        LinkedList<Student> students = new LinkedList<Student>();
        for(int i=0; i<assignments.size(); i++) {
            Course c = assignments.get(i).getCourse();
            LinkedList<Enrollment> e = c.getEnrollments();
        }
        return students;
    }*/
}