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
}
