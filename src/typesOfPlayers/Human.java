package typesOfPlayers;

import java.awt.Color;
import java.util.ArrayList;

import model.Player;
import model.Territory;

public class Human extends Player {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2317731050682682626L;

	public Human(String name, Color color, int numOfArmies) {
		super(name, color, numOfArmies);
	}

	@Override
	public ArrayList<Object> deployArmy() {
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
	public ArrayList<Object> fortifyPosition(Territory currentTerr, ArrayList<Territory> connected) {
		// TODO Auto-generated method stub
		return null;
	}

}
