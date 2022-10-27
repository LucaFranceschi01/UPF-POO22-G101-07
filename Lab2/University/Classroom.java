import java.util.*;

public class Classroom {
    private String code;
    private LinkedList<Lecture> lectures;

    public Classroom(String c) {
        code = c;
        lectures = new LinkedList<Lecture>();
    }

    public void addLecture(Lecture l) {
        lectures.add(l);
    }

    public String getCode() {
        return code;
    }

    public LinkedList<Lecture> getLectures() {
        return lectures;
    }

    public String toString() {
        return code;
    }

    public LinkedList<Course> coursesOfClassroom() { // from all lectures, returns a list of courses
        LinkedList<Course> courses = new LinkedList<Course>();
        for(int i=0; i<lectures.size(); i++) {
            courses.add(lectures.get(i).getCourse());
        }
        return courses;
    }
}
