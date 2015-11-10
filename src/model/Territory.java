package model;

import java.awt.Point;

import javax.swing.JButton;

public class Territory {
	
	Point coords;
	JButton button;
	Player player;
	int units;
	double x;
	double y;
	String tname;
	
	public Territory(String name, Point tcoords, JButton tbutton, Player owner, int numOfUnits){
		coords=tcoords;
		button=tbutton;
		player=owner;
		units= numOfUnits;
		tname=name;
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
