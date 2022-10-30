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
            Course co = Utility.getObject(arr[1], courses);
            e.addStudent(new Student(arr[0], st.getNia()));
            e.addCourse(new Course(arr[1]));
            st.addEnrollment(e);
            co.addEnrollment(e);            
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

    public LinkedList<Course> getCoursesClass() {
        return courses;
    }

    public LinkedList<Classroom> getClassroomsClass() {
        return classrooms;
    }

    public void coursesOfStudent(Student s) { // propagates Student.coursesOfStudent() and prints it in a legible way for all students
        LinkedList<Course> coursesOfStud = s.coursesOfStudent();
        System.out.printf("Name: %-22s | Nia: %-10d | Courses: %s%n", s.getName(), s.getNia(), coursesOfStud.toString());
    }

    public void teachersOfCourse(Course c) { // propagates Course.teachersOfCourse() and prints it in a legible way for all courses
        LinkedList<Teacher> teachersOfCourse = c.teachersOfCourse();
        System.out.printf("Course: %-20s | Teachers: %s%n", c.getName(), teachersOfCourse.toString());
    }

    public void coursesOfClassroom(Classroom c) { // propagates Classroom.coursesOfClassroom() and prints it in a legible way
        LinkedList<Course> coursesOfClassroom = c.coursesOfClassroom();
        System.out.printf("Classroom: %-7s | Courses: %s%n", c.getCode(), coursesOfClassroom.toString());
    }

    public void studentsOfTeacher(Teacher t, Classroom c) {
        LinkedList<Lecture> lecturesInClassroom = t.lecturesOfTeacherInClassroom(c);
        LinkedList <LinkedList<Student>> studentsOfTeacher = new LinkedList<>();
        for(Lecture l : lecturesInClassroom){
            studentsOfTeacher.add(l.getStudentsOfGroup());
        }

        System.out.printf("Teacher: %-20s | Classroom: %s | Students: %s", t.getName(), c.getCode(), studentsOfTeacher.toString());
        System.out.println();
    }

    public void classroomOfTeacher(Teacher t, int timeSlot) {
        // lectures held in the course that a teacher gives
        // and they have a fixed timeslot
        LinkedList<Lecture> lecturesOfTeacher = t.lecturesOfTeacher();
        LinkedList<Lecture> lecturesOfTeacherInSlot = new LinkedList<Lecture>();

        for(Lecture l : lecturesOfTeacher){
            if(l.getTimeSlot() == timeSlot) {
                lecturesOfTeacherInSlot.add(l);
            }
        }
        LinkedList<Classroom> classroomList = new LinkedList<Classroom>();
        for(int i=0; i<lecturesOfTeacherInSlot.size(); i++){
            classroomList.add(lecturesOfTeacherInSlot.get(i).getClassroom());
        }
        System.out.printf("Teacher: %-30s | Timeslot: %d | Classrooms: %s%n", t.getName(), timeSlot, classroomList.toString());
    }

    public void teacherOfStudent(Student s, Course c, int type) {
        LinkedList<Teacher> teacherList = s.teacherOfStudent(c, type);
        if(teacherList.size() == 1) {
            System.out.printf("Student: %-22s | Course: %-20s | Type: %d | Teacher: %s%n", s.getName(), c.getName(), type, teacherList.get(0).toString());
        }
    }
}