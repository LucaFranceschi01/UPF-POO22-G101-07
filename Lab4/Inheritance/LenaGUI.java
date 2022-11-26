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
    private JButton IR, IG, IB, DR, DG, DB;
	private JLabel BWFrame, ColorFrame;
	private ColorFrame LenaColorFrame;
	private BWFrame LenaBWFrame;

  	public LenaGUI() {

		try {
			//Reading the image and passing it to Frame class
			File input = new File("Inheritance/img/Color_Lena.png");
			BufferedImage Lena = ImageIO.read(input);

			LenaColorFrame = new ColorFrame(Lena);
			LenaBWFrame = LenaColorFrame.toBWFrame();

			//Set the initial window conditions
			setLayout(null);
			setBounds(0,0,855,700);
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
			ColorFrame.setText("Lena ColorFrame");
			ColorFrame.setIcon(new ImageIcon(LenaColorFrame.getImageFromFrame()));
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

			//Label with BWFrame of the image
			BWFrame = new JLabel();
			BWFrame.setText("Lena BWFrame");
			BWFrame.setIcon(new ImageIcon(LenaBWFrame.getImageFromFrame()));
			BWFrame.setBounds(500, 50, 255, 300);
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
        if (e.getSource() == IR) {
			LenaColorFrame.changeRGB(0.1, 0, 0);
			ColorFrame.setIcon(new ImageIcon(LenaColorFrame.getImageFromFrame()));
		}
        if (e.getSource() == DR) {
			LenaColorFrame.changeRGB(-0.1, 0, 0);
			ColorFrame.setIcon(new ImageIcon(LenaColorFrame.getImageFromFrame()));
		}
        if (e.getSource() == IG) {
			LenaColorFrame.changeRGB(0, 0.1, 0);
			ColorFrame.setIcon(new ImageIcon(LenaColorFrame.getImageFromFrame()));
		}
        if (e.getSource() == DG) {
			LenaColorFrame.changeRGB(0, -0.1, 0);
			ColorFrame.setIcon(new ImageIcon(LenaColorFrame.getImageFromFrame()));
		}
        if (e.getSource() == IB) {
			LenaColorFrame.changeRGB(0, 0, 0.1);
			ColorFrame.setIcon(new ImageIcon(LenaColorFrame.getImageFromFrame()));
		}
        if (e.getSource() == DB) {
			LenaColorFrame.changeRGB(0, 0, -0.1);
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