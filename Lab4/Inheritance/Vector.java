import java.util.ArrayList;

public class Vector {
    private ArrayList<Double> values;
    private int dimension;

    public Vector(int dim) {        // this way works, we'll try mf luca's way later
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

    public void multiply(double s) { // same
        for(int i=0; i<dimension; i++) {
            set(i, get(i)*s);
        }
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

    public void vectorSum(Vector v) { // can be done returning instead of setting
        if(getDimension() == v.getDimension()) {
            for(int i=0; i<dimension; i++) {
                set(i, get(i)+v.get(i));
            }
        }
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

    public void matrixMultiply(Matrix m) {        // modifica la matrix, not so good
        if(getDimension() == m.getRows()) {
            for(int i = 0; i < getDimension(); i++) {
                m.getVectors().get(i).multiply(get(0));
                set(i, m.getVectors().get(i).sumElements());
            }
        }
    }
}