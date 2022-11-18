public class AudioBuffer extends Vector {

    public AudioBuffer(int dim) {
        super(dim);
    }
    
    public void changeVolume(double s) {
        setArray(multiply(s));
    }

    // in seminar: minMax, smooth and sumAudioBuffer methods
}
