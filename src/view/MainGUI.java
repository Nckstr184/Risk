package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
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

import com.sun.prism.Graphics;

import model.Player;
import model.Sun;
import model.Territory;



public class MainGUI extends JFrame {
	
	GameBoard map;
	JTextField updateDisplay;
	JButton toggleSound, quitGame, saveGame;
	
	
	
	public static void main(String[] args) {
		MainGUI window = new MainGUI();
		window.setVisible(true);
		System.out.println("Brooklyn's");
	}

	public MainGUI() {

		this.setLayout(null);


		GameBoard map = new GameBoard();

		Dimension sizeMe = Toolkit.getDefaultToolkit().getScreenSize();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(sizeMe);
		this.setLayout(null);
		
		this.add(map);
	}
		
		
	}
	


