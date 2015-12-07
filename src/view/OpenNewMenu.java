package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import demoSongPlayer.Play1Song;
import model.GameLogic;

public class OpenNewMenu extends JFrame {

	private JButton newgame;
	private JButton oldgame;
	private JButton aboutgame;
	private StartWindow startWindow;
	ImageIcon new1, old, about, background;
	Cursor star;
	Image starImage;
	Play1Song playsong;
	String song;

	private boolean clicked;

	public OpenNewMenu() {
		clicked = false;
		song= "./songs/menusong.aiff";
		playsong= new Play1Song(song);
		

		this.setSize(360, 360);
		this.setTitle("New Game or Load Old Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(3, 1, 0, 0));
		

		this.setLocation(350, 100);
		
		Toolkit tools1 = Toolkit.getDefaultToolkit();
		
		
			starImage = tools1.getImage("./Pictures/Starugh.png");
		
		star = tools1.createCustomCursor(starImage, new Point(0,0), "img");//i hope this works
		
		
		
			new1 = new ImageIcon("./Pictures/newgamelabel.png");
			old = new ImageIcon("./Pictures/oldgamelabel.png");
			about = new ImageIcon("./Pictures/aboutlabel.png");
			background = new ImageIcon("./Pictures/openmenu.png");//might have to make a buffered image label

			
			
			newgame = new JButton(new1);
			newgame.addActionListener(new startNewGame());
			oldgame = new JButton(old);
			oldgame.addActionListener(new loadOldGame());
			aboutgame= new JButton(about);
			aboutgame.addActionListener(new aboutGame());
			//add listener for about

			
			newgame.setOpaque(false);
			newgame.setContentAreaFilled(false);
			newgame.setBorderPainted(false);
			
			oldgame.setOpaque(false);
			oldgame.setContentAreaFilled(false);
			oldgame.setBorderPainted(false);
			
			aboutgame.setOpaque(false);
			aboutgame.setContentAreaFilled(false);
			aboutgame.setBorderPainted(false);
			
			newgame.setCursor(star);
			oldgame.setCursor(star);
			aboutgame.setCursor(star);
		this.add(newgame);
		this.add(oldgame);
		this.add(aboutgame);
		

		this.setVisible(true);

	}

	public boolean isClicked() {
		return clicked;

	}

	private class startNewGame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// startWindow = new StartWindow();
			dispose();
			

		}
	}

	private class loadOldGame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			clicked = true;
			dispose();

		}
	}

	private class aboutGame implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String message = "Welcome to RISK"
					+ "\n\nRules:"
					+ "\n\t-Turns have 3 phases: deploy, attack, and fortify"
					+ "\n\t-You can only attack if you have more than 1 army at that territory"
					+ "\n\t-You can only fortify once per turn"
					+ "\n\t-If you lose all your territories, you are removed from the game"
					+ "\n\t-After 60 rounds of play, the player with the most territories wins"
					+ "\n\nNotes:"
					+ "\n\t-AIs will only show battle dialog if the defender is a Human player"
					+ "\n\t-During battles, dice ties go to the defender"
					+ "\n\nCreated by: Four Blind Mice <3";
			JOptionPane.showMessageDialog(null, message, "About", 1);
		}
	}
}