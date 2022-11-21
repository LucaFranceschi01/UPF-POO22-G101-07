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
    
    // in lab design: constructor, get, set, and cangeBrightness
}
