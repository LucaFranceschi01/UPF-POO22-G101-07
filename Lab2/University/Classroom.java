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
}
