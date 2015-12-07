package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.GameLogic;

public class OpenNewMenu extends JFrame {

	private JButton newgame;
	private JButton oldgame;
	private JButton aboutgame;
	private StartWindow startWindow;
	ImageIcon new1, old, about, background;
	

	private boolean clicked;

	public OpenNewMenu() {
		clicked = false;

		this.setSize(350, 350);
		this.setTitle("New Game or Load Old Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(3, 1, 0, 0));
		

		this.setLocation(350, 100);
			new1 = new ImageIcon("./Pictures/newgamelabel.png");
			old = new ImageIcon("./Pictures/oldgamelabel.png");
			about = new ImageIcon("./Pictures/aboutlabel.png");
			background = new ImageIcon("./Pictures/openmenu.png");//might have to make a buffered image label

			
			
			newgame = new JButton(new1);
			newgame.addActionListener(new startNewGame());
			oldgame = new JButton(old);
			oldgame.addActionListener(new loadOldGame());
			aboutgame= new JButton(about);
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

}
