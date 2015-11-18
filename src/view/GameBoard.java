package view;

import java.awt.Color;
import java.awt.Font;
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

public class GameBoard extends JPanel{
	
	ArrayList<Continent> Continents;
	BufferedImage map;

	JPanel board;
	JFrame temp;
	
	String javaN,pythonN, cN, sqlN, rubyN, gitN, perlN;//number on the circle for language
	JButton javaL, pythonL, cL, sqlL, rubyL, gitL, perlL;//circle button for language
	JLabel l1,l2,l3,l4,l5,l6,l7;//number for language
	
	
	ImageIcon gray1;
	JLabel picLabel;

	JPanel boardDisplay, boardInfo;
	

	
	/*
	public static void main(String args[]) {

		GameBoard window = new GameBoard();
		window.setVisible(true);
	}*/
	
	
	public GameBoard(){

		
		this.setSize(900,550);
		this.setLocation(380,-10);
		this.setLayout(null);

		
		
		
		try {
			map = ImageIO.read(new File("./Pictures/map.png"));
			picLabel = new JLabel(new ImageIcon(map));
			picLabel.setLocation(0, 0);
			picLabel.setSize(900, 550);
			
		} catch (IOException e) {
			System.out.println("ERROR with map");
			e.printStackTrace();
		}
		gray1= new ImageIcon("./Pictures/circle.png");
		
		
		javaN=new String("0");
		pythonN=new String("0");
		cN=new String("0");
		sqlN=new String("0");
		rubyN=new String("0");
		gitN=new String("0");
		perlN=new String("0");
		
		l1= new JLabel(javaN);
		l2= new JLabel(pythonN);
		l3= new JLabel(cN);
		l4= new JLabel(sqlN);
		l5= new JLabel(rubyN);
		l6= new JLabel(gitN);
		l7= new JLabel(perlN);
		
		
		javaL= new JButton(gray1);
		pythonL= new JButton(gray1);
		cL= new JButton(gray1);
		sqlL= new JButton(gray1);
		rubyL= new JButton(gray1);
		gitL= new JButton(gray1);
		perlL= new JButton(gray1);
		
		
		javaL.addActionListener(new buttonListener());
		pythonL.addActionListener(new buttonListener());
		cL.addActionListener(new buttonListener());
		sqlL.addActionListener(new buttonListener());
		rubyL.addActionListener(new buttonListener());
		gitL.addActionListener(new buttonListener());
		perlL.addActionListener(new buttonListener());
		
		
		
//		GameBoard panel = new GameBoard((new ImageIcon("images/background.png").getImage()));
//		panel.setLocation(300, 10);
//	    panel.setSize(500,500);
//	    this.add(panel);
//	    panel.setVisible(true);
//	    
		
		
     // nbt.setBackground(Color.BLUE);

		Font font = new Font("Serif",Font.BOLD, 20);
		
      
		javaL.setSize(25, 25);
		javaL.setLocation(520, 100);
		javaL.setOpaque(false);
		javaL.setContentAreaFilled(false);
		javaL.setBorderPainted(false);
		
      l1.setSize(25,25);
      l1.setFont(font);
      l1.setForeground(Color.WHITE);
      l1.setLocation(528, 103);
      l1.setOpaque(false);
     
      pythonL.setSize(25, 25);
		pythonL.setLocation(640, 85);
		pythonL.setOpaque(false);
		pythonL.setContentAreaFilled(false);
		pythonL.setBorderPainted(false);
		
    l2.setSize(25,25);
    l2.setFont(font);
    l2.setForeground(Color.WHITE);
    l2.setLocation(648, 88);
    l2.setOpaque(false);
    
    cL.setSize(25, 25);
	cL.setLocation(535, 145);
	cL.setOpaque(false);
	cL.setContentAreaFilled(false);
	cL.setBorderPainted(false);
	
  l3.setSize(25,25);
  l3.setFont(font);
  l3.setForeground(Color.WHITE);
  l3.setLocation(543, 148);
  l3.setOpaque(false);
  
  sqlL.setSize(25, 25);
	sqlL.setLocation(600, 110);
	sqlL.setOpaque(false);
	sqlL.setContentAreaFilled(false);
	sqlL.setBorderPainted(false);
	
l4.setSize(25,25);
l4.setFont(font);
l4.setForeground(Color.WHITE);
l4.setLocation(608, 113);
l4.setOpaque(false);

rubyL.setSize(25, 25);
rubyL.setLocation(600, 165);
rubyL.setOpaque(false);
rubyL.setContentAreaFilled(false);
rubyL.setBorderPainted(false);

l5.setSize(25,25);
l5.setFont(font);
l5.setForeground(Color.WHITE);
l5.setLocation(608, 168);
l5.setOpaque(false);

gitL.setSize(25, 25);
gitL.setLocation(640, 140);
gitL.setOpaque(false);
gitL.setContentAreaFilled(false);
gitL.setBorderPainted(false);

l6.setSize(25,25);
l6.setFont(font);
l6.setForeground(Color.WHITE);
l6.setLocation(648, 143);
l6.setOpaque(false);

perlL.setSize(25, 25);
perlL.setLocation(690, 130);
perlL.setOpaque(false);
perlL.setContentAreaFilled(false);
perlL.setBorderPainted(false);

l7.setSize(25,25);
l7.setFont(font);
l7.setForeground(Color.WHITE);
l7.setLocation(698, 133);
l7.setOpaque(false);


     
     //add all lables
      this.add(l1);
      this.add(l2);
      this.add(l3);
      this.add(l4);
      this.add(l5);
      this.add(l6);
      this.add(l7);
      
      
      //add all buttons
      this.add(javaL);
      this.add(pythonL);
      this.add(cL);
      this.add(sqlL);
      this.add(rubyL);
      this.add(gitL);
      this.add(perlL);
      

      
      
      //add map
      this.add(picLabel);
      
           
		
	}
	private class buttonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			gray1= new ImageIcon("./Pictures/bcircle.png");
			
		}
		
	}
		 
		
	}

