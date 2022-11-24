import java.awt.image.BufferedImage;
import java.awt.Color;

public class ColorFrame extends Frame {
    // in this class, values of rgb will range fom 0-255. Before changing them, we need to ensure that the values are in the range
    
    /**
     * Creates an instance of ColorFrame by calling the superclass constructor. This type of Frame will be composed of values, where
     * each of the values will have inside R, G, B and A values. Each of these R, G, B, and A values will be in the range [0,255],
     * and their combinations are the different colors.
     * @param n The number of rows of the ColorFrame we want to create.
     * @param m The number of columns of the ColorFrame we want to create.
     */
    public ColorFrame(int n, int m) {
        super(n, m);
    }

    /**
     * An overloaded constructor for ColorFrame, creates the instance for the ColorFrame
     * from an instance of BufferedImage received as parameter.
     * @param image The BufferedImage instance from which we create the ColorFrame.
     */
    public ColorFrame(BufferedImage image) {
        super(image.getHeight(), image.getWidth());
        for(int i=0; i<image.getHeight(); i++) {
            for(int j=0; j<image.getWidth(); j++) {
                set(i, j, image.getRGB(i, j));
            }
        }
    }

    /**
     * Changes each value of the ColorFrame (each R, G, B value) to the minimum value of 255 (max possible value for each)
     * and the max of 0 (min possible value for each) and the current value of each R, G, B, + 255*delta.
     * This way we are increasing the brightness of the Frame, while at the same time we ensure no value of R, G, B will get out of range.
     * @param delta The value we want to increase the brightness by.
     */
    @Override
    public void changeBrightness(double delta) {
        for(Vector v : getVectors()) {
            for(int i = 0; i<v.getDimension(); i++) {
                int[] rgb = valToRGB(v.get(i));
                rgb[0] = (int) min(255, max(0, rgb[0] + 255*delta));
                rgb[1] = (int) min(255, max(0, rgb[1] + 255*delta));
                rgb[2] = (int) min(255, max(0, rgb[2] + 255*delta));
                v.set(i, RGBToVal(rgb));
            }
        }
    }

    // Returns an image as an instance of BufferedImage from the Frame
    @Override
    public BufferedImage getImageFromFrame() {
        BufferedImage image = new BufferedImage(getCols(), getRows(), BufferedImage.TYPE_INT_RGB);
        for(int i=0; i<getRows(); i++) {
            for(int j=0; j<getCols(); j++) {
                int a = (int)get(i, j);
                Color newcolor = new Color(a);
                image.setRGB(i, j, newcolor.getRGB());
            }
        }
        return image;    }

    /**
     * Changes the value of each R, G, B by the corresponding value of delta inside the array deltas received as parameter.
     * @param deltas The array with each delta value: R in deltas[0], G in deltas[1], B in deltas[2].
     */
    public void changeRGB(int[] deltas) {
        for(Vector v : getVectors()) {
            for(int i = 0; i<v.getDimension(); i++) {
                int[] rgb = valToRGB(v.get(i));
                rgb[0] = (int) min(255, rgb[0] + 255*deltas[0]);
                rgb[1] = (int) min(255, rgb[1] + 255*deltas[1]);
                rgb[2] = (int) min(255, rgb[2] + 255*deltas[2]);
                v.set(i, RGBToVal(rgb));
            }
        }
    }
    
    /**
     * Receives a value in form of double, and return the corresponding values for R, G, B in an array of integers.
     * @param rgb The value we want to convert to RGB.
     * @return An array with the R, G, B values in order.
     */
    private int[] valToRGB(double rgb) {
        int[] ret = new int[3];
        ret[0] = ((int) rgb >> 16) & 255;
        ret[1] = ((int) rgb >> 8) & 255;
        ret[2] = ((int) rgb) & 255;
        return ret;
    }

    /**
     * Receives an array of integers with the corresponding R, G, B values and converts it to a value in the form of a double.
     * @param rgb The array with the R, G, B values we want to convert.
     * @return The value of the result in form of a double.
     */
    private double RGBToVal(int[] rgb) {
        double ret = (rgb[0] << 16) | (rgb[1] << 8) | rgb[2];
        return ret;
    }

    // Creates a new instance of BWFrame from the ColorFrame and returns it.
    public BWFrame toBWFrame() {
        BWFrame newBWFrame = new BWFrame(getRows(), getCols());
        for(int i=0; i<getRows(); i++) {
            for(int j=0; j<getCols(); j++) {
                int[] rgb = valToRGB(get(i, j));
                int grayscale = (int) (0.21*rgb[0] + 0.72*rgb[1] + 0.07*rgb[2]);
                newBWFrame.set(i, j, grayscale);
            }
        }
        return newBWFrame;
    }
}
