package model;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JButton;

public class Sun extends Continent {
	ArrayList<Territory> sunTerr;
	public Sun(String cName, ArrayList<Territory> cTerritories,boolean cConquered) {
		super(cName, cTerritories, cConquered);
		
		Player currentPlayer = null;//get current player
		JButton button= new JButton("0");
		// Sting name, Point tcoords, JButton tbutton, Player owner, int numOfUnits
		sunTerr.add(0, new Territory("Apollo",new Point(300,200), button, currentPlayer, 0));
		sunTerr.add(1, new Territory("Ra",new Point(360,170), button, currentPlayer, 0));
		sunTerr.add(2, new Territory("Helios",new Point(420,180), button, currentPlayer, 0));
		sunTerr.add(3, new Territory("Inti",new Point(430,230), button, currentPlayer, 0));
		sunTerr.add(4, new Territory("Horus",new Point(400,260), button, currentPlayer, 0));
		sunTerr.add(5, new Territory("Tonatiuh",new Point(350,260), button, currentPlayer, 0));
		sunTerr.add(6, new Territory("Amun",new Point(360,210), button, currentPlayer, 0));
	
	}
}
