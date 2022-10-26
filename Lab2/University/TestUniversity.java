public class TestUniversity {
    public static void main(String[] args) {
        University university = new University();
        System.out.println(university.getStudents());
        System.out.println(university.getTeachers());
        System.out.println(university.getClassrooms());
        System.out.println(university.getCourses());

        /*System.out.println("--------------------------------------------------");

        LinkedList<Teacher> teachers = university.getStudentsClass();

        for(int i=0; i<teachers.size(); i++){
            System.out.printf("%s [", teachers.get(i).getName());

            LinkedList<Assignment> ass = teachers.get(i).getAssignments();
            for(int j=0; j<ass.size(); j++){
                System.out.printf("[%s %s]", ass.get(j).getCourse(), teachers.get(i).getAssignments().get(j));
            }
            System.out.println("]");
        }*/
    }
}