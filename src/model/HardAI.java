package model;

import java.awt.Color;
import java.util.ArrayList;

public class HardAI extends Player implements AIStrategy{

	public HardAI(String name, Color color, int numOfArmies) {
		super(name, color, numOfArmies);
	}

	@Override
	public Territory deployArmy(ArrayList<Territory> territories) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean chooseRetreat(Territory currentTerr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Territory attackTerritory(Territory currentTerr, ArrayList<Territory> connected) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fortifyPosition(Territory currentTerr, ArrayList<Territory> connected) {
		// TODO Auto-generated method stub
		
	}


}
