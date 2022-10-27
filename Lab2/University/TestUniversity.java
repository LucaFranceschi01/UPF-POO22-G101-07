import java.util.*;

public class TestUniversity {
    public static void main(String[] args) {
        University university = new University();
        System.out.println(university.getStudents());
        System.out.println(university.getTeachers());
        System.out.println(university.getClassrooms());
        System.out.println(university.getCourses());

        System.out.println("-----------------------------------------------------------------------------------------------------");

        LinkedList<Student> studentList = university.getStudentsClass();
        for(int i=0; i<studentList.size(); i++) {
            university.coursesOfStudent(studentList.get(i));
        }

        System.out.println("-----------------------------------------------------------------------------------------------------");

        LinkedList<Course> courseList = university.getCourseClass();
        for(int i=0; i<courseList.size(); i++) {
            university.teachersOfCourse(courseList.get(i));
        }
        
        System.out.println("-----------------------------------------------------------------------------------------------------");

        LinkedList<Classroom> classroomList = university.getClassroomClass();
        for(int i=0; i<classroomList.size(); i++) {
            university.coursesOfClassroom(classroomList.get(i));
        }
     
        /*System.out.println("-----------------------------------------------------------------------------------------------------");

        LinkedList<Teacher> teacherList = university.getTeachersClass();
        for(int i=0; i<teacherList.size(); i++) {
            university.studentsOfTeacher(teacherList.get(i));
        }*/
    }
}