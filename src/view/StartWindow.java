package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Player;
import model.PlayerCollection;
import typesOfPlayers.EasyAI;
import typesOfPlayers.HardAI;
import typesOfPlayers.Human;
import typesOfPlayers.MediumAI;

public class StartWindow extends JFrame {
	JComboBox diff1, diff2, diff3, diff4, diff5, diff6;
	JTextField player1, player2, player3, player4, player5, player6;
	JButton startGame;
	JPanel panel;
	JLabel enterName;
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
		setLayout(null);

		this.setLocation(350, 100);

		player1 = new JTextField();
		player2 = new JTextField();
		player3 = new JTextField();
		player4 = new JTextField();
		player5 = new JTextField();
		player6 = new JTextField();

		diff1 = new JComboBox();
		diff2 = new JComboBox();
		diff3 = new JComboBox();
		diff4 = new JComboBox();
		diff5 = new JComboBox();
		diff6 = new JComboBox();

		enterName = new JLabel();

		enterName.setText("Enter Player Names in Text Fields");
		enterName.setSize(300, 15);
		enterName.setLocation(0, 0);

		player1.setText("");
		player2.setText("");
		player3.setText("");
		player4.setText("");
		player5.setText("");
		player6.setText("");

		String[] player1Choice = { "Select A.I", "Human", "Easy AI", "Medium AI", "Hard AI" };
		String[] player2Choice = { "Select A.I", "Easy AI", "Medium AI", "Hard AI", "Human" };
		String[] player3Choice = { "Select A.I", "Easy AI", "Medium AI", "Hard AI", "Human" };
		String[] player4Choice = { "Select A.I", "None", "Human", "Easy AI", "Medium AI", "Hard AI" };
		String[] player5Choice = { "Select A.I", "None", "Human", "Easy AI", "Medium AI", "Hard AI" };
		String[] player6Choice = { "Select A.I", "None", "Human", "Easy AI", "Medium AI", "Hard AI" };
		JComboBox<String> diff1 = new JComboBox<String>(player1Choice);
		JComboBox<String> diff2 = new JComboBox<String>(player2Choice);
		JComboBox<String> diff3 = new JComboBox<String>(player3Choice);
		JComboBox<String> diff4 = new JComboBox<String>(player4Choice);
		JComboBox<String> diff5 = new JComboBox<String>(player5Choice);
		JComboBox<String> diff6 = new JComboBox<String>(player6Choice);

		player1.setLocation(10, 10);
		player1.setSize(75, 30);

		diff1.setLocation(80, 0);
		diff1.setSize(150, 50);
		diff1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedDiff1 = (String) diff1.getSelectedItem();
			}
		});

		player2.setLocation(10, 40);
		player2.setSize(75, 30);

		diff2.setLocation(80, 30);
		diff2.setSize(150, 50);
		diff2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedDiff2 = (String) diff2.getSelectedItem();
			}
		});

		player3.setLocation(10, 70);
		player3.setSize(75, 30);

		diff3.setLocation(80, 60);
		diff3.setSize(150, 50);
		diff3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedDiff3 = (String) diff3.getSelectedItem();
			}
		});

		player4.setLocation(10, 100);
		player4.setSize(75, 30);

		diff4.setLocation(80, 90);
		diff4.setSize(150, 50);
		diff4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedDiff4 = (String) diff4.getSelectedItem();
			}
		});

		player5.setLocation(10, 130);
		player5.setSize(75, 30);

		diff5.setLocation(80, 120);
		diff5.setSize(150, 50);
		diff5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedDiff5 = (String) diff5.getSelectedItem();
			}
		});

		player6.setLocation(10, 160);
		player6.setSize(75, 30);

		diff6.setLocation(80, 150);
		diff6.setSize(150, 50);
		diff6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedDiff6 = (String) diff6.getSelectedItem();
			}
		});

		startGame = new JButton();
		startGame.addActionListener(new startGameListener());
		startGame.setSize(200, 50);
		startGame.setLocation(50, 200);
		startGame.setText("Start the Battle!!!");

		this.add(enterName);
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
				playerOne = new Human(player1Name, Color.lightGray, 0);
				pCollection.addPlayers(playerOne);
				count++;
			}
			if (selectedDiff1 == "Easy AI") {
				playerOne = new EasyAI(player1Name, Color.lightGray, 0);
				pCollection.addPlayers(playerOne);
				count++;
			}
			if (selectedDiff1 == "Medium AI") {
				playerOne = new MediumAI(player1Name, Color.lightGray, 0);
				pCollection.addPlayers(playerOne);
				count++;
			}
			if (selectedDiff1 == "Hard AI") {
				playerOne = new HardAI(player1Name, Color.lightGray, 0);
				pCollection.addPlayers(playerOne);
				count++;
			}
			if (selectedDiff2 == "Human") {
				playerTwo = new Human(player2Name, Color.red, 0);
				pCollection.addPlayers(playerTwo);
				count++;
			}
			if (selectedDiff2 == "Easy AI") {
				playerTwo = new EasyAI(player2Name, Color.red, 0);
				pCollection.addPlayers(playerTwo);
				count++;
			}
			if (selectedDiff2 == "Medium AI") {
				playerTwo = new MediumAI(player2Name, Color.red, 0);
				pCollection.addPlayers(playerTwo);
				count++;
			}
			if (selectedDiff2 == "Hard AI") {
				playerTwo = new HardAI(player2Name, Color.red, 0);
				pCollection.addPlayers(playerTwo);
				count++;
			}
			if (selectedDiff3 == "Human") {
				playerThree = new Human(player3Name, Color.yellow, 0);
				pCollection.addPlayers(playerThree);
				count++;
			}
			if (selectedDiff3 == "Easy AI") {
				playerThree = new EasyAI(player3Name, Color.yellow, 0);
				pCollection.addPlayers(playerThree);
				count++;
			}
			if (selectedDiff3 == "Medium AI") {
				playerThree = new MediumAI(player3Name, Color.yellow, 0);
				pCollection.addPlayers(playerThree);
				count++;
			}
			if (selectedDiff3 == "Hard AI") {
				playerThree = new HardAI(player3Name, Color.yellow, 0);
				pCollection.addPlayers(playerThree);
				count++;
			}
			if (selectedDiff4 == "Human") {
				playerFour = new Human(player4Name, Color.green, 0);
				pCollection.addPlayers(playerFour);
				count++;
			}
			if (selectedDiff4 == "Easy AI") {
				playerFour = new EasyAI(player4Name, Color.green, 0);
				pCollection.addPlayers(playerFour);
				count++;
			}
			if (selectedDiff4 == "Medium AI") {
				playerFour = new MediumAI(player4Name, Color.green, 0);
				pCollection.addPlayers(playerFour);
				count++;
			}
			if (selectedDiff4 == "Hard AI") {
				playerFour = new HardAI(player4Name, Color.green, 0);
				pCollection.addPlayers(playerFour);
				count++;
			}
			if (selectedDiff5 == "Human") {
				playerFive = new Human(player5Name, Color.white, 0);
				pCollection.addPlayers(playerFive);
				count++;
			}
			if (selectedDiff5 == "Easy AI") {
				playerFive = new EasyAI(player5Name, Color.white, 0);
				pCollection.addPlayers(playerFive);
				count++;
			}
			if (selectedDiff5 == "Medium AI") {
				playerFive = new MediumAI(player5Name, Color.white, 0);
				pCollection.addPlayers(playerFive);
				count++;
			}
			if (selectedDiff5 == "Hard AI") {
				playerFive = new HardAI(player5Name, Color.white, 0);
				pCollection.addPlayers(playerFive);
				count++;
			}
			if (selectedDiff6 == "Human") {
				playerSix = new Human(player6Name, Color.orange, 0);
				pCollection.addPlayers(playerSix);
				count++;
			}
			if (selectedDiff6 == "Easy AI") {
				playerSix = new EasyAI(player6Name, Color.orange, 0);
				pCollection.addPlayers(playerSix);
				count++;	
			}
			
			if (selectedDiff6 == "Medium AI") {
				playerSix = new MediumAI(player6Name, Color.orange, 0);
				pCollection.addPlayers(playerSix);
				count++;
			}
			if (selectedDiff6 == "Hard AI") {
				playerSix = new HardAI(player6Name, Color.orange, 0);
				pCollection.addPlayers(playerSix);
				count++;
			}

			setNumberOfPlayers(count);

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
