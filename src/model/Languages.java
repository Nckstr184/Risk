package model;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JButton;

public class Languages extends Continent {
	ArrayList<Territory> LangTerr;
	public Languages(String cName, ArrayList<Territory> cTerritories,boolean cConquered) {
		super(cName, cTerritories, cConquered);
		
		Player currentPlayer = null;//get current player
		JButton button= new JButton("0");
		// Sting name, Point tcoords, JButton tbutton, Player owner, int numOfUnits
		LangTerr.add(0, new Territory("Java",new Point(600,130), button, currentPlayer, 0));
		LangTerr.add(1, new Territory("Python",new Point(710,120), button, currentPlayer, 0));
		LangTerr.add(2, new Territory("C",new Point(600,180), button, currentPlayer, 0));
		LangTerr.add(3, new Territory("SQL",new Point(670,160), button, currentPlayer, 0));
		LangTerr.add(4, new Territory("Ruby",new Point(660,220), button, currentPlayer, 0));
		LangTerr.add(5, new Territory("Git",new Point(730,190), button, currentPlayer, 0));
		LangTerr.add(6, new Territory("Perl",new Point(790,180), button, currentPlayer, 0));

		
	}
}
