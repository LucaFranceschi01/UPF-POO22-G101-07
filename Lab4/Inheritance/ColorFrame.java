import java.awt.image.BufferedImage;
import java.awt.Color;

public class ColorFrame extends Frame {
    // in this class, values of rgb will range fom 0-255. Before changing them, we need to ensure that the values are in the range
    public ColorFrame(int n, int m) {
        super(n, m);
    }

    public ColorFrame(BufferedImage image) {
        super(image.getHeight(), image.getWidth());
        for(int i=0; i<image.getHeight(); i++) {
            for(int j=0; j<image.getWidth(); j++) {
                set(i, j, image.getRGB(i, j));
            }
        }
    }

    @Override
    public void changeBrightness(double delta) {
        for(Vector v : getVectors()) {
            for(int i = 0; i<v.getDimension(); i++) {
                int[] rgb = valToRGB(v.get(i));
                rgb[0] = (int) min(255, rgb[0] + 255*delta);
                rgb[1] = (int) min(255, rgb[1] + 255*delta);
                rgb[2] = (int) min(255, rgb[2] + 255*delta);
                v.set(i, RGBToVal(rgb));
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
        return image;    }

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
    
    private int[] valToRGB(double rgb) {
        int[] ret = new int[3];
        ret[0] = ((int) rgb >> 16) & 255;
        ret[1] = ((int) rgb >> 8) & 255;
        ret[2] = ((int) rgb) & 255;
        return ret;
    }

    private double RGBToVal(int[] rgb) {
        double ret = (rgb[0] << 16) | (rgb[1] << 8) | rgb[2];
        return ret;
    }

    public BWFrame toBWFrame() { // hacer bien porque lo hace con otros rangos
        BWFrame newBWFrame = new BWFrame(getRows(), getCols());
        for(int i=0; i<getRows(); i++) {
            for(int j=0; j<getCols(); j++) {
                int p = (int)get(i, j); // ponerlo en funcion de nuestros metodos
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;
                int grayscale = (int) (0.21*r + 0.72*g + 0.07*b);
                newBWFrame.set(i, j, grayscale);
            }
        }
        return newBWFrame;
    }

    // in lab also: constructor, set, get, changeBrighness and changeRGB
}
