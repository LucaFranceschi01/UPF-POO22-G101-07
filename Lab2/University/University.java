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
        LinkedList<String[]> enr = Utility.readXML("enrollment");
        LinkedList<String[]> ass = Utility.readXML("assignment");

        for(String[] arr : lec) {
            Lecture l = new Lecture(arr[4], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]));
            Classroom cl = Utility.getObject(arr[0], classrooms);
            Course co = Utility.getObject(arr[1], courses);
            l.addClassroom(cl);
            l.addCourse(co);
            cl.addLecture(l);
            co.addLecture(l);
        }

        for(String[] arr : enr) {
            Enrollment e = new Enrollment(arr[2]);
            Student st = Utility.getObject(arr[0], students);
            e.addStudent(new Student(arr[0], st.getNia()));
            e.addCourse(new Course(arr[1]));
            st.addEnrollment(e);
        }

        for(String[] arr : ass) {
            Assignment a = new Assignment(Arrays.copyOfRange(arr, 2, arr.length));
            Teacher te = Utility.getObject(arr[0], teachers);
            Course co = Utility.getObject(arr[1], courses);
            a.addTeacher(te);
            a.addCourse(co);
            te.addAssignment(a);
            co.addAssignment(a);
        }
    }

    public LinkedList<String> getStudents() {
        return Utility.toString(students);
    }

    public LinkedList<String> getTeachers() {
        return Utility.toString(teachers);
    }

    public LinkedList<String> getClassrooms() {
        return Utility.toString(classrooms);
    }

    public LinkedList<String> getCourses() {
        return Utility.toString(courses);
    }

    public LinkedList<Student> getStudentsClass() {
        return students;
    }

    public LinkedList<Teacher> getTeachersClass() {
        return teachers;
    }

    public LinkedList<Course> getCourseClass() {
        return courses;
    }

    public void courseOfStudent(Student s) {
        LinkedList<Course> coursesOfStud = s.coursesOfStudent();
        System.out.printf("Name: %-22s | Nia: %-10d | Courses: [", s.getName(), s.getNia());
        for(int i=0; i<coursesOfStud.size(); i++){
            if(i == coursesOfStud.size()-1) {
                System.out.printf("%s]", coursesOfStud.get(i));
            } else {
                System.out.printf("%s, ", coursesOfStud.get(i));
            }            
        }
        System.out.println();
    }

    public void teacherOfCourse(Course c) {
        LinkedList<Teacher> teachersOfCourse = c.teachersOfCourse();
        System.out.printf("Course: %-20s | Teachers: [", c.getName());
        for(int i=0; i<teachersOfCourse.size(); i++){
            if(i == teachersOfCourse.size()-1) {
                System.out.printf("%s]", teachersOfCourse.get(i));
            } else {
                System.out.printf("%s, ", teachersOfCourse.get(i));
            }            
        }
        System.out.println();
    }
}