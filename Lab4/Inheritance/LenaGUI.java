import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class LenaGUI extends JFrame implements ActionListener{

  private JButton BWIB, BWDB, CIB, CDB;
  private JLabel BWFrame, ColorFrame;
  ColorFrame LenaCFrame;
  BWFrame LenaBWFrame;

  public LenaGUI() {
    
    try {
      //Reading the image and passing it to Frame class
      File input = new File("Inheritance/img/Color_Lena.png");
      BufferedImage Lena = ImageIO.read(input);
  
      LenaCFrame = new ColorFrame(Lena);
      LenaBWFrame = LenaCFrame.toBWFrame();
  
      //Set the initial window conditions
      setLayout(null);
      setBounds(0,0,1500,800);
      setTitle("Lena GUI");
      setResizable(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      //Change the window icon
      ImageIcon logo = new ImageIcon("Inheritance/img/Color_Lena.png");
      setIconImage(logo.getImage());
      
      //C Increase Brightness button
      CIB = new JButton("Increase brightness by 10%");
      CIB.setBounds(100,600,200,30);
      CIB.setFont(new Font("MV Boli", Font.PLAIN, 12));
      CIB.setForeground(Color.black);
      CIB.setBackground(Color.lightGray);
      CIB.setBorder(BorderFactory.createEtchedBorder());
      CIB.addActionListener(this);
      
      //C Decrease Brightness button
      CDB = new JButton("Decrease brightness by 10%");
      CDB.setBounds(450,600,200,30);
      CDB.setFont(new Font("MV Boli", Font.PLAIN, 12));
      CDB.setForeground(Color.black);
      CDB.setBackground(Color.lightGray);
      CDB.setBorder(BorderFactory.createEtchedBorder());
      CDB.addActionListener(this);

      //Label with ColorFrame of the Image
      ColorFrame = new JLabel();
      ColorFrame.setText("Lena ColorFrame");
      ColorFrame.setIcon(new ImageIcon(LenaCFrame.getImageFromFrame()));
      ColorFrame.setHorizontalTextPosition(JLabel.CENTER);
      ColorFrame.setVerticalTextPosition(JLabel.TOP);
      ColorFrame.setFont(new Font("MV Boli", Font.PLAIN, 18));
      ColorFrame.setIconTextGap(20);
      ColorFrame.setBounds(250, 100, 400, 400);
  
      //Add the buttons and labels
      add(ColorFrame);
      add(CIB);
      add(CDB);
      
      //BW Increase Brightness button
      BWIB = new JButton("Increase brightness by 10%");
      BWIB.setBounds(850,600,200,30);
      BWIB.setFont(new Font("MV Boli", Font.PLAIN, 12));
      BWIB.setForeground(Color.black);
      BWIB.setBackground(Color.lightGray);
      BWIB.setBorder(BorderFactory.createEtchedBorder());
      BWIB.addActionListener(this);
      
      //BW Decrease Brightness button
      BWDB = new JButton("Decrease brightness by 10%");
      BWDB.setBounds(1200,600,200,30);
      BWDB.setFont(new Font("MV Boli", Font.PLAIN, 12));
      BWDB.setForeground(Color.black);
      BWDB.setBackground(Color.lightGray);
      BWDB.setBorder(BorderFactory.createEtchedBorder());
      BWDB.addActionListener(this);

      //Label with BWFrame of the image
      BWFrame = new JLabel();
      BWFrame.setText("Lena BWFrame");
      BWFrame.setIcon(new ImageIcon(LenaBWFrame.getImageFromFrame()));
      BWFrame.setHorizontalTextPosition(JLabel.CENTER);
      BWFrame.setVerticalTextPosition(JLabel.TOP);
      BWFrame.setFont(new Font("MV Boli", Font.PLAIN, 18));
      BWFrame.setIconTextGap(20);
      BWFrame.setBounds(1000, 100, 400, 400);
  
      //Add the buttons and labels
      add(BWIB);
      add(BWDB);
      add(BWFrame);

      //Show window
      setVisible(true);
    } catch (IOException e) {}
  }

@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == BWIB) {
      LenaBWFrame.changeBrightness(0.1);
      BWFrame.setIcon(new ImageIcon(LenaBWFrame.getImageFromFrame()));
      }
    if (e.getSource() == BWDB) {
      LenaBWFrame.changeBrightness(-0.1);
      BWFrame.setIcon(new ImageIcon(LenaBWFrame.getImageFromFrame()));
      }
    if (e.getSource() == CIB) {
        LenaCFrame.changeBrightness(0.1);
        ColorFrame.setIcon(new ImageIcon(LenaCFrame.getImageFromFrame()));
      }
    if (e.getSource() == CDB) {
      LenaCFrame.changeBrightness(-0.1);
        ColorFrame.setIcon(new ImageIcon(LenaCFrame.getImageFromFrame()));
      }
}
}
