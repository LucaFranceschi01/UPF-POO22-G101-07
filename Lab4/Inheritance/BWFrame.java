import java.awt.image.BufferedImage;
import java.awt.Color;

public class BWFrame extends Frame{
    // in this class, values will range between [0-255], meaning [white, black]
    // i think we'll need to use integer numbers and not doubles for that   
    // changeBrightness will change those values but will never exceed the range
    public BWFrame(int n, int m) {
        super(n, m);
    }

    public BWFrame(BufferedImage image) {
        super(image.getHeight(), image.getWidth());
        for(int i=0; i<image.getHeight(); i++) {
            for(int j=0; j<image.getWidth(); j++) {
                set(i, j, image.getRGB(i, j));
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
    }

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
        return image;
    }
    
    // in lab design: constructor, get, set, and cangeBrightness
}
