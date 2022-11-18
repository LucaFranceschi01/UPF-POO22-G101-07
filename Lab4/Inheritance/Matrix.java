import java.util.ArrayList;
public class Matrix {
    private ArrayList<Vector> vectors;
    private int rows;
    private int cols;

    public Matrix(int n, int m) {
        vectors = new ArrayList<Vector>();
        rows = n;
        cols = m;
        for (int i = 0; i < n; i++) {
            Vector v = new Vector(m);
            vectors.add(v);
        }
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
        Matrix mult = new Matrix(rows, cols);
        int idx = 0;
        for(Vector v : vectors) {
            mult.setVector(idx, v.multiply(s));
            idx++;
        }
        return mult;
    }

    public void setVector(int idx, Vector v) {
        for (int i = 0; i < cols; i++) {
            vectors.get(idx).set(i, v.get(i));
        }
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

    public void create3DRotationZ(double val) { // this value in radians
        if(rows == 3 && cols == 3) {
            vectors.get(0).set3D(Math.round(Math.cos(val)), Math.round(-Math.sin(val)), 0);
            vectors.get(1).set3D(Math.round(Math.sin(val)), Math.round(Math.cos(val)), 0);
            vectors.get(2).set3D(0, 0, 1);
        }
    }

    public ArrayList<Vector> getVectors() {
        return vectors;
    }
}