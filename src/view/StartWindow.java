package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartWindow extends JFrame {
	JComboBox diff1, diff2, diff3, diff4, diff5, diff6;
	JLabel player1, player2, player3, player4, player5, player6;
	JButton startGame;
	JPanel panel;
	
	
	public StartWindow(){
		LayoutWindow();
		
	}
	
	
	private void LayoutWindow(){
		
		this.setSize(350, 350);
		this.setTitle("Start Window");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		this.setLocation(350,100);

		player1 = new JLabel();
		player2 = new JLabel();
		player3 = new JLabel();
		player4 = new JLabel();
		player5 = new JLabel();
		player6 = new JLabel();
		
		diff1 = new JComboBox();
		diff2 = new JComboBox();
		diff3 = new JComboBox();
		diff4 = new JComboBox();
		diff5 = new JComboBox();
		diff6 = new JComboBox();
		
		
		player1.setText("Player 1: ");
		player2.setText("Player 2: ");
		player3.setText("Player 3: ");
		player4.setText("Player 4: ");
		player5.setText("Player 5: ");
		player6.setText("Player 6: ");
		
		String [] player1Choice = {"Human", "Easy AI", "Medium AI", "Hard AI"};
		String [] player2Choice = {"Easy AI", "Medium AI", "Hard AI","Human"};
		String [] player3Choice = {"Easy AI", "Medium AI", "Hard AI","Human"};
		String [] player4Choice = {"None","Human", "Easy AI", "Medium AI", "Hard AI"};
		String [] player5Choice = {"None","Human", "Easy AI", "Medium AI", "Hard AI"};
		String [] player6Choice = {"None","Human", "Easy AI", "Medium AI", "Hard AI"};
		JComboBox<String> diff1 = new JComboBox<String>(player1Choice);
		JComboBox<String> diff2 = new JComboBox<String>(player2Choice);
		JComboBox<String> diff3 = new JComboBox<String>(player3Choice);
		JComboBox<String> diff4 = new JComboBox<String>(player4Choice);
		JComboBox<String> diff5 = new JComboBox<String>(player5Choice);
		JComboBox<String> diff6 = new JComboBox<String>(player6Choice);
		
		player1.setLocation(10,10);
		player1.setSize(75,30);
		
		diff1.setLocation(80,0);
		diff1.setSize(150,50);
		
		player2.setLocation(10,40);
		player2.setSize(75,30);
		
		diff2.setLocation(80,30);
		diff2.setSize(150,50);
		
		player3.setLocation(10,70);
		player3.setSize(75,30);
		
		diff3.setLocation(80,60);
		diff3.setSize(150,50);
		
		player4.setLocation(10,100);
		player4.setSize(75,30);
		
		diff4.setLocation(80,90);
		diff4.setSize(150,50);
		
		player5.setLocation(10,130);
		player5.setSize(75,30);
		
		diff5.setLocation(80,120);
		diff5.setSize(150,50);
		
		player6.setLocation(10,160);
		player6.setSize(75,30);
		
		diff6.setLocation(80,150);
		diff6.setSize(150,50);
		/*numPlayers.setSize(150,20);
		numPlayers.setLocation(0,10);
		setNumPlayers.setSize(100,20);
		setNumPlayers.setLocation(150,10);
		diff.setSize(150,20);
		diff.setLocation(0,30);
		diff.setSize(100, 20);
		setDiff.setLocation(150,30);
		setDiff.setSize(100,20);*/
		
		startGame = new JButton();
		startGame.setSize(200,50);
		startGame.setLocation(50,200);
		startGame.setText("Start the Battle!!!");
		
		
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
	
	
	public void setNumberOfPlayers(int numPlayers){
		
		
	}
	
	public void setPlayerName(String playerName){
		
		
		
	}
	
	public void setPlayerColor(Color color){
		
		
	}
	
	public void setAI(int difficulty){
		
		
	}
	
	public void toggleSound(boolean toggle){
		
		
	}
	

}
