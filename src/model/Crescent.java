package model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JButton;

import typesOfPlayers.Human;

import java.util.ArrayList;

public class Crescent extends Continent {
	ArrayList<Territory> cresTerr;
	public Crescent(String cName, boolean cConquered) {
		super(cName, cConquered);
		cresTerr = new ArrayList<Territory>();
		//WE NEED TO FIX THIS TO PULL IN THE CURRENT PLAYER
		Player currentPlayer = null;//get current player
		JButton button= new JButton("0");
		// Sting name, Point tcoords, JButton tbutton, Player owner, int numOfUnits
		cresTerr.add(0, new Territory("Scraptopia",new Point(580,430), button, currentPlayer, 0));
		cresTerr.add(1, new Territory("Land of Zach",new Point(420,640), button, currentPlayer, 0));
		cresTerr.add(2, new Territory("Giant",new Point(670,380), button, currentPlayer, 0));
		cresTerr.add(3, new Territory("New Land of Zach",new Point(690,450), button, currentPlayer, 0));
		cresTerr.add(4, new Territory("South Scraptopia",new Point(680,410), button, currentPlayer, 0));
		cresTerr.add(5, new Territory("Bloo Bawl",new Point(730,390), button, currentPlayer, 0));
		cresTerr.add(6, new Territory("Cresent Capital",new Point(770,350), button, currentPlayer, 0));

	}
	
	public ArrayList<Territory> getTerritories() {
		return cresTerr;
	}

	@Override
	public boolean isConquered() {
		int count = 0;
		String player = cresTerr.get(0).getOwner().getName();
		for(int i=1;i<cresTerr.size();i++) {
			if(cresTerr.get(i).getOwner().getName().equals(player)){
				count++;
			}
		}
		if(count == (cresTerr.size()-1))
			return true;
		
		return false;
	}
	
}
