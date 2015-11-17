package model;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Sun extends Continent {
	ArrayList<Territory> sunTerr;
	public Sun(String cName, boolean cConquered) {
		super(cName, cConquered);
		
		sunTerr = new ArrayList<Territory>();
		Player currentPlayer = null;//get current player
		ImageIcon gray1= new ImageIcon("./Pictures/circle.png");
		
		JButton sun1= new JButton(gray1);
		JButton sun2= new JButton(gray1);
		JButton sun3= new JButton(gray1);
		JButton sun4= new JButton(gray1);
		JButton sun5= new JButton(gray1);
		JButton sun6= new JButton(gray1);
		JButton sun7= new JButton(gray1);
		
		// Sting name, Point tcoords, JButton tbutton, Player owner, int numOfUnits
		sunTerr.add(0, new Territory("Apollo",new Point(300,200), sun1, currentPlayer, 0));
		sunTerr.add(1, new Territory("Ra",new Point(360,170), sun2, currentPlayer, 0));
		sunTerr.add(2, new Territory("Helios",new Point(420,180), sun3, currentPlayer, 0));
		sunTerr.add(3, new Territory("Inti",new Point(430,230), sun4, currentPlayer, 0));
		sunTerr.add(4, new Territory("Horus",new Point(400,260), sun5, currentPlayer, 0));
		sunTerr.add(5, new Territory("Tonatiuh",new Point(350,260), sun6, currentPlayer, 0));
		sunTerr.add(6, new Territory("Amun",new Point(360,210), sun7, currentPlayer, 0));
	
	}
	public ArrayList<Territory> getTerritories() {
		return sunTerr;
	}
	
}
