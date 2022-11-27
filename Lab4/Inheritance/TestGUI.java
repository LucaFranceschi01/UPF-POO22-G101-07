import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.awt.image.BufferedImage;

public class TestGUI extends JFrame implements ActionListener{

    private JButton BWIB, BWDB, CIB, CDB;
    private JButton IR, IG, IB, DR, DG, DB;
    // private JButton PM, IV, DV;
    private JLabel BWFrame, ColorFrame;
    private ColorFrame KittenColorFrame;
    private BWFrame KittenBWFrame;
    // private AudioBuffer meow;

    public TestGUI() {

        try {
            //Reading the image and passing it to Frame class
            File inputFrame = new File("Inheritance/media/kitten-color.jpg");
            BufferedImage KittenBufferedImage = ImageIO.read(inputFrame);

            // FileInputStream inputAudio = new FileInputStream("Inheritance/media/meow.wav");
            // meow = new AudioBuffer(AudioBuffer.toDoubleArray(inputAudio.readAllBytes()));

            KittenColorFrame = new ColorFrame(KittenBufferedImage);
            KittenBWFrame = KittenColorFrame.toBWFrame();

            //Set the initial window conditions
            setLayout(null);
            setBounds(0,0,855,700);
            setTitle("Kitten GUI");
            setResizable(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            //Change the window icon
            ImageIcon logo = new ImageIcon(KittenBufferedImage);
            setIconImage(logo.getImage());

            Font smallFont = new Font("MV Boli", Font.PLAIN, 12);
            Font bigFont = new Font("MV Boli", Font.PLAIN, 18);

            //ColorFrame Increase Brightness button
            CIB = new JButton("Increase brightness by 10%");
            CIB.setBounds(100,400,255,30);
            genericButton(CIB, smallFont);

            //ColorFrame Decrease Brightness buttons
            CDB = new JButton("Decrease brightness by 10%");
            CDB.setBounds(100,450,255,30);
            genericButton(CDB, smallFont);

            //ColorFrame Change RGB
            IR = new JButton("+10% Red");
            IR.setBounds(100, 500, 79, 30);
            genericButton(IR, smallFont);

            DR = new JButton("-10% Red");
            DR.setBounds(100, 550, 79, 30);
            genericButton(DR, smallFont);

            IG = new JButton("+10% Green");
            IG.setBounds(188, 500, 79, 30);
            genericButton(IG, smallFont);

            DG = new JButton("-10% Green");
            DG.setBounds(188, 550, 79, 30);
            genericButton(DG, smallFont);

            IB = new JButton("+10% Blue");
            IB.setBounds(276, 500, 79, 30);
            genericButton(IB, smallFont);

            DB = new JButton("-10% Blue");
            DB.setBounds(276, 550, 79, 30);
            genericButton(DB, smallFont);

            //Label with ColorFrame of the Image
            ColorFrame = new JLabel();
            ColorFrame.setText("Kitten ColorFrame");
            ColorFrame.setIcon(new ImageIcon(KittenColorFrame.getImageFromFrame()));
            ColorFrame.setBounds(100, 50, 255, 300);
            genericLabel(ColorFrame, bigFont);

            //Add the buttons and labels
            add(ColorFrame);
            add(CIB);
            add(CDB);
            add(IR);
            add(DR);
            add(IG);
            add(DG);
            add(IB);
            add(DB);

            //BW Increase Brightness button
            BWIB = new JButton("Increase brightness by 10%");
            BWIB.setBounds(500,400,255,30);
            genericButton(BWIB, smallFont);

            //BW Decrease Brightness button
            BWDB = new JButton("Decrease brightness by 10%");
            BWDB.setBounds(500,450,255,30);
            genericButton(BWDB, smallFont);

            // PM = new JButton("Play Meow");
            // PM.setBounds(500,500,255,30);
            // genericButton(PM, smallFont);

            //Label with BWFrame of the image
            BWFrame = new JLabel();
            BWFrame.setText("Kitten BWFrame");
            BWFrame.setIcon(new ImageIcon(KittenBWFrame.getImageFromFrame()));
            BWFrame.setBounds(500, 50, 255, 300);
            genericLabel(BWFrame, bigFont);

            //Add the buttons and labels
            add(BWIB);
            add(BWDB);
            add(BWFrame);
            // add(PM);

            //Show window
            setVisible(true);
        } catch (IOException e) {}
    }


    //This method right here comes from the interface ActionListener and is the one that manages the actions after pressing buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BWIB) {
            KittenBWFrame.changeBrightness(0.1);
            BWFrame.setIcon(new ImageIcon(KittenBWFrame.getImageFromFrame()));
        }
        if (e.getSource() == BWDB) {
            KittenBWFrame.changeBrightness(-0.1);
            BWFrame.setIcon(new ImageIcon(KittenBWFrame.getImageFromFrame()));
        }
        if (e.getSource() == CIB) {
            KittenColorFrame.changeBrightness(0.1);
            ColorFrame.setIcon(new ImageIcon(KittenColorFrame.getImageFromFrame()));
        }
        if (e.getSource() == CDB) {
            KittenColorFrame.changeBrightness(-0.1);
            ColorFrame.setIcon(new ImageIcon(KittenColorFrame.getImageFromFrame()));
        }
        if (e.getSource() == IR) {
            KittenColorFrame.changeRGB(0.1, 0, 0);
            ColorFrame.setIcon(new ImageIcon(KittenColorFrame.getImageFromFrame()));
        }
        if (e.getSource() == DR) {
            KittenColorFrame.changeRGB(-0.1, 0, 0);
            ColorFrame.setIcon(new ImageIcon(KittenColorFrame.getImageFromFrame()));
        }
        if (e.getSource() == IG) {
            KittenColorFrame.changeRGB(0, 0.1, 0);
            ColorFrame.setIcon(new ImageIcon(KittenColorFrame.getImageFromFrame()));
        }
        if (e.getSource() == DG) {
            KittenColorFrame.changeRGB(0, -0.1, 0);
            ColorFrame.setIcon(new ImageIcon(KittenColorFrame.getImageFromFrame()));
        }
        if (e.getSource() == IB) {
            KittenColorFrame.changeRGB(0, 0, 0.1);
            ColorFrame.setIcon(new ImageIcon(KittenColorFrame.getImageFromFrame()));
        }
        if (e.getSource() == DB) {
            KittenColorFrame.changeRGB(0, 0, -0.1);
            ColorFrame.setIcon(new ImageIcon(KittenColorFrame.getImageFromFrame()));
        }
        /*
        if (e.getSource() == PM) {
            
            byte[] byteData = AudioBuffer.toByteArray((Double[])meow.getArray().toArray());
            
            InputStream is = new ByteArrayInputStream(byteData);
            try {
                AudioInputStream ais = AudioSystem.getAudioInputStream(is);
                Clip clip = AudioSystem.getClip();
                clip.open(ais);
                clip.start();
            } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e1) {}
            
            
            try {
                File f = new File("Inheritance/media/meow.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e1) {};
            
        }*/
    }

    /**
     * Applies the generic settings for a button from a JButton received as parameter and a Font received as parameter.
     * @param b The button we want to apply the generic settings to.
     * @param f The font we want to apply to the button.
     */
    private void genericButton(JButton b, Font f) {
        b.setFont(f);
        b.setForeground(Color.black);
        b.setBackground(Color.lightGray);
        b.setBorder(BorderFactory.createEtchedBorder());
        b.addActionListener(this);
    }

    /**
     * Applies the generic settings for a label from a JLabel received as parameter and a Font received as parameter.
     * @param l The label we want to apply the generic settings to.
     * @param f The font we want to apply to the label.
     */
    private void genericLabel (JLabel l, Font f) {
        l.setHorizontalTextPosition(JLabel.CENTER);
        l.setVerticalTextPosition(JLabel.TOP);
        l.setFont(f);
        l.setIconTextGap(20);
    }
}