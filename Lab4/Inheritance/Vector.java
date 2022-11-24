import java.util.ArrayList;

public class Vector {
    private ArrayList<Double> values;
    private int dimension;

    /**
     * Create a new instance of Vector class with dimension dim.
     * @param dim The dimension of the vector (i.e. number of values it contains).
     */
    public Vector(int dim) {
        values = new ArrayList<Double>();
        // values = new ArrayList<Double>(Collections.nCopies(dim, null));      --> another approach for it
        for (int i = 0; i < dim; i++) {
            values.add(0.0);
        }
        dimension = dim;
    }

    // Getter for dimension
    public int getDimension() {
        return dimension;
    }

    /**
     * Sets the values of the Vector to the values of Vector received as parameter.
     * @param v Vector with the values we want to put in the Vector who calls the method.
     */
    public void setArray(Vector v) {
        values = v.getArray();
    }

    // Getter for the values of the vector as an array list of doubles
    public ArrayList<Double> getArray() {
        return values;
    }

    /**
     * Sets the value of the Vector by the value introduced as parameter in the position introduced as parameter.
     * @param i The index where we want to store the value in the Vector.
     * @param val The value we want to put in the position desired.
     */
    public void set(int i, double val) {
        values.set(i, val);
    }

    /**
     * Gets the value of the element in the position introduced as parameter.
     * @param i The index we want to get the value from.
     * @return The value of that element of the Vector as a double.
     */
    public double get(int i) {
        return values.get(i);
    }

    /**
     * Multiplies the Vector by a scalar quantity (double) and returns a new Vector with the result of the multiplication.
     * @param s The value we want to multiply each element of the vectoy by.
     * @return A new matrix with the result of the multiplication.
     */
    public Vector multiply(double s) {
        Vector v = new Vector(getDimension());
        for(int i=0; i<dimension; i++) {
            v.set(i, get(i)*s);
        }
        return v;
    }

    // Sets all the values of a Vector to 0.0
    public void zero() {
        for(int i=0; i<dimension; i++) {
            set(i, 0.0);
        }
    }

    // Returns the sum of all the values inside the Vector
    public double sumElements() {
        double counter = 0;
        for(int i=0; i<dimension; i++) {
            counter += get(i);
        }
        return counter;
    }

    /**
     * Computes the sum of the Vector and the Vector introduced as parameter if possible, and returns a new Vector with the result.
     * @param v The Vector we want to add to our Vector.
     * @return A new Vector with the result of the sum if the Vectors have the same dimension, null otherwise.
     */
    public Vector vectorSum(Vector v) {
        if(getDimension() == v.getDimension()) {
            Vector sum = new Vector(getDimension());
            for(int i=0; i<dimension; i++) {
                sum.set(i, get(i)+v.get(i));
            }
            return sum;
        }
        return null;
    }

    /**
     * Prints to the Console the values of the Vector alongside with the text introduced as parameter, if any.
     * @param text The text we want to print before the values of the Vector.
     */
    public void print(String text) {
        if (text != null) {
            System.out.println(text);
            System.out.println(values.toString());
            System.out.println();
        } else {
            System.out.println(values.toString());
        }

    }

    /**
     * Sets the values of the Vector to the values introduced as parameters if the dimension of the Vector equals 3.
     * @param a Value we want to store in position 0.
     * @param b Value we want to store in position 1.
     * @param c Value we want to store in position 2.
     */
    public void set3D(double a, double b, double c) {
        if(dimension == 3) {
            set(0, a);
            set(1, b);
            set(2, c);
        }
    }


    /**
     * Multiplies the Vector by a Matrix introduced as parameter, and changes the values of the Vector accordingly.
     * @param m The Matrix we want to multiply our Vector by.
     */
    public void matrixMultiply(Matrix m) {
        if(dimension == m.getRows()) {
            Vector out = new Vector(dimension);
            for(int i = 0; i < dimension; i++) {
                Vector v = m.getVectors().get(i);
                v = multiplyElements(v);
                out.set(i, v.sumElements()); // problem
            }
            values = out.getArray();
        }
    }

    /**
     * Multiplies the values of the Vector by the values of the input Vector if possible, and returns the result Vector, if possible.
     * @param v The Vector we want to multiply our Vector by.
     * @return The resulting Vector if dimensions are equal, null otherwise.
     */
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