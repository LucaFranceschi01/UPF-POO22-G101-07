import java.nio.ByteBuffer;

public class AudioBuffer extends Vector {

    // In the constructor we call the superclass Vector to create the instance of AudioBuffer.
    public AudioBuffer(int dim) {
        super(dim);
    }

    public AudioBuffer(Double[] arr) {
        super(arr.length);
        Vector v = new Vector(getDimension());
        for (int i=0; i<getDimension(); i++) {
            v.set(i, arr[i]);
        }
    }
    
    /**
     * We change the volume of the AudioBuffer by multiplying it by an input scalar.
     * @param s The scalar we want to multiply the volume by.
     */
    public void changeVolume(double s) {
        setArray(multiply(s));  
    }

    public static byte[] toByteArray(Double[] doubleArray){
        int times = Double.SIZE / Byte.SIZE;
        byte[] bytes = new byte[doubleArray.length * times];
        for(int i=0;i<doubleArray.length;i++){
            ByteBuffer.wrap(bytes, i*times, times).putDouble(doubleArray[i]);
        }
        return bytes;
    }
    
    public static Double[] toDoubleArray(byte[] byteArray){
        int times = Double.SIZE / Byte.SIZE;
        Double[] doubles = new Double[byteArray.length / times];
        for(int i=0;i<doubles.length;i++){
            doubles[i] = ByteBuffer.wrap(byteArray, i*times, times).getDouble();
        }
        return doubles;
    }
}