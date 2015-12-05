package typesOfPlayers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import model.Player;
import model.Territory;

public class EasyAI extends Player implements AIStrategy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7374548339574929945L;
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
	public ArrayList<Object> deployArmy() {
		// choose random territories to add reward units
		// System.out.println(territories.size());
		ArrayList<Object> random = new ArrayList<Object>();
		int rand = r.nextInt(getTerritories().size());
		Territory temp = getTerritories().get(rand);
		random.add(temp);
		random.add(1);
		return random;
	}

	@Override
	public boolean chooseRetreat(Territory currentTerr) {
		// chooses whether to retreat in the middle of battle
		if (currentTerr.getUnits() > 1) {
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

		do {
			rand = r.nextInt(connected.size());
			if (availableTerritories.indexOf(connected.get(rand)) != -1) {
				availableTerritories.remove(availableTerritories.indexOf(connected.get(rand)));
			}
			if (availableTerritories.size() == 0 && availableTerritories.indexOf(connected.get(rand)) == -1) {
				return null;
			}
		} while (connected.get(rand).getOwner().getName().equals(this.getName()) && availableTerritories.size() > 0);

		// System.out.println("Returning territory");
		if (!connected.get(rand).getOwner().getName().equals(this.getName()))
			return connected.get(rand);
		// returns null if it decides to not attack
		//System.out.println("Returning null");
		return null;
	}

	@Override
	public ArrayList<Object> fortifyPosition(Territory currentTerr, ArrayList<Territory> connected) {
		// randomly decides to move armies to friendly connected territory
		int rand = r.nextInt(2);
		ArrayList<Object> territoryAndArmyNum = new ArrayList<Object>();

		Territory temp = null;
		if (rand == 0) {
			for (int i = 0; i < connected.size(); i++) {
				temp = connected.get(i);
				if (!temp.getOwner().getName().equals(this.getName()))
					break;
			}
			territoryAndArmyNum.add(temp);

			int armySize = currentTerr.getUnits();
			if (armySize > 1) {
				rand = r.nextInt(armySize - 1);
			}
			territoryAndArmyNum.add(rand);
			return territoryAndArmyNum;
		}
		return null;
	}

}
