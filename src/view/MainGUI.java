package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainGUI extends JFrame {

	GameBoard map;
	BottomBoard bottomBoard;
	SideBoard sideBoard;
	JTextField updateDisplay;
	JButton toggleSound, quitGame, saveGame;


	public static void main(String[] args) {
		MainGUI window = new MainGUI();
		window.setVisible(false);
		new StartWindow().setVisible(true);
	}
	
	public MainGUI() {

		this.setLayout(null);

<<<<<<< HEAD
		GameBoard map = new GameBoard();
		
		JPanel bottomeDisplay = new JPanel();
		JPanel sideDisplay = new JPanel();
=======
		map = new GameBoard();
		bottomBoard= new BottomBoard();
>>>>>>> d51f83a2e74b486c55c2932533ddeeb3fbb68773

		Dimension sizeMe = Toolkit.getDefaultToolkit().getScreenSize();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(sizeMe);

		saveGame = new JButton();
		quitGame = new JButton();
		toggleSound = new JButton();
		quitGame.addActionListener(new quitGameListener());
		saveGame.addActionListener(new saveGameListener());
		toggleSound.addActionListener(new toggleSoundListener());

		Font font = new Font("Serif", Font.BOLD, 20);

		saveGame.setLocation(5, 30);
		saveGame.setSize(80, 40);
		saveGame.setText("Save Game");
		toggleSound.setLocation(5, 80);
		toggleSound.setSize(80, 40);
		toggleSound.setText("Sound");
		quitGame.setLocation(5, 130);
		quitGame.setSize(80, 40);
		quitGame.setText("Quit Game");
		this.add(saveGame);
		this.add(quitGame);
		this.add(toggleSound);

		this.add(map);
		this.add(bottomBoard);

	}

	private class buttonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
	//		gray = new ImageIcon("./Pictures/bcircle.png");

		}

	}

	private class saveGameListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Saving Game");

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

}
