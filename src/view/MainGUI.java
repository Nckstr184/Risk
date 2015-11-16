package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.swing.WindowConstants;



public class MainGUI extends JFrame {
	
	GameBoard map;
	JPanel bottomDisplay, sideDisplay;
	JTextField updateDisplay;
	JButton toggleSound, quitGame, saveGame;
	
	
	
	public static void main(String[] args) {
		MainGUI window = new MainGUI();
		window.setVisible(true);
		
	}

	public MainGUI() {
		GameBoard map = new GameBoard();
		JPanel bottomeDisplay = new JPanel();
		JPanel sideDisplay = new JPanel();
		
		bottomDisplay.setSize(1000,200);
		bottomDisplay.setLocation(0,800);
		bottomDisplay.setBackground(Color.RED);
		
		Dimension sizeMe = Toolkit.getDefaultToolkit().getScreenSize();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(sizeMe);
		this.setLayout(null);
		ImageIcon C1T1= new ImageIcon("./Pictures/circle.png");
		JButton nbt= new JButton(C1T1);
		
//		GameBoard panel = new GameBoard((new ImageIcon("images/background.png").getImage()));
//		panel.setLocation(300, 10);
//	    panel.setSize(500,500);
//	    this.add(panel);
//	    panel.setVisible(true);
//	    
		
		
     // nbt.setBackground(Color.BLUE);
      nbt.setSize(25, 25);
      nbt.setLocation(680, 150);
      nbt.setOpaque(false);
      nbt.setContentAreaFilled(false);
      nbt.setBorderPainted(false);
      this.add(nbt);
      nbt.setVisible(true);
      this.add(map);
      this.add(bottomDisplay);
		
	        
	    }
		
		
		
	}
	


