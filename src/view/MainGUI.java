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

	static MainGUI window;
	private FileOutputStream outputStream;
	private ObjectOutputStream objectOutput;

	public static void main(String[] args) {
		window = new MainGUI();
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

			try {
				outputStream = new FileOutputStream("savedGame");
				objectOutput = new ObjectOutputStream(outputStream);

			} catch (Exception e1) {
				e1.printStackTrace();
				System.out.println("opening output stream failed");
			}

			try {
				if (map.getPlayers() == null && map.getCards() == null && map.getTerritories() == null
						&& map.getContinents() == null) {
					System.out.println("ITs NULL MAN");
				}
				objectOutput.writeObject(map.getPlayers());
				objectOutput.writeObject(map.getCards());
				objectOutput.writeObject(map.getTerritories());
				objectOutput.writeObject(map.getContinents());
				objectOutput.writeObject(map.getCurrentPlayer());
				objectOutput.writeObject(map.getPlayerTurn());
				objectOutput.writeObject(map.reinforcementPhase);

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("writing game logic failed");
				e1.printStackTrace();
			}

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
			int selectedOption = JOptionPane.showConfirmDialog(null, "Do you want Save?", "Choose",
					JOptionPane.YES_NO_CANCEL_OPTION);
			if (selectedOption == JOptionPane.NO_OPTION) {
				window.dispose();
			}
			if (selectedOption == JOptionPane.YES_OPTION) {
				try {
					outputStream = new FileOutputStream("savedGame");
					objectOutput = new ObjectOutputStream(outputStream);

				} catch (Exception e1) {
					e1.printStackTrace();
					System.out.println("opening output stream failed");
				}

				try {
					if (map.getPlayers() == null && map.getCards() == null && map.getTerritories() == null
							&& map.getContinents() == null) {
						System.out.println("ITs NULL MAN");
					}
					objectOutput.writeObject(map.getPlayers());
					objectOutput.writeObject(map.getCards());
					objectOutput.writeObject(map.getTerritories());
					objectOutput.writeObject(map.getContinents());
					objectOutput.writeObject(map.getCurrentPlayer());
					objectOutput.writeObject(map.getPlayerTurn());
					objectOutput.writeObject(map.reinforcementPhase);

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("writing game logic failed");
					e1.printStackTrace();
				}
				window.dispose();
				System.exit(0);
			}
			if (selectedOption == JOptionPane.YES_OPTION) {
				
			}
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