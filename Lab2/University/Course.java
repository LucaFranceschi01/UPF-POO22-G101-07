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

    public String toString() {
        return name;
    }

    public LinkedList<Teacher> teachersOfCourse() { // from all assignments, returns a list of teachers
        LinkedList<Teacher> teachers = new LinkedList<Teacher>();
        for(int i=0; i<assignments.size(); i++) {
            teachers.add(assignments.get(i).getTeacher());
        }
        return teachers;
    }
}
