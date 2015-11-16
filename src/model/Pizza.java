package model;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JButton;

public class Pizza extends Continent {
	ArrayList<Territory> pizzaTerr;
	public Pizza(String cName, boolean cConquered) {
		super(cName, cConquered);

		pizzaTerr = new ArrayList<Territory>();
		Player currentPlayer = null;//get current player
		JButton button= new JButton("0");
		// Sting name, Point tcoords, JButton tbutton, Player owner, int numOfUnits
		pizzaTerr.add(0, new Territory("Papa Johns",new Point(130,360), button, currentPlayer, 0));
		pizzaTerr.add(1, new Territory("Dominos",new Point(200,370), button, currentPlayer, 0));
		pizzaTerr.add(2, new Territory("PizzaHut",new Point(160,320), button, currentPlayer, 0));
		pizzaTerr.add(3, new Territory("BlackJack",new Point(150,280), button, currentPlayer, 0));
		pizzaTerr.add(4, new Territory("Hungry Howies",new Point(210,290), button, currentPlayer, 0));
		pizzaTerr.add(5, new Territory("Brooklyn's",new Point(250,300), button, currentPlayer, 0));
		pizzaTerr.add(6, new Territory("Mama's",new Point(280,260), button, currentPlayer, 0));

		
	}
	
	public ArrayList<Territory> getTerritories() {
		return pizzaTerr;
	}
}
