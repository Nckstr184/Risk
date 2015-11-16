package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import model.Player;
import model.Sun;
import model.Territory;



public class MainGUI extends JFrame {
	
	GameBoard map;
	JTextField updateDisplay;
	JButton toggleSound, quitGame, saveGame;
	String B1T1;
	
	
	
	
	public static void main(String[] args) {
		MainGUI window = new MainGUI();
		window.setVisible(true);
		
	}

	public MainGUI() {

		this.setLayout(null);


		GameBoard map = new GameBoard();

		Dimension sizeMe = Toolkit.getDefaultToolkit().getScreenSize();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(sizeMe);
		this.setLayout(null);
		ImageIcon gray1= new ImageIcon("./Pictures/circle.png");
		B1T1=new String("0");
		JLabel num= new JLabel(B1T1);
		JButton nbt= new JButton(gray1);
		nbt.addActionListener(new buttonListener());
		
//		GameBoard panel = new GameBoard((new ImageIcon("images/background.png").getImage()));
//		panel.setLocation(300, 10);
//	    panel.setSize(500,500);
//	    this.add(panel);
//	    panel.setVisible(true);
//	    
		
		
     // nbt.setBackground(Color.BLUE);

		Font font = new Font("Serif",Font.BOLD, 30);
		
      
      nbt.setSize(25, 25);
      nbt.setLocation(680, 150);

      nbt.setOpaque(false);
      nbt.setContentAreaFilled(false);
      nbt.setBorderPainted(false);
      num.setSize(50,50);
      num.setFont(font);
      num.setForeground(Color.WHITE);
      num.setLocation(118, 103);
      num.setOpaque(false);
     
     
     
      this.add(num);
      this.add(nbt);
      
      nbt.setVisible(true);
      this.add(map);
		
	        
	    }
		private class buttonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		}
		
		
	}
	


