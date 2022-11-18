public class TestInheritance {
    public static void main(String[] args) {
        
        // Testing for Vector
        Vector v = new Vector(3);
        v.set(0, 1);
        v.set(1, 2);
        v.set(2, 3);

        v.print();
        System.out.println();
        v.zero();
        v.print();
        System.out.println();

        // Testing for Matrix
        Matrix m = new Matrix(2, 2);
        m.set(0, 0, 1);
        m.set(0, 1, 0);
        m.set(1, 0, 0);
        m.set(1, 1, 1);

        m.print();
        System.out.println();
        m.zero();
        m.print();
        System.out.println();

        // Testing for Rotation Matrix
        Vector v2 = new Vector(3);
        v2.set3D(1, 0, 0);

        Matrix m2 = new Matrix(3, 3);
        m2.create3DRotationZ(Math.PI/2);

        v2.print();
        System.out.println();
        m2.print();
        System.out.println();
        v2.matrixMultiply(m2);
        v2.print();
        System.out.println();
    }
}
