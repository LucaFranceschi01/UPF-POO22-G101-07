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
	ColorFrame LenaColorFrame;
	BWFrame LenaBWFrame;

  	public LenaGUI() {

		try {
			//Reading the image and passing it to Frame class
			File input = new File("Inheritance/img/Color_Lena.png");
			BufferedImage Lena = ImageIO.read(input);

			LenaColorFrame = new ColorFrame(Lena);
			LenaBWFrame = LenaColorFrame.toBWFrame();

			//Set the initial window conditions
			setLayout(null);
			setBounds(0,0,1500,800);
			setTitle("Lena GUI");
			setResizable(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);

			//Change the window icon
			ImageIcon logo = new ImageIcon(Lena);
			setIconImage(logo.getImage());

            Font smallFont = new Font("MV Boli", Font.PLAIN, 12);
            Font bigFont = new Font("MV Boli", Font.PLAIN, 18);

			//ColorFrame Increase Brightness button
			CIB = new JButton("Increase brightness by 10%");
			CIB.setBounds(100,600,200,30);
            genericButton(CIB, smallFont);
			

			//ColorFrame Decrease Brightness buttons
			CDB = new JButton("Decrease brightness by 10%");
			CDB.setBounds(450,600,200,30);
			genericButton(CDB, smallFont);

			//Label with ColorFrame of the Image
			ColorFrame = new JLabel();
			ColorFrame.setText("Lena ColorFrame");
			ColorFrame.setIcon(new ImageIcon(LenaColorFrame.getImageFromFrame()));
			ColorFrame.setBounds(250, 100, 400, 400);
			genericLabel(ColorFrame, bigFont);

			//Add the buttons and labels
			add(ColorFrame);
			add(CIB);
			add(CDB);

			//BW Increase Brightness button
			BWIB = new JButton("Increase brightness by 10%");
			BWIB.setBounds(850,600,200,30);
			genericButton(BWIB, smallFont);

			//BW Decrease Brightness button
			BWDB = new JButton("Decrease brightness by 10%");
			BWDB.setBounds(1200,600,200,30);
			genericButton(BWDB, smallFont);

			//Label with BWFrame of the image
			BWFrame = new JLabel();
			BWFrame.setText("Lena BWFrame");
			BWFrame.setIcon(new ImageIcon(LenaBWFrame.getImageFromFrame()));
			BWFrame.setBounds(1000, 100, 400, 400);
			genericLabel(BWFrame, bigFont);

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
			LenaColorFrame.changeBrightness(0.1);
			ColorFrame.setIcon(new ImageIcon(LenaColorFrame.getImageFromFrame()));
		}
		if (e.getSource() == CDB) {
			LenaColorFrame.changeBrightness(-0.1);
			ColorFrame.setIcon(new ImageIcon(LenaColorFrame.getImageFromFrame()));
		}
	}

    public void genericButton(JButton b, Font f) {
        b.setFont(f);
        b.setForeground(Color.black);
        b.setBackground(Color.lightGray);
        b.setBorder(BorderFactory.createEtchedBorder());
        b.addActionListener(this);
    }

    public void genericLabel (JLabel l, Font f) {
        l.setHorizontalTextPosition(JLabel.CENTER);
        l.setVerticalTextPosition(JLabel.TOP);
        l.setFont(f);
        l.setIconTextGap(20);
    }
}