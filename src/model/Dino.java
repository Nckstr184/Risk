package model;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JButton;

public class Dino extends Continent {

	ArrayList<Territory> dinoTerr;
	public Dino(String cName, boolean cConquered) {
		super(cName, cConquered);
		
		dinoTerr = new ArrayList<Territory>();
		Player currentPlayer = null;//get current player
		JButton button= new JButton("0");
		// Sting name, Point tcoords, JButton tbutton, Player owner, int numOfUnits
		dinoTerr.add(0, new Territory("Rawrville",new Point(880,280), button, currentPlayer, 0));
		dinoTerr.add(1, new Territory("Laiegges",new Point(830,330), button, currentPlayer, 0));
		dinoTerr.add(2, new Territory("Dactilito",new Point(830,410), button, currentPlayer, 0));
		dinoTerr.add(3, new Territory("Dirtydan",new Point(770,410), button, currentPlayer, 0));
		dinoTerr.add(4, new Territory("BlackBeard",new Point(790,470), button, currentPlayer, 0));
		dinoTerr.add(5, new Territory("Monisaurus",new Point(730,520), button, currentPlayer, 0));
		dinoTerr.add(6, new Territory("ToyStory",new Point(840,520), button, currentPlayer, 0));

		
	}
	
	public ArrayList<Territory> getTerritories() {
		return dinoTerr;
	}

	@Override
	public boolean isConquered() {
		int count = 0;
		String player = dinoTerr.get(0).getOwner().getName();
		for(int i=1;i<dinoTerr.size();i++) {
			if(dinoTerr.get(i).getOwner().getName().equals(player)){
				count++;
			}
		}
		if(count == (dinoTerr.size()-1))
			return true;
		
		return false;
	}
}
