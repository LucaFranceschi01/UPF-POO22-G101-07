public class AudioBuffer extends Vector {

    // In the constructor we call the superclass Vector to create the instance of AudioBuffer.
    public AudioBuffer(int dim) {
        super(dim);
    }
    
    /**
     * We change the volume of the AudioBuffer by multiplying it by an input scalar.
     * @param s The scalar we want to multiply the volume by.
     */
    public void changeVolume(double s) {
        setArray(multiply(s));  
    }
}
