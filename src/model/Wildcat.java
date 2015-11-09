package model;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JButton;

public class Wildcat extends Continent {
	ArrayList<Territory> wildTerr;
	public Wildcat(String cName, ArrayList<Territory> cTerritories,boolean cConquered) {
		super(cName, cTerritories, cConquered);
		
		Player currentPlayer = null;//get current player
		JButton button= new JButton("0");
		// Sting name, Point tcoords, JButton tbutton, Player owner, int numOfUnits
		wildTerr.add(0, new Territory("Wilber",new Point(250,380), button, currentPlayer, 0));
		wildTerr.add(1, new Territory("Wilma",new Point(340,390), button, currentPlayer, 0));
		wildTerr.add(2, new Territory("Rich",new Point(320,440), button, currentPlayer, 0));
		wildTerr.add(3, new Territory("Miller",new Point(420,420), button, currentPlayer, 0));
		wildTerr.add(4, new Territory("Scooby",new Point(210,460), button, currentPlayer, 0));
		wildTerr.add(5, new Territory("McKale",new Point(320,500), button, currentPlayer, 0));
		wildTerr.add(6, new Territory("Zona",new Point(270,540), button, currentPlayer, 0));

		
	}
}
