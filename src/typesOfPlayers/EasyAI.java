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
		while (current != null) {

		}
	}

	public ArrayList<Territory> returnTerritories() {
		return territories;
	}

	@Override
	public Territory deployArmy(ArrayList<Territory> territories) {
		// choose random territories to add reward units
		System.out.println(territories.size());
		int rand = r.nextInt(territories.size());
		Territory temp = territories.get(rand);
		return temp;
	}

	@Override
	public boolean chooseRetreat(Territory currentTerr) {
		// chooses whether to retreat in the middle of battle
		if (currentTerr.getUnits() > 1) {
			int rand = r.nextInt(2);
			if (rand == 0)
				return false;
		}
		return true;
	}

	@Override
	public Territory attackTerritory(Territory currentTerr, ArrayList<Territory> connected) {
		// System.out.println("AttackTerritory call");
		// chooses a random connected territory to attack, as long
		// as there is more than one army in it
		int rand = r.nextInt(2);
		int count = 0;
		ArrayList<Territory> availableTerritories = new ArrayList<Territory>(connected);

		if (rand == 0) {
			do {
				rand = r.nextInt(connected.size());
				if (availableTerritories.indexOf(connected.get(rand)) != -1) {
					availableTerritories.remove(availableTerritories.indexOf(connected.get(rand)));
				}
				if(availableTerritories.size() == 0 && availableTerritories.indexOf(connected.get(rand)) == -1){
					return null;
				}
			} while (connected.get(rand).getOwner().getName().equals(this.getName())
					&& availableTerritories.size() > 0);


			// System.out.println("Returning territory");
			return connected.get(rand);
		}
		// returns null if it decides to not attack
		// System.out.println("Returning null");
		return null;
	}

	@Override
	public void fortifyPosition(Territory currentTerr, ArrayList<Territory> connected) {
		// randomly decides to move armies to friendly connected territory
		int rand = r.nextInt(2);
		
		if (rand == 0) {
			Territory temp = null;
			for (int i = 0; i < connected.size(); i++) {
				temp = connected.get(i);
				if (!temp.getOwner().getName().equals(this.getName()))
					break;
			}

			int armySize = this.getNumOfArmies();
			if (armySize > 0) {
				rand = r.nextInt(armySize - 1);

				temp.addUnits(rand);
			}
		}
	}

}