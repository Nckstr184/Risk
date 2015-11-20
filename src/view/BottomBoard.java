package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class BottomBoard extends JPanel {

	
	BufferedImage bottomBoard;

	public BottomBoard(){

		
		this.setSize(1920,400);
		this.setLocation(-320,415);
		
		
		
		try {
			bottomBoard = ImageIO.read(new File("./Pictures/gui1.png"));
			JLabel picLabel = new JLabel(new ImageIcon(bottomBoard));
			System.out.println("got piclabel");
			
			picLabel.setSize(1920, 400);
			picLabel.setLocation(0, 0);
			System.out.println("set piclabel");
			
			
			this.setLayout(null);
			add(picLabel);
			System.out.println("add piclabel");
			
			
		} catch (IOException e) {
			System.out.println("ERROR with map");
			e.printStackTrace();
		}
		
		
	}
}
