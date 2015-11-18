package typesOfPlayers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import model.Player;
import model.Territory;

public class EasyAI extends Player implements AIStrategy {
	
	Random r;
	int randomChoice, numOfArmies;
	ArrayList<Territory> territories;

	public EasyAI(String name, Color color, int numOfArmies) {
		super(name, color, numOfArmies);
		r = new Random();
	}
	
	public void startGame() {
		// use list from GameLogic to know what territories are open
		territories = getTerritories();
		int count = 0;
		Territory current = territories.get(count);
		while(current != null) {
			
		}
	}
	
	public ArrayList<Territory> returnTerritories()
	{
		return territories;
	}
	

	@Override
	public Territory deployArmy(ArrayList<Territory> territories) {
		// choose random territories to add reward units
		int rand = r.nextInt(territories.size());
		Territory temp = territories.get(rand);
		return temp;
	}

	@Override
	public boolean chooseRetreat(Territory currentTerr) {
		// chooses whether to retreat in the middle of battle
		int rand = r.nextInt(2);
		if(rand == 0)
			return true;
		else
			return false;
	}

	@Override
	public Territory attackTerritory(Territory currentTerr, ArrayList<Territory> connected) {
		// chooses a random connected territory to attack, as long
		// as there is more than one army in it
		int rand = r.nextInt(2);
		if(rand == 0) {
			do {
			rand = r.nextInt(connected.size());
			} while(connected.get(rand).getOwner() != this);
			return connected.get(rand);
		}
		// returns null if it decides to not attack
		return null;
	}

	@Override
	public void fortifyPosition(Territory currentTerr, ArrayList<Territory> connected) {
		// randomly decides to move armies to friendly connected territory
		int rand = r.nextInt(2);
		if(rand == 0) {
			rand = r.nextInt(connected.size());
			Territory temp = connected.get(rand);
			int armySize = this.getNumOfArmies();
			rand = r.nextInt(armySize-1);
			
			temp.addUnits(rand);
		}
	}

}
