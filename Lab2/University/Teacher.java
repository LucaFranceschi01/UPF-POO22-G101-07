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

    public LinkedList<Lecture> lecturesOfTeacherInClassroom(Classroom c){
        LinkedList <Lecture> lectures = new LinkedList<Lecture>();
        for(Assignment a : assignments){
            for(int i=0; i<a.getCourse().getLectures().size(); i++){
                if(a.getCourse().getLectures().get(i).getClassroom().toString().equals(c.toString())){
                    lectures.add(a.getCourse().getLectures().get(i));
                }
            }
        }
        return lectures;
    }

    public LinkedList<Lecture> lecturesOfTeacher(){
        LinkedList <Lecture> lectures = new LinkedList<Lecture>();
        for(Assignment a : assignments){
            for(int i=0; i<a.getCourse().getLectures().size(); i++){
                lectures.add(a.getCourse().getLectures().get(i));
            }
        }
        return lectures;
    }
}