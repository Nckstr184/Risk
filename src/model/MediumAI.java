package model;

import java.awt.Color;
import java.util.ArrayList;

public class MediumAI extends Player implements AIStrategy{

	ArrayList<Territory> territories;
	public MediumAI(String name, Color color, int numOfArmies) {
		super(name, color, numOfArmies);
	}
	@Override
	public Territory deployArmy(ArrayList<Territory> territories) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean chooseRetreat() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Territory attackTerritory(ArrayList<Territory> connected) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void fortifyPosition(ArrayList<Territory> connected) {
		// TODO Auto-generated method stub
		
	}

}
