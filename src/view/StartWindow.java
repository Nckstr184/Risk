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
import typesOfPlayers.Human;
import typesOfPlayers.MediumAI;

public class StartWindow extends JFrame {
	JComboBox diff1, diff2, diff3, diff4, diff5, diff6;
	JTextField player1, player2, player3, player4, player5, player6;
	JButton startGame;
	JPanel panel;
	JLabel enterName;
	public PlayerCollection pCollection;
	Player playerOne, playerTwo, playerThree, playerFor, playerFive, playerSix;
	Human human1, human2, human3, human4, human5, human6;
	EasyAI easy1, easy2, easy3, easy4, easy5, easy6;
	MediumAI med1, med2, med3, med4, med5, med6;
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
			if(selectedDiff1 != null){
				count++;
			}
			if(selectedDiff2 != null){
				count++;
			}
			if(selectedDiff3 != null){
				count++;
			}
			if(selectedDiff4 != null){
				count++;
			}
			if(selectedDiff5 != null){
				count++;
			}
			if(selectedDiff6 != null){
				count++;
			}
			if(selectedDiff1 == "Human"){human1 = new Human(player1Name,Color.black,20);
			pCollection.addPlayers(human1);}
			if(selectedDiff1 == "Easy AI"){easy1 = new EasyAI(player1Name,Color.black,20);
			pCollection.addPlayers(easy1);}
			if(selectedDiff1 == "Medium AI"){med1 = new MediumAI(player1Name,Color.black,20);
			pCollection.addPlayers(med1);}
			if(selectedDiff2 == "Human"){human2 = new Human(player2Name,Color.red,20);
			pCollection.addPlayers(human2);}
			if(selectedDiff2 == "Easy AI"){easy2 = new EasyAI(player2Name,Color.red,20);
			pCollection.addPlayers(easy2);}
			if(selectedDiff2 == "Medium AI"){med2 = new MediumAI(player2Name,Color.red,20);
			pCollection.addPlayers(med2);}
			if(selectedDiff3 == "Human"){human3 = new Human(player3Name,Color.yellow,20);
			pCollection.addPlayers(human3);}
			if(selectedDiff3 == "Easy AI"){easy3 = new EasyAI(player3Name,Color.yellow,20);
			pCollection.addPlayers(easy3);}
			if(selectedDiff3 == "Medium AI"){med3 = new MediumAI(playerName,Color.yellow,20);
			pCollection.addPlayers(med3);}
			if(selectedDiff4 == "Human"){human4 = new Human(player4Name,Color.green,20);
			pCollection.addPlayers(human4);}
			if(selectedDiff4 == "Easy AI"){easy4 = new EasyAI(player4Name,Color.green,20);
			pCollection.addPlayers(easy4);}
			if(selectedDiff4 == "Medium AI"){med4 = new MediumAI(player4Name,Color.green,20);
			pCollection.addPlayers(med4);}
			if(selectedDiff5 == "Human"){human5 = new Human(player5Name,Color.white,20);
			pCollection.addPlayers(human5);}
			if(selectedDiff5 == "Easy AI"){easy5 = new EasyAI(player5Name,Color.white,20);
			pCollection.addPlayers(easy5);}
			if(selectedDiff5 == "Medium AI"){med5 = new MediumAI(player5Name,Color.white,20);
			pCollection.addPlayers(med5);}
			if(selectedDiff6 == "Human"){human6 = new Human(player6Name,Color.orange,20);
			pCollection.addPlayers(human6);}
			if(selectedDiff6 == "Easy AI"){easy6 = new EasyAI(player6Name,Color.orange,20);}
			pCollection.addPlayers(easy6);
			if(selectedDiff6 == "Medium AI"){med6 = new MediumAI(player6Name,Color.orange,20);
			pCollection.addPlayers(med6);}
			
			
			
			
			setNumberOfPlayers(count);
			System.out.println("Number of Players: " +pCollection.getNumOfPlayers());
			/*System.out.println(pCollection.getPlayer(0));
			System.out.println(pCollection.getPlayer(1));
			System.out.println(pCollection.getPlayer(2));
			System.out.println(pCollection.getPlayer(3));
			System.out.println(pCollection.getPlayer(4));
			System.out.println(pCollection.getPlayer(5));*/
			
			
			MainGUI mainGui = new MainGUI();
			mainGui.setVisible(true);
			
			dispose();

		}

	}

	public void setNumberOfPlayers(int numPlayers) {
		numOfPlayers = numPlayers;
	}
	

	public void setPlayerColor(Color color) {

	}
	//public ArrayList<Player> getPlayerCollection(){
		//return pCollection;
	//}

	public void setAI(int difficulty) {

	}

	public void toggleSound(boolean toggle) {

	}

}
