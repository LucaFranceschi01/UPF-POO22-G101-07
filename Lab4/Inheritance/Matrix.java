import java.util.ArrayList;
public class Matrix {
    private ArrayList<Vector> vectors;
    private int rows;
    private int cols;

    public Matrix(int n, int m) {
        vectors = new ArrayList<Vector>();
        for (int i = 0; i < n; i++) {
            Vector v = new Vector(m);
            vectors.add(v);
        }
        rows = n;
        cols = m;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void set(int i, int j, double val) {
        vectors.get(i).set(j, val);
    }

    public double get(int i, int j) {
        return vectors.get(i).get(j);
    }

    public Matrix multiply(double s) {
        Matrix mult = new Matrix(getRows(), getCols());
        int idx = 0;
        for(Vector v : vectors) {
            mult.setVector(v.multiply(s), idx);
            idx++;
        }
        return mult;
    }

    public void print() {
        for(Vector v : vectors) {
            v.print();
        }
    }

    public void zero() {
        for(Vector v : vectors) {
            v.zero();
        }
    }

    public void create3DRotationZ(double val) {
        if(rows == 3 && cols == 3) {
            vectors.get(0).set3D(Math.cos(val), -Math.sin(val), 0);
            vectors.get(0).set3D(Math.sin(val), Math.cos(val), 0);
            vectors.get(0).set3D(0, 0, 1);
        }
    }

    public ArrayList<Vector> getVectors() {
        return vectors;
    }

    public void setVector(Vector v, int idx) {
        for (int i = 0; i < getCols(); i++) {
            vectors.get(idx).set(i, v.get(i));
        }
    }
}
