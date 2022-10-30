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

    public LinkedList<Course> coursesOfClassroom() { // from all classrooms, returns a list of courses
        Set<Course> courSet = new HashSet<Course>(); // for no duplicate courses
        for(int i=0; i<lectures.size(); i++) {
            //check if course is already held in classroom independently of group/slot/type
            courSet.add(lectures.get(i).getCourse());
        }
        return new LinkedList<>(courSet);
    }

    public LinkedList<Teacher> teacherOfClassroom(int timeSlot) {
        LinkedList<Teacher> teacherList = new LinkedList<Teacher>();
        for(int i=0; i<lectures.size(); i++) {
            if(lectures.get(i).getTimeSlot() == timeSlot) {
                for(int j=0; j<lectures.get(i).getCourse().getAssignments().size(); j++) {
                    teacherList.add(lectures.get(i).getCourse().getAssignments().get(j).getTeacher());
                }
            }
        }
        return teacherList;
    }

    public LinkedList<Student> studentsOfClassroom(int timeSlot) {
        LinkedList<Student> studentList = new LinkedList<Student>();
        for(int i=0; i<lectures.size(); i++) {
            if(lectures.get(i).getTimeSlot() == timeSlot) {
                for(int j=0; j<lectures.get(i).getCourse().getEnrollments().size(); j++) {
                    studentList.add(lectures.get(i).getCourse().getEnrollments().get(j).getStudent());
                }
            }
        }
        return studentList;
    }
}