public class ColorFrame extends Frame {
    // in this class, values of rgb will range fom 0-255. Before changing them, we need to ensure that the values are in the range
    public ColorFrame(int n, int m) {
        super(n, m);
    }

    @Override
    public void changeBrightness(double delta) {

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

    // in lab also: constructor, set, get, changeBrighness and changeRGB
}
