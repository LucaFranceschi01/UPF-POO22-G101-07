import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class BWFrame extends Frame{
    // in this class, values will range between [0-255], meaning [white, black]
    // i think we'll need to use integer numbers and not doubles for that   
    // changeBrightness will change those values but will never exceed the range
    public BWFrame(int n, int m) {
        super(n, m);
    }

    public BWFrame(BufferedImage image) { // creo que no está bien porque lo tratamos como un colorframe (rango de valores mal)
        super(image.getHeight(), image.getWidth());
        for(int i=0; i<image.getHeight(); i++) {
            for(int j=0; j<image.getWidth(); j++) {
                set(i, j, image.getRGB(i, j)); // nooooo set rgb mal hay que hacerlo con writableraster
            }
        }
    }

    @Override
    public void changeBrightness(double delta) { // comment in pdf
        for(Vector v : getVectors()) {
            for(int i = 0; i<v.getDimension(); i++) {
                v.set(i, min(255, v.get(i) + (255*delta))); // does increase or decrease brighness??
            }
        }
        /* for(Vector v : getVectors()) {
            for(int i = 0; i<v.getDimension(); i++) {
                int[] rgb = valToRGB(v.get(i));
                rgb[0] = (int) min(255, rgb[0] + 255*delta);
                rgb[1] = (int) min(255, rgb[1] + 255*delta);
                rgb[2] = (int) min(255, rgb[2] + 255*delta);
                v.set(i, RGBToVal(rgb));
            }
        }*/
    }

    @Override
    public BufferedImage getImageFromFrame() {
        int[] pixels = new int[getRows()*getCols()];
        for(int i=0; i<getRows(); i++) {
            for(int j=0; j<getCols(); j++) {
                pixels[i*getRows()+j] = (int) get(i, j);
            }
        }
        BufferedImage image = new BufferedImage(getCols(), getRows(), BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = image.getRaster();
        raster.setSamples(0, 0, getCols(), getRows(), 0, pixels);

        return image;
    }
    
    // in lab design: constructor, get, set, and cangeBrightness
}
