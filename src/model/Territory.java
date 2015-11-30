package model;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JButton;

public class Territory {

	Point coords;
	JButton button;
	Player player;
	int units;
	double x;
	double y;
	String tname;
	ArrayList<Territory> neighbors;

	public Territory(String name, Point tcoords, JButton tbutton, Player owner, int numOfUnits) {
		coords = tcoords;
		button = tbutton;
		player = owner;
		units = numOfUnits;
		tname = name;
		neighbors = new ArrayList<Territory>();
	}

	public String getname() {
		return tname;
	}

	public Point getPoint() {
		return coords;
	}

	public double getX() {
		x = coords.getX();
		return x;
	}

	public double getY() {
		y = coords.getY();
		return y;
	}

	public ArrayList<Territory> getNeighbors() {
		return neighbors;
	}

	public void addNeighbors(Territory newTerr) {
		neighbors.add(newTerr);
	}

	public Territory getTerrAt(String name) {
		int index = neighbors.indexOf(name);
		return neighbors.get(index);
	}

	public JButton getButton() {
		return button;
	}

	public void setOwner(Player player) {
		this.player = player;
	}
	public Player getOwner() {
		return player;
	}

	public void addUnits(int unitNum) {
		units += unitNum;
	}
	
	public void removeUnits(int unitNum) {
		units -= unitNum;
	}

	public int getUnits() {
		return units;
	}

	public int findDifferentPlayersArround()
	{
		
		int numOfNeighbors=this.getNeighbors().size();
		Player temp=this.getOwner();
		String ownerName=this.getOwner().getName();
		ArrayList<Player> differentPlayers=new ArrayList<Player>();
		for(int i=0; i<numOfNeighbors; i++)
		{
			temp=neighbors.get(i).getOwner();
			if((temp.getName().compareTo(ownerName)!=0)&&(!differentPlayers.contains(temp)))
			{
			differentPlayers.add(temp);
			}
		}
		return differentPlayers.size();
		
	}
//	public boolean checkIfContinentIsConquered() {
//		// TODO Auto-generated method stub
//		for(int index=0; index<neighbors.size(); index++)
//		{
//			Territory temp=neighbors.get(index);
//			if()
//		}
//	}

}
