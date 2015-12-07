package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Player;
import model.PlayerCollection;
import typesOfPlayers.EasyAI;
import typesOfPlayers.HardAI;
import typesOfPlayers.Human;
import typesOfPlayers.MediumAI;

public class StartWindow extends JFrame {
	JComboBox<String> diff1, diff2, diff3, diff4, diff5, diff6;
	JTextField player1, player2, player3, player4, player5, player6;
	JButton startGame;
	JPanel panel;
	JLabel enterName, blank;
	public PlayerCollection pCollection;
	Player playerOne, playerTwo, playerThree, playerFour, playerFive, playerSix;
	Human human1, human2, human3, human4, human5, human6;
	EasyAI easy1, easy2, easy3, easy4, easy5, easy6;
	MediumAI med1, med2, med3, med4, med5, med6;
	HardAI hard1, hard2, hard3, hard4, hard5, hard6;
	ArrayList<Player> pList;
	String playerName, player1Name, player2Name, player3Name, player4Name, player5Name, player6Name, selectedDiff1,
			selectedDiff2, selectedDiff3, selectedDiff4, selectedDiff5, selectedDiff6;

	private int count;
	public int numOfPlayers;

	public StartWindow() {

		this.setSize(350, 350);
		this.setTitle("Start Window");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(8, 2, 10, 10) );

		this.setLocation(350, 100);

		player1 = new JTextField();
		player2 = new JTextField();
		player3 = new JTextField();
		player4 = new JTextField();
		player5 = new JTextField();
		player6 = new JTextField();

		enterName = new JLabel();
		blank= new JLabel("");

		enterName.setText("Enter Player Names Here");
		

		player1.setText("Rick");
		player2.setText("Jeremy");
		player3.setText("Daniel");
		player4.setText("");
		player5.setText("");
		player6.setText("");

		String[] player1Choice = { "Select Player", "Human", "Easy AI", "Medium AI", "Hard AI" };
		String[] player2Choice = { "Select Player", "Human", "Easy AI", "Medium AI", "Hard AI"};
		String[] player3Choice = { "Select Player", "Human", "Easy AI", "Medium AI", "Hard AI"};
		String[] player4Choice = { "Select Player", "Human", "Easy AI", "Medium AI", "Hard AI" };
		String[] player5Choice = { "Select Player", "Human", "Easy AI", "Medium AI", "Hard AI" };
		String[] player6Choice = { "Select Player", "Human", "Easy AI", "Medium AI", "Hard AI" };
		diff1 = new JComboBox<String>(player1Choice);
		diff2 = new JComboBox<String>(player2Choice);
		diff3 = new JComboBox<String>(player3Choice);
		diff4 = new JComboBox<String>(player4Choice);
		diff5 = new JComboBox<String>(player5Choice);
		diff6 = new JComboBox<String>(player6Choice);

		

		diff1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedDiff1 = (String) diff1.getSelectedItem();
			}
		});


		diff2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedDiff2 = (String) diff2.getSelectedItem();
			}
		});

		diff3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedDiff3 = (String) diff3.getSelectedItem();
			}
		});

		
		diff4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedDiff4 = (String) diff4.getSelectedItem();
			}
		});

		
		diff5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedDiff5 = (String) diff5.getSelectedItem();
			}
		});

		diff6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedDiff6 = (String) diff6.getSelectedItem();
			}
		});

		startGame = new JButton();
		startGame.addActionListener(new startGameListener());
		
		startGame.setText("Start the Battle!!!");

		this.add(enterName);
		this.add(blank);
		this.add(diff1);
		this.add(player1);
		this.add(diff2);
		this.add(player2);
		this.add(diff3);
		this.add(player3);
		this.add(diff4);
		this.add(player4);
		this.add(diff5);
		this.add(player5);
		this.add(diff6);
		this.add(player6);

		this.add(startGame);

		this.setVisible(true);

	}

	public class startGameListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			pCollection = new PlayerCollection();

			player1Name = player1.getText();
			player2Name = player2.getText();
			player3Name = player3.getText();
			player4Name = player4.getText();
			player5Name = player5.getText();
			player6Name = player6.getText();
			count = 0;

			if (selectedDiff1 == "Human") {
				playerOne = new Human(player1Name, Color.yellow, 0, false);
				pCollection.addPlayers(playerOne);
				count++;
			}
			if (selectedDiff1 == "Easy AI") {
				playerOne = new EasyAI(player1Name, Color.yellow, 0, true);
				pCollection.addPlayers(playerOne);
				count++;
			}
			if (selectedDiff1 == "Medium AI") {
				playerOne = new MediumAI(player1Name, Color.yellow, 0, true);
				pCollection.addPlayers(playerOne);
				count++;
			}
			if (selectedDiff1 == "Hard AI") {
				playerOne = new HardAI(player1Name, Color.yellow, 0, true);
				pCollection.addPlayers(playerOne);
				count++;
			}
			if (selectedDiff2 == "Human") {
				playerTwo = new Human(player2Name, Color.green, 0, false);
				pCollection.addPlayers(playerTwo);
				count++;
			}
			if (selectedDiff2 == "Easy AI") {
				playerTwo = new EasyAI(player2Name, Color.green, 0, true);
				pCollection.addPlayers(playerTwo);
				count++;
			}
			if (selectedDiff2 == "Medium AI") {
				playerTwo = new MediumAI(player2Name, Color.green, 0, true);
				pCollection.addPlayers(playerTwo);
				count++;
			}
			if (selectedDiff2 == "Hard AI") {
				playerTwo = new HardAI(player2Name, Color.green, 0, true);
				pCollection.addPlayers(playerTwo);
				count++;
			}
			if (selectedDiff3 == "Human") {
				playerThree = new Human(player3Name, Color.orange, 0, false);
				pCollection.addPlayers(playerThree);
				count++;
			}
			if (selectedDiff3 == "Easy AI") {
				playerThree = new EasyAI(player3Name, Color.orange, 0, true);
				pCollection.addPlayers(playerThree);
				count++;
			}
			if (selectedDiff3 == "Medium AI") {
				playerThree = new MediumAI(player3Name, Color.orange, 0, true);
				pCollection.addPlayers(playerThree);
				count++;
			}
			if (selectedDiff3 == "Hard AI") {
				playerThree = new HardAI(player3Name, Color.orange, 0, true);
				pCollection.addPlayers(playerThree);
				count++;
			}
			if (selectedDiff4 == "Human") {
				playerFour = new Human(player4Name, Color.red, 0, false);
				pCollection.addPlayers(playerFour);
				count++;
			}
			if (selectedDiff4 == "Easy AI") {
				playerFour = new EasyAI(player4Name, Color.red, 0, true);
				pCollection.addPlayers(playerFour);
				count++;
			}
			if (selectedDiff4 == "Medium AI") {
				playerFour = new MediumAI(player4Name, Color.red, 0, true);
				pCollection.addPlayers(playerFour);
				count++;
			}
			if (selectedDiff4 == "Hard AI") {
				playerFour = new HardAI(player4Name, Color.red, 0, true);
				pCollection.addPlayers(playerFour);
				count++;
			}
			if (selectedDiff5 == "Human") {
				playerFive = new Human(player5Name, Color.pink, 0, false);
				pCollection.addPlayers(playerFive);
				count++;
			}
			if (selectedDiff5 == "Easy AI") {
				playerFive = new EasyAI(player5Name, Color.pink, 0, true);
				pCollection.addPlayers(playerFive);
				count++;
			}
			if (selectedDiff5 == "Medium AI") {
				playerFive = new MediumAI(player5Name, Color.pink, 0, true);
				pCollection.addPlayers(playerFive);
				count++;
			}
			if (selectedDiff5 == "Hard AI") {
				playerFive = new HardAI(player5Name, Color.pink, 0, true);
				pCollection.addPlayers(playerFive);
				count++;
			}
			if (selectedDiff6 == "Human") {
				playerSix = new Human(player6Name, Color.blue, 0, false);
				pCollection.addPlayers(playerSix);
				count++;
			}
			if (selectedDiff6 == "Easy AI") {
				playerSix = new EasyAI(player6Name, Color.blue, 0, true);
				pCollection.addPlayers(playerSix);
				count++;
			}

			if (selectedDiff6 == "Medium AI") {
				playerSix = new MediumAI(player6Name, Color.blue, 0, true);
				pCollection.addPlayers(playerSix);
				count++;
			}
			if (selectedDiff6 == "Hard AI") {
				playerSix = new HardAI(player6Name, Color.blue, 0, true);
				pCollection.addPlayers(playerSix);
				count++;
			}

			setNumberOfPlayers(count);
			
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
			dispose();

		}

	}

	public void setNumberOfPlayers(int numPlayers) {
		numOfPlayers = numPlayers;
	}

	public int getNumberOfPlayer() {
		return numOfPlayers;
	}

	public String getPlayerName(int index) {
		Player name = pCollection.getPlayer(index);
		String playerName = name.getName();
		return playerName;

	}

	public Player getPlayerAt(int index) {
		return pCollection.getPlayer(index);

	}

	public void setPlayerColor(Color color) {

	}

	public Color getPlayerColor(int index) {
		Player name = pCollection.getPlayer(index);
		Color playerColor = name.returnColor();
		return playerColor;
	}

	public void setAI(int difficulty) {

	}

	public void toggleSound(boolean toggle) {

	}

}