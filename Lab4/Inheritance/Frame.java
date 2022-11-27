import java.awt.image.BufferedImage;

public abstract class Frame extends Matrix {

    /**
     * Creates a new instance of Frame by calling the constructor of the superclass Matrix.
     * @param n The number of rows we want the Frame to have.
     * @param m The number of columns we want the Frame to have.
     */
    protected Frame(int n, int m) {
        super(n, m);
    }
    
    // Abstract method to change the brigthness of the frame that will be overriden in each subclass.
    protected abstract void changeBrightness(double delta);
    
    // Abstract method to get the image from the frame that will be overriden in each subclass.
    protected abstract BufferedImage getImageFromFrame();

    /**
     * Method to calculate the minimum value given 2 values introduced as parameters, and return it as a double. Only accessible for subclasses.
     * @param a First value we want to check.
     * @param b Second value we want to check.
     * @return The lowest value of the two.
     */
    protected double min(double a, double b) {
        if(a<b) { return a;}
        return b;
    }

    protected double max(double a, double b) {
        if(a>b) { return a;}
        return b;
    }
}