import java.util.ArrayList;

public class Vector {
    private ArrayList<Double> values;
    private int dimension;

    public Vector(int dim) {
        values = new ArrayList<Double>();
        // values = new ArrayList<Double>(Collections.nCopies(dim, null));
        for (int i = 0; i < dim; i++) {
            values.add(0.0);
        }
        dimension = dim;
    }

    public int getDimension() {
        return dimension;
    }

    public void set(int i, double val) {
        values.set(i, val);
    }

    public double get(int i) { // here comes the problem??
        return values.get(i);
    }

    public Vector multiply(double s) {
        Vector v = new Vector(getDimension());
        for(int i=0; i<dimension; i++) {
            v.set(i, get(i)*s);
        }
        return v;
    }

    public void zero() {
        for(int i=0; i<dimension; i++) {
            set(i, 0);
        }
    }

    public double sumElements() {
        double counter = 0;
        for(int i=0; i<dimension; i++) {
            counter += get(i);
        }
        return counter;
    }

    public Vector vectorSum(Vector v) { // returns a new vector with the sum
        if(getDimension() == v.getDimension()) {
            Vector sum = new Vector(getDimension());
            for(int i=0; i<dimension; i++) {
                sum.set(i, get(i)+v.get(i));
            }
            return sum;
        }
        return null; // if not the same lenght, sum will be null
    }

    public void print() {
        System.out.println(values.toString());
    }

    public void set3D(double a, double b, double c) {
        if(dimension == 3) {
            set(0, a);
            set(1, b);
            set(2, c);
        }
    }

    public void matrixMultiply(Matrix m) {
        if(dimension == m.getRows()) {
            for(int i = 0; i < dimension; i++) {
                // double first = m.getVectors().get(i).get(0) * get(0);  //check these 2 lines, not sure
                // double second = m.getVectors().get(i).get(1) * get(1);  //check these 2 lines, not sure
                // double third = m.getVectors().get(i).get(2) * get(2);  //check these 2 lines, not sure
                Vector v = m.getVectors().get(i);
                v = multiplyElements(v);
                v.sumElements();
                set(i, v.sumElements());
                // set(i, first + second + third);
            }
        }
    }

    public Vector multiplyElements(Vector v) {
        if(dimension == v.getDimension()) {
            Vector out = new Vector(dimension);
            for(int i=0; i<dimension; i++) {
                out.set(i, get(i)*v.get(i));
            }
            return out;
        }
        return null;
    }
}