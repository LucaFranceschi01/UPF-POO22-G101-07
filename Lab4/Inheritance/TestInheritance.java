import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.Component;
import java.awt.Container;

import javax.swing.*;

public class TestInheritance extends JPanel{

    private static JFrame jframe;
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
        BWFrame bwFrame = new BWFrame(20, 20);
        bwFrame.print("Full black");

        createWindow();

        BufferedImage image1 = bwFrame.getImageFromFrame();
        showImage(image1);

        addButton("Button2");

        bwFrame.changeBrightness(0.2);
        bwFrame.print("Shouldn't be full black");
        BufferedImage image2 = bwFrame.getImageFromFrame();
        showImage(image2);

        addText("what is going on");
        System.out.println("finished");
    }

    private static void createWindow() {
        jframe = new JFrame("Testing Frames");
        jframe.setPreferredSize(new Dimension(400, 400));
        jframe.getContentPane().setLayout(new BoxLayout(jframe.getContentPane(), BoxLayout.PAGE_AXIS));

        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.pack();
        jframe.setVisible(true);
    }

    private static void showImage(BufferedImage im) {
        JLabel jLabel = new JLabel(new ImageIcon(im));
        jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jframe.getContentPane().add(jLabel);
        jframe.setVisible(true);
    }

    private static void addButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        jframe.getContentPane().add(button);
        jframe.setVisible(true);

    }

    private static void addText(String text) {
        JLabel jLabel = new JLabel(text);
        jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jframe.getContentPane().add(jLabel);
        jframe.setVisible(true);

    }
}
