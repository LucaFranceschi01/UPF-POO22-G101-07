import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class BWFrame extends Frame{
    // in this class, values will range between [0-255], meaning [white, black]
    // i think we'll need to use integer numbers and not doubles for that   
    // changeBrightness will change those values but will never exceed the range
    public BWFrame(int n, int m) {
        super(n, m);
    }

    @Override
    public void changeBrightness(double delta) { // comment in pdf
        for(Vector v : getVectors()) {
            for(int i = 0; i<v.getDimension(); i++) {
                v.set(i, min(255, v.get(i) + (255*delta))); // does increase or decrease brighness??
            }
        }
    }

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
    
    // in lab design: constructor, get, set, and cangeBrightness
}
