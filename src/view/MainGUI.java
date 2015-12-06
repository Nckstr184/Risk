package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.GameLogic;
import model.Player;
import model.PlayerCollection;
import model.Territory;

public class MainGUI extends JFrame {

	GameBoard map;

	BottomBoard bottomBoard;

	SideBoard sideBoard;

	JTextField updateDisplay;
	JButton toggleSound, quitGame, saveGame;

	GameLogic allgame;

	private FileOutputStream outputStream;
	private ObjectOutputStream objectOutput;

	public static void main(String[] args) {
		MainGUI window = new MainGUI();
		window.setVisible(true);

	}

	public MainGUI() {

		map = new GameBoard();

		// JPanel bottomeDisplay = new JPanel();
		// JPanel sideDisplay = new JPanel();

		this.setLayout(new BorderLayout());

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1300, 750);

		saveGame = new JButton();
		quitGame = new JButton();
		toggleSound = new JButton();
		quitGame.addActionListener(new quitGameListener());
		saveGame.addActionListener(new saveGameListener());
		toggleSound.addActionListener(new toggleSoundListener());

		Font font = new Font("Serif", Font.BOLD, 20);

		saveGame.setLocation(55, 50);
		saveGame.setSize(80, 40);
		saveGame.setText("Save Game");
		toggleSound.setLocation(55, 100);
		toggleSound.setSize(80, 40);
		toggleSound.setText("Sound");
		quitGame.setLocation(55, 150);
		quitGame.setSize(80, 40);
		quitGame.setText("Quit Game");

		// map.addButtons();

		this.add(saveGame);
		this.add(quitGame);
		this.add(toggleSound);

		this.add(map);
		this.addWindowListener(new myWindowListener());

		// this.add(bottomBoard);

	}

	private class saveGameListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Saving Game");

//			try {
//				outputStream = new FileOutputStream("savedGame");
//				objectOutput = new ObjectOutputStream(outputStream);
//
//			} catch (Exception e1) {
//				e1.printStackTrace();
//				System.out.println("opening output stream failed");
//			}
//
//			try {
//				objectOutput.writeObject(map.getPlayers());
//				objectOutput.writeObject(map.getContinents());
//				objectOutput.writeObject(map.getTerritories());
//				objectOutput.writeObject(map.getCards());
//
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				System.out.println("writing game logic failed");
//				e1.printStackTrace();
//			}

		}

	}

	private class quitGameListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);

		}

	}

	private class toggleSoundListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Change Sound");

		}

	}

	public class myWindowListener implements WindowListener {

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub

		}

	}
}