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
	
	public Territory(String name, Point tcoords, JButton tbutton, Player owner, int numOfUnits){
		coords=tcoords;
		button=tbutton;
		player=owner;
		units= numOfUnits;
		tname=name;
		neighbors=new ArrayList<Territory>();
	}
	public String getname(){
		return tname;
	}
	public Point getPoint(){
		return coords;
	}
	public double getX(){
		x= coords.getX();
		return x;
	}
	public double getY(){
		y= coords.getY();
		return y;
	}
	public ArrayList<Territory> getNeighbors()
	{
		return neighbors;
	}
	
	public void addNeighbors(Territory newTerr)
	{
		neighbors.add(newTerr);
	}
	
	public Territory getTerrAt(String name)
	{
		int index=neighbors.indexOf(name);
		return neighbors.get(index);
	}
	public JButton getButton(){
		return button;
	}
	public Player getOwner(){
		return player;
	}
	public void addUnits(int unitNum) {
		units += unitNum;
	}
	public int getUnits(){
		return units;
	}


}
