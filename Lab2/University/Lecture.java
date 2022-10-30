import java.util.LinkedList;

public class Lecture {
    private String group;
    private int timeSlot;
    private int type;
    private Classroom classroom;
    private Course course;

    public Lecture(String g, int s, int t) {
        group = g;
        timeSlot = s;
        type = t;
    }

    public void addClassroom(Classroom c) {
        classroom = c;
    }

    public void addCourse(Course c) {
        course = c;
    }

    public String getGroup() {
        return group;
    }
    public int getTimeSlot() {
        return timeSlot;
    }
    public int getType() {
        return type;
    }
    public Classroom getClassroom() {
        return classroom;
    }
    public Course getCourse() {
        return course;
    }

    public String toString() {
        return String.valueOf(timeSlot);
        //return group.concat("-").concat(String.valueOf(timeSlot));
    }

    public boolean isTheory(){
        if(group.length() == 1) { return true; }
        return false;
    }

    public boolean isLab(){
        if(group.length() == 2) { return true; }
        return false;
    }

    public boolean isSeminar(){
        if(group.length() == 3) { return true; }
        return false;
    }

    public LinkedList<Student> getStudentsOfGroup(){
        // from any lecture group, return the students of that group. Examples:
            // Group 1: if seminar is 111, 112, 121, 122.
            // Group 11: if seminar is 111, 112.
            // Group 111: if seminar is 111.
        LinkedList <Student> students = new LinkedList<Student>();
        for(Enrollment e : course.getEnrollments()){
            if(isSeminar() && e.getSeminarGroup().equals(group)) {
                students.add(e.getStudent());
            }
            if(isLab() && (e.getSeminarGroup().equals(group.concat("1")) || e.getSeminarGroup().equals(group.concat("2")))){
                students.add(e.getStudent());
            }
            if(isTheory() && (e.getSeminarGroup().equals(group.concat("11")) || e.getSeminarGroup().equals(group.concat("12")) || e.getSeminarGroup().equals(group.concat("21")) || e.getSeminarGroup().equals(group.concat("22")))){
                students.add(e.getStudent());
            }
        }
        return students;
    }

    public LinkedList<Teacher> teacherOfLecture() {
        LinkedList<Teacher> teacherList = new LinkedList<Teacher>();
        for(int i=0; i< course.getAssignments().size(); i++){
            for(int j=0; j < course.getAssignments().get(i).getGroups().length; j++) {
                if(group.equals(course.getAssignments().get(i).getGroups()[j])) {
                    teacherList.add(course.getAssignments().get(i).getTeacher());
                }
                
            }
        }
        return teacherList;
    }
}