package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class OpenNewMenu extends JFrame{
	
JButton newgame;
JButton oldgame;
StartWindow startWindow;

	public OpenNewMenu() {
		
	

		this.setSize(350, 350);
		this.setTitle("New Game or Load Old Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(3,1,1,1));
		

		this.setLocation(350, 100);
		
		
		newgame = new JButton("NEW GAME");
		newgame.addActionListener(new startNewGame());
		oldgame= new JButton("LOAD OLD GAME");
		
		this.add(newgame);
		this.add(oldgame);
		
		
		this.setVisible(true);
		}
	private class startNewGame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//startWindow = new StartWindow();
			dispose();
		
	}
	}
}
