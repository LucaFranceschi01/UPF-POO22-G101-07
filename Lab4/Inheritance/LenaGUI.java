import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.Component;
import javax.swing.*;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LenaGUI extends JPanel {

    private static JFrame jframe; // no se si hace falta
    private TestInheritance test;

    public LenaGUI() {
        createWindow();

        try {
            File input = new File("Inheritance/img/Color_Lena.png");
            BufferedImage lena = ImageIO.read(input);

            ColorFrame colorlenaframe = new ColorFrame(lena);
            BWFrame graylenaframe = colorlenaframe.toBWFrame();

            showImage(colorlenaframe.getImageFromFrame());
            colorlenaframe.changeBrightness(-0.5);
            showImage(colorlenaframe.getImageFromFrame());

            showImage(graylenaframe.getImageFromFrame());
            graylenaframe.changeBrightness(-0.5);
            showImage(graylenaframe.getImageFromFrame());

        } catch (IOException e) {}
        System.out.println("finished");
    }

    private static void createWindow() {
        jframe = new JFrame("Testing Frames");
        jframe.setPreferredSize(new Dimension(400, 600));
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
