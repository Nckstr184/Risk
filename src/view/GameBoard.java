package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Continent;

public class GameBoard extends JPanel{
	
	ArrayList<Continent> Continents;
	BufferedImage map;
	JPanel board, boardDisplay, boardInfo;
	
	
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
		
		
	}
	
		 
		
	}

