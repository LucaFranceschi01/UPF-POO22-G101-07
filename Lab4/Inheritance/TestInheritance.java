import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TestInheritance{

    public static void main(String[] args) {
        
        System.out.println("---------- Testing a simple Vector ----------");
        Vector v = new Vector(3);
        v.set(0, 1);
        v.set(1, 2);
        v.set(2, 3);

        v.print("A simple vector:");
        v.zero();
        v.print("Now we set it to a zero vector:");
        
        System.out.println("---------- Testing a simple Matrix ----------");
        Matrix m = new Matrix(2, 2);
        m.set(0, 0, 1);
        m.set(0, 1, 0);
        m.set(1, 0, 0);
        m.set(1, 1, 1);

        m.print("A simple matrix:");
        m.zero();
        m.print("Now we set it to a zero matrix:");
        

        // Testing for Rotation Matrix
        Vector v2 = new Vector(3);
        v2.set3D(1, 0, 0);

        Matrix m2 = new Matrix(3, 3);
        m2.create3DRotationZ(Math.PI/2);

        System.out.println("---------- Testing the 3D Rotation Z ----------");
        v2.print("The vector:");
        m2.print("The matrix:");
        
        v2.matrixMultiply(m2);
        v2.print("The result:");

        System.out.println("---------- Testing BWFrame ----------");

        new LenaGUI();
    }
}
