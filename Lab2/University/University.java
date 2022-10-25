import java.util.*;

public class University {
    private LinkedList<Student> students;
    private LinkedList<Teacher> teachers;
    private LinkedList<Classroom> classrooms;
    private LinkedList<Course> courses;

    public University() {
        students = new LinkedList<Student>();
        teachers = new LinkedList<Teacher>();
        classrooms = new LinkedList<Classroom>();
        courses = new LinkedList<Course>();

        LinkedList<String[]> std = Utility.readXML("student");
        for(String[] array : std) {
            Student st = new Student(array[0], Integer.parseInt(array[1]));
            students.add(st);
        }
        LinkedList<String[]> tch  = Utility.readXML("teacher");
        for(String[] array : tch) {
            Teacher te = new Teacher(array[0]);
            teachers.add(te);
        }
        LinkedList<String[]> cls = Utility.readXML("classroom");
        for(String[] array : cls) {
            Classroom cl = new Classroom(array[0]);
            classrooms.add(cl);
        }
        LinkedList<String[]> cou = Utility.readXML("course");
        for(String[] array : cou) {
            Course co = new Course(array[0]);
            courses.add(co);
        }

        LinkedList<String[]> lec = Utility.readXML("lecture");
        for(String[] array : lec) {
            Lecture le = new Lecture(array[4], Integer.parseInt(array[2]), Integer.parseInt(array[3]));
            for(Classroom cl : classrooms) {
                if(cl.getCode().equals(array[0])) {
                    le.addClassroom(cl);
                    cl.addLecture(le);
                }
            }
            for(Course co : courses) {
                if(co.getName().equals(array[1])) {
                    le.addCourse(co);
                    co.addLecture(le);
                }
            }
        }

        LinkedList<String[]> enr = Utility.readXML("enrollment");
        for(String[] array : enr) {
            Enrollment en = new Enrollment(array[2]);
            for(Student st : students) {
                en.addStudent(st);
                st.addEnrollment(en);
            }
            for(Course co : courses) {
                en.addCourse(co);
                co.addEnrollment(en);
            }
        }
        
        LinkedList<String[]> ass = Utility.readXML("assignment");
        for(String[] arr : ass) {
            Assignment as = new Assignment(Arrays.copyOfRange(arr, 2, arr.length));
            for(Teacher te : teachers) {
                as.addTeacher(te);
                te.addAssignment(as);
            }
            for(Course co : courses) {
                as.addCourse(co);
                co.addAssignment(as);
            }
        }
    }
}
