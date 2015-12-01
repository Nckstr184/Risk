package typesOfPlayers;

import java.awt.Color;
import java.util.ArrayList;

import model.Player;
import model.Territory;

public class MediumAI extends Player implements AIStrategy {

	ArrayList<Territory> territories;

	public MediumAI(String name, Color color, int numOfArmies) {
		super(name, color, numOfArmies);
	}

	// returns the territory with the least amount of armies
	@Override
	public ArrayList<Object> deployArmy() {
		// System.out.println("Infinite?");
		ArrayList<Object> mediumInfo=new ArrayList<Object>();
		int smallestNumOfArmies, indexOfSmallestArmies = 0;
		smallestNumOfArmies = getTerritories().get(0).getUnits();
		for (int i = 1; i < getTerritories().size(); i++) {
			if (smallestNumOfArmies > getTerritories().get(i).getUnits()) {
				smallestNumOfArmies = getTerritories().get(i).getUnits();
				indexOfSmallestArmies = i;
			}
		}
		mediumInfo.add(getTerritories().get(indexOfSmallestArmies));
		mediumInfo.add(0);
		return mediumInfo;

	}

	// If this number of territories in the current Territory is less than 3, it
	// returns true in order to retreat. BattleLogic will be listening for the
	// boolean after every attack.

	@Override
	public boolean chooseRetreat(Territory currentTerr) {
		if (currentTerr.getUnits() < 3)
			return true;

		return false;
	}

	// checks the neighbors of a territory and finds the one with the smallest
	// number of armies. If the difference is greater than 2, then it attacks.
	// If it does not satisfy this, then it returns a null (flag to not attack
	// anything)

	@Override
	public Territory attackTerritory(Territory currentTerr, ArrayList<Territory> connected) {
		int smallestNumOfArmies, indexOfSmallestArmies = -1;
		smallestNumOfArmies = 0;

		for (int i = 0; i < connected.size(); i++) {
			if (smallestNumOfArmies > connected.get(i).getUnits()
					&& !connected.get(i).getOwner().getName().equals(currentTerr.getOwner().getName())) {
				smallestNumOfArmies = connected.get(i).getUnits();
				indexOfSmallestArmies = i;
			}
		}

		if (currentTerr.getUnits() - smallestNumOfArmies > 2 && indexOfSmallestArmies != -1) {
			return connected.get(indexOfSmallestArmies);
		}

		return null;
	}
	// finds the friendly connected territory with the least amount of armies.
	// If the current Territory has more than 3 armies, it moves its current
	// amount of armies minus 3. If no friendly connected territory has less
	// armies than the current Territory, then no armies are moved.
	// SHOULD ONLY BE CALLED ONCE MAX AT THE END OF THE TURN

	@Override
	public ArrayList<Object> fortifyPosition(Territory currentTerr, ArrayList<Territory> connected) {
		int smallestNumOfArmies, indexOfSmallestArmies = -1;
		ArrayList<Object> territoryAndArmyNum = new ArrayList<Object>();
		smallestNumOfArmies = currentTerr.getUnits();
		for (int i = 0; i < connected.size(); i++) {
			if (connected.get(i).getOwner().getName().equals(currentTerr.getOwner().getName())) {
				if (smallestNumOfArmies > connected.get(i).getUnits()) {
					smallestNumOfArmies = connected.get(i).getUnits();
					indexOfSmallestArmies = i;
				}
			}
		}

		int armiesToMove = 0;
		if (indexOfSmallestArmies != -1) {
			territoryAndArmyNum.add(connected.get(indexOfSmallestArmies));
			if (currentTerr.getUnits() > 3) {
				armiesToMove = currentTerr.getUnits() - 3;
			}
			territoryAndArmyNum.add((-1) * armiesToMove);
		}
		if (territoryAndArmyNum.size() != 0)
			return territoryAndArmyNum;

		return null;
	}

}
