import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class BWFrame extends Frame{
    
    /**
     * Creates an instance of BWFrame by calling the superclass constructor. This type of Frame will have values that are in the range
     * [0, 255], where 0 is white and 255 is black, and the values in between are lighter/darker versions of them.
     * @param n The number of rows of the BWFrame we want to create.
     * @param m The number of columns of the BWFrame we want to create.
     */
    public BWFrame(int n, int m) {
        super(n, m);
    }

    /**
     * Changes each value of the Frame to the minimum value between 255 (max possible value, black) 
     * and the max of the values 0 (min possible value, white) and the current value + 255*delta.
     * This way we are increasing the brightness of the Frame, while at the same time we ensure no value will get out of range [0,255].
     * @param delta The value we want to increase the brightness by.
     */
    @Override
    public void changeBrightness(double delta) {
        for(Vector v : getVectors()) {
            for(int i = 0; i<v.getDimension(); i++) {
                v.set(i, min(255, max(0, v.get(i) + (255*delta))));
            }
        }
    }

    // Returns an image as an instance of BufferedImage from the Frame
    @Override
    public BufferedImage getImageFromFrame() {
        int[] pixels = new int[getRows()*getCols()];
        for(int i=0; i<getCols(); i++) { // FLIPPED TO MATCH WRITABLERASTER WAY (FIRST COLUMNS, THEN ROWS)
            for(int j=0; j<getRows(); j++) {
                pixels[j*getRows()+i] = (int) get(i, j);
            }
        }
        BufferedImage image = new BufferedImage(getCols(), getRows(), BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = image.getRaster();
        raster.setSamples(0, 0, getCols(), getRows(), 0, pixels);

        return image;
    }
}