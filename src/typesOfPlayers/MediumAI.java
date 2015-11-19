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
	public Territory deployArmy(ArrayList<Territory> territories) {
		System.out.println("Infinite?");
		int armiesToPlace = super.getNumOfArmies();
		int smallestNumOfArmies, indexOfSmallestArmies = 0;
		smallestNumOfArmies = territories.get(0).getUnits();
		for (int i = 1; i < territories.size(); i++) {
			if (smallestNumOfArmies > territories.get(i).getUnits()) {
				smallestNumOfArmies = territories.get(i).getUnits();
				indexOfSmallestArmies = i;
			}
		}
		return territories.get(indexOfSmallestArmies);

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
		int smallestNumOfArmies, indexOfSmallestArmies = 0;
		smallestNumOfArmies = connected.get(0).getUnits();

		for (int i = 1; i < connected.size(); i++) {
			if (smallestNumOfArmies > connected.get(i).getUnits() && connected.get(i).getOwner() != this) {
				smallestNumOfArmies = connected.get(i).getUnits();
				indexOfSmallestArmies = i;
			}
		}

		if (currentTerr.getUnits() - smallestNumOfArmies > 2) {
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
	public void fortifyPosition(Territory currentTerr, ArrayList<Territory> connected) {
		int smallestNumOfArmies, indexOfSmallestArmies = -1;
		smallestNumOfArmies = currentTerr.getUnits();
		for (int i = 0; i < connected.size(); i++) {
			if (connected.get(i).getOwner() == this) {
				if (smallestNumOfArmies > connected.get(i).getUnits()) {
					smallestNumOfArmies = connected.get(i).getUnits();
					indexOfSmallestArmies = i;
				}
			}
		}

		if (indexOfSmallestArmies != -1) {
			if (currentTerr.getUnits() > 3) {
				int armiesToMove = currentTerr.getUnits() - 3;
				connected.get(indexOfSmallestArmies).addUnits(armiesToMove);
				currentTerr.addUnits((-1) * armiesToMove);
			}
		}
	}

}
