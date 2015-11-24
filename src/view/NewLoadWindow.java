package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NewLoadWindow extends JFrame {
	
	JPanel window;
	JButton newButton, loadButton;
	
	
	public NewLoadWindow(){
		
		this.setLocation(200,200);
		this.setSize(300,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		window = new JPanel();
		window.setSize(300,400);
		window.setLocation(0, 0);
		
		newButton = new JButton();
		newButton.addActionListener(new newButtonListener());
		
		
		this.add(window);
		
		
	}
	
	private class newButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}

}
