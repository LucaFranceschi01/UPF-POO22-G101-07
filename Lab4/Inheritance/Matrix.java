import java.util.ArrayList;
public class Matrix {
    private ArrayList<Vector> vectors;
    private int rows;
    private int cols;

    /**
     * Constructor for an instance of Matrix. It creates an ArrayList of Vectors of dimensions n and m and initializes values to 0.
     * @param n The desired rows of the Matrix.
     * @param m The desired columns of the Matrix.
     */
    public Matrix(int n, int m) {
        vectors = new ArrayList<Vector>();
        rows = n;
        cols = m;
        for (int i = 0; i < n; i++) {
            Vector v = new Vector(m);
            vectors.add(v);
        }
    }

    // Getter for the number of rows
    public int getRows() {
        return rows;
    }

    // Getter for the number of columns
    public int getCols() {
        return cols;
    }

    /**
     * Sets the element of the Matrix at position (i,j) where i corresponds to row and j to column, to the value introduced as parameter.
     * @param i The row of the element we want to access.
     * @param j The column of the element we want to access.
     * @param val The value we want to store in the position (i,j) of the Matrix.
     */
    public void set(int i, int j, double val) {
        vectors.get(i).set(j, val);
    }

    /**
     * Gets the value of the element in of position (i,j) of the Matrix.
     * @param i The row of the element we want to access.
     * @param j The column of the element we want to access.
     * @return The value in position (i,j) of the Matrix as a double.
     */
    public double get(int i, int j) {
        return vectors.get(i).get(j);
    }

    /**
     * Multiplies all the values of the Matrix by an input value, and returns a new instance with the result.
     * @param s The value we want to multiply all elements of the Matrix by.
     * @return A new Matrix with the result.
     */
    public Matrix multiply(double s) {
        Matrix mult = new Matrix(rows, cols);
        int idx = 0;
        for(Vector v : vectors) {
            mult.setVector(idx, v.multiply(s));
            idx++;
        }
        return mult;
    }

    /**
     * Sets the Vector in position i of the Matrix as the Vector introduced as parameter.
     * @param idx The index of the Vector we want to change inside the Matrix.
     * @param v The Vector with the values we want to put in the Matrix.
     */
    public void setVector(int idx, Vector v) {
        for (int i = 0; i < cols; i++) {
            vectors.get(idx).set(i, v.get(i));
        }
    }

    /**
     * Prints to the Console the values of the Matrix alongside with the text introduced as parameter, if any.
     * @param text The text we want to print before the values of the Matrix.
     */
    public void print(String text) {
        System.out.println(text);
        for(Vector v : vectors) {
            v.print(null);
        }
        System.out.println();
    }

    // Sets all values of the Matrix to 0.0
    public void zero() {
        for(Vector v : vectors) {
            v.zero();
        }
    }

    /**
     * Sets the values of the elements in the Matrix to specific numbers depending on the value in radians introduced as parameter.
     * It will only work if the Matrix is a 3x3 (n and m equal to 3).
     * @param val The angle in radians we want to create the RotationZ Matrix for.
     */
    public void create3DRotationZ(double val) { // this value in radians
        if(rows == 3 && cols == 3) {
            vectors.get(0).set3D(Math.round(Math.cos(val)), Math.round(-Math.sin(val)), 0);
            vectors.get(1).set3D(Math.round(Math.sin(val)), Math.round(Math.cos(val)), 0);
            vectors.get(2).set3D(0, 0, 1);
        }
    }

    // Getter for the ArrayList of Vectors of the Matrix.
    public ArrayList<Vector> getVectors() {
        return vectors;
    }
}