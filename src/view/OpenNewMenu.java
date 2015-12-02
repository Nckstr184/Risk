package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.GameLogic;

public class OpenNewMenu extends JFrame{
	
private JButton newgame;
private JButton oldgame;
private StartWindow startWindow;


private boolean clicked;
	public OpenNewMenu() {
		clicked= false;
		

		this.setSize(350, 350);
		this.setTitle("New Game or Load Old Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(3,1,1,1));
		

		this.setLocation(350, 100);
		
		
		newgame = new JButton("NEW GAME");
		newgame.addActionListener(new startNewGame());
		oldgame= new JButton("LOAD OLD GAME");
		oldgame.addActionListener(new loadOldGame());
		
		this.add(newgame);
		this.add(oldgame);
		
		
		this.setVisible(true);
		
		
		}
	public boolean isClicked(){
		return clicked;
		
	}
	private class startNewGame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//startWindow = new StartWindow();
			dispose();
		
	}
	}
		private class loadOldGame implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				clicked= true;
				dispose();
				
			
		}
		}
	
}
