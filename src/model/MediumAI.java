package model;

import java.awt.Color;
import java.util.ArrayList;

public class MediumAI extends Player implements AIStrategy{

	ArrayList<Territory> territories;
	public MediumAI(String name, Color color, int numOfArmies) {
		super(name, color, numOfArmies);
	}

	@Override
	public void deployArmy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean chooseRetreat() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void attackTerritory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fortifyPosition() {
		// TODO Auto-generated method stub
		
	}

}
