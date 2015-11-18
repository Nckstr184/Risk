package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Continent;

import com.sun.prism.Graphics;

public class GameBoard extends JPanel{
	
	ArrayList<Continent> Continents;
	BufferedImage map;
	JPanel board;
	JFrame temp;
	JButton nbt;
	JLabel num;
	ImageIcon gray1;
	String B1T1;
	
	/*
	public static void main(String args[]) {

		GameBoard window = new GameBoard();
		window.setVisible(true);
	}*/
	
	
	public GameBoard(){

		
		this.setSize(900,550);
		this.setLocation(380,-10);
		
		
		
		try {
			map = ImageIO.read(new File("./Pictures/map.png"));
			JLabel picLabel = new JLabel(new ImageIcon(map));
			add(picLabel);
		} catch (IOException e) {
			System.out.println("ERROR with map");
			e.printStackTrace();
		}
		
		gray1= new ImageIcon("./Pictures/circle.png");
		B1T1=new String("0");
		num= new JLabel(B1T1);
		nbt= new JButton(gray1);
		nbt.addActionListener(new buttonListener());
		
//		GameBoard panel = new GameBoard((new ImageIcon("images/background.png").getImage()));
//		panel.setLocation(300, 10);
//	    panel.setSize(500,500);
//	    this.add(panel);
//	    panel.setVisible(true);
//	    
		
		
     // nbt.setBackground(Color.BLUE);

		Font font = new Font("Serif",Font.BOLD, 20);
		
      
      nbt.setSize(25, 25);
      nbt.setLocation(680, 150);

      nbt.setOpaque(false);
      nbt.setContentAreaFilled(false);
      nbt.setBorderPainted(false);
      num.setSize(25,25);
      num.setFont(font);
      num.setForeground(Color.WHITE);
      num.setLocation(688, 153);
      num.setOpaque(false);
     
     
     
      this.add(num);
      this.add(nbt);
      
      nbt.setVisible(true);
      
		
	        
	    }

		private class buttonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				gray1= new ImageIcon("./Pictures/bcircle.png");
				repaint();
				
			}

			public void paintComponent(Graphics g){
			//	super.paintComponent(g);
				Graphics2D g2= (Graphics2D) g;
				
			}
			
		}
	
}
		 
		
	

