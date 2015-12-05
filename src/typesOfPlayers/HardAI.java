package typesOfPlayers;

import java.awt.Color;
import java.util.ArrayList;

import model.Player;
import model.Territory;

public class HardAI extends Player implements AIStrategy {
	/*
	 * Basically this entire AI is developed on making sure you are more
	 * powerful than the territories surrounding you. HardAI probably won't
	 * attack much and takes more of a defensive stand, letting Easy, Medium,
	 * and Human kill each other off and weaken each other
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = -7811415056177163383L;

	public HardAI(String name, Color color, int numOfArmies) {
		super(name, color, numOfArmies);
	}

	@Override
	public ArrayList<Object> deployArmy() {
		/*
		 * Use the total number of enemy armies surrounding the territory to
		 * figure out how many armies to place in a certain territory. You want
		 * to make sure you are powerful enough to withstand an attack from any
		 * angle
		 */
		int highestArmyDifference = 0;
		int armySum;
		int indexOfHighest = 0;
		Player temp;
		ArrayList<Territory> neighbors = new ArrayList<Territory>();
		ArrayList<Object> returns = new ArrayList<Object>();
		for (int i = 0; i < getTerritories().size(); i++) {
			neighbors = getTerritories().get(i).getNeighbors();
			armySum = 0;
			for (int j = 0; j < neighbors.size(); j++) {
				temp = neighbors.get(j).getOwner();
				if (!temp.getName().equals(this.getName())) {
					int armyDiff = neighbors.get(j).getUnits() - getTerritories().get(i).getUnits();
					if (highestArmyDifference < armyDiff) {
						highestArmyDifference = armyDiff;
						indexOfHighest = i;
					}
				}
			}
		}
		returns.add(getTerritories().get(indexOfHighest));
		returns.add(1);

		return returns;
	}

	private Territory deployArmy(ArrayList<Territory> territories) {
		/*
		 * Use the total number of enemy armies surrounding the territory to
		 * figure out how many armies to place in a certain territory. You want
		 * to make sure you are powerful enough to withstand an attack from any
		 * angle
		 */
		int highestArmyDifference = 0;
		int indexOfHighest = 0;
		Player temp;
		ArrayList<Territory> neighbors = new ArrayList<Territory>();
		ArrayList<Object> returns = new ArrayList<Object>();
		for (int i = 0; i < territories.size(); i++) {
			neighbors = territories.get(i).getNeighbors();
			for (int j = 0; j < neighbors.size(); j++) {
				temp = neighbors.get(j).getOwner();
				if (!temp.getName().equals(this.getName())) {
					int armyDiff = neighbors.get(j).getUnits() - territories.get(i).getUnits();
					if (highestArmyDifference < armyDiff) {
						highestArmyDifference = armyDiff;
						indexOfHighest = i;
					}
				}
			}
		}
		returns.add(territories.get(indexOfHighest));

		return (Territory) returns.get(0);
	}

	@Override
	public boolean chooseRetreat(Territory currentTerr) {
		/*
		 * Use the total highest of enemy armies surrounding the territory to
		 * determine whether or not to retreat
		 */

		ArrayList<Territory> neighbors = currentTerr.getNeighbors();
		int highestArmies = 0;
		for (int j = 0; j < neighbors.size(); j++) {
			if (highestArmies < neighbors.get(j).getUnits()
					&& !neighbors.get(j).getOwner().getName().equals(currentTerr.getOwner().getName())) {
				highestArmies = neighbors.get(j).getUnits();
			}
		}
		if (currentTerr.getUnits() - highestArmies > 3) {
			return false;
		}

		return true;
	}

	@Override
	public Territory attackTerritory(Territory currentTerr, ArrayList<Territory> connected) {
		/*
		 * Choose the territory with the biggest difference in armies in order
		 * to win the easiest and get a card. chooseRetreat will take care of
		 * stopping attacking
		 * 
		 * Returns null if no armies can be attacked
		 */
		int lowestNumberOfArmies = 0;
		int indexOfLowest = 0;
		Territory temp;
		for (int i = 0; i < connected.size(); i++) {
			temp = connected.get(i);
			if (lowestNumberOfArmies < temp.getUnits() && !(temp.getName().equals(currentTerr.getOwner().getName()))) {
				if (temp.getUnits() < currentTerr.getUnits()) {
					lowestNumberOfArmies = connected.get(i).getUnits();
					indexOfLowest = i;
				}
			}
		}

		if (currentTerr.getUnits() - lowestNumberOfArmies > 3) {
			return connected.get(indexOfLowest);
		}

		return null;
	}

	@Override
	public ArrayList<Object> fortifyPosition(Territory currentTerr, ArrayList<Territory> connected) {
		/*
		 * Same idea as the rest, make sure that you fortify if one of your
		 * connected territories doesn't have enough. But make sure you don't
		 * weaken yourself while doing this.
		 * 
		 * Use deploy army to check each friendly location's numOfArmies
		 * surrounding it and find which has the lowest. Then compare that to
		 * how many you have surrounding yourself. If you can't spare sending
		 * armies then don't
		 * 
		 * RETURN AN ARRAY LIST WITH THE FIRST INDEX BEING THE TERRITORY AND THE
		 * SECOND BEING AN INT.
		 * 
		 */
		Territory deployTerr;
		int highestNumOfArmies = 0;
		int armiesToMove;

		ArrayList<Territory> friendlyConnected = new ArrayList<Territory>();
		ArrayList<Object> deployTerrAndArmy = new ArrayList<Object>();
		for (int i = 0; i < connected.size(); i++) {
			if (connected.get(i).getOwner().getName().equals(currentTerr.getOwner().getName())) {
				friendlyConnected.add(connected.get(i));
			}
		}
		// System.out.println(friendlyConnected.size());

		if (friendlyConnected.size() > 0) {
			deployTerr = deployArmy(friendlyConnected);
			
			/*
			 * Checks surrounding enemies to see how many armies HardAI can
			 * spare for it's ally
			 */

			for (int i = 0; i < currentTerr.getNeighbors().size(); i++) {
				if (!currentTerr.getNeighbors().get(i).getOwner().getName().equals(this.getName()))
					if (highestNumOfArmies < currentTerr.getNeighbors().get(i).getUnits()) {
						highestNumOfArmies = currentTerr.getNeighbors().get(i).getUnits();
					}
			}
			armiesToMove = currentTerr.getUnits() - highestNumOfArmies - 2;
			if(armiesToMove > 0) {
				deployTerrAndArmy.add(deployTerr);
				deployTerrAndArmy.add(armiesToMove);
				
				return deployTerrAndArmy;
			}
		}
		return null;
	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub

	}

}
