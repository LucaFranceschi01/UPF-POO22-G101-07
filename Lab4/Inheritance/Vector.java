import java.util.ArrayList;

public class Vector {
    private ArrayList<Double> values;
    private int dimension;

    public Vector(int dim) {
        values = new ArrayList<Double>();
        // values = new ArrayList<Double>(Collections.nCopies(dim, null));
        for (int i = 0; i < dim; i++) {
            values.add(null);
        }
        dimension = dim;
    }

    public int getDimension() {
        return dimension;
    }

    public void set(int i, double val) {
        values.set(i, val);
    }

    public double get(int i) {
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
        return null;                    // if not the same lenght, sum will be null
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
        if(getDimension() == m.getRows()) {
            for(int i = 0; i < getDimension(); i++) {
                m.getVectors().get(i).multiply(get(0));  //check these 2 lines, not sure
                set(i, m.getVectors().get(i).sumElements());
            }
        }
    }
}