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
}