package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.PlayerCollection;



public class BottomBoard extends JPanel {

	
	BufferedImage bottomBoard;
	PlayerCollection playerList;

	public BottomBoard(){

		
		this.setSize(1920,400);
		this.setLocation(0,550);
		
		
		
		try {
			bottomBoard = ImageIO.read(new File("./Pictures/gui1.png"));
			JLabel picLabel = new JLabel(new ImageIcon(bottomBoard));
			add(picLabel);
			
			this.setSize(1920, 400);
			this.setLocation(0, 550);
			this.setLayout(null);
			
			
		} catch (IOException e) {
			System.out.println("ERROR with map");
			e.printStackTrace();
		}
		
		
		
	}
}
