public class TestingInheritance {
    public static void main(String[] args) {
        Vector v = new Vector(3);
        v.set(0, 1);
        v.set(1, 2);
        v.set(2, 3);

        v.print();
        v.zero();
        v.print();
    }
}
