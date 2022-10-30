import java.util.*;

public class TestUniversity {
    public static void main(String[] args) {
        University university = new University();
        LinkedList<Student> studentList = university.getStudentsClass();
        LinkedList<Course> courseList = university.getCoursesClass();
        LinkedList<Classroom> classroomList = university.getClassroomsClass();
        LinkedList<Teacher> teacherList = university.getTeachersClass();

        System.out.println(university.getStudents());
        System.out.println(university.getTeachers());
        System.out.println(university.getClassrooms());
        System.out.println(university.getCourses());

        System.out.println("-".repeat(120));
        for(int i=0; i<studentList.size(); i++) {
            university.coursesOfStudent(studentList.get(i));
        }

        System.out.println("-".repeat(120));
        for(int i=0; i<courseList.size(); i++) {
            university.teachersOfCourse(courseList.get(i));
        }

        System.out.println("-".repeat(120));
        for(int i=0; i<classroomList.size(); i++) {
            university.coursesOfClassroom(classroomList.get(i));
        }

        System.out.println("-".repeat(120));
        for(int i=0; i<classroomList.size(); i++) {
            university.studentsOfTeacher(teacherList.get(0), classroomList.get(i));
        }

        System.out.println("-".repeat(120));
        for(int i=0; i<teacherList.size(); i++) {
            university.classroomOfTeacher(teacherList.get(i), 0);
        }

        System.out.println("-".repeat(120));
        for(int i=0; i<courseList.size(); i++) {
            university.teacherOfStudent(studentList.get(0), courseList.get(i), 1);
        }
    }
}