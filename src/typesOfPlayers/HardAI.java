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
		int highestNumberOfArmies = 1;
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
					for (int neighborIndex = 0; neighborIndex < neighbors.size(); neighborIndex++) {
						if (temp.getName().equals(neighbors.get(neighborIndex).getName())) {
							armySum += neighbors.get(j).getUnits();
						}
					}
				}
			}
			if (highestNumberOfArmies < armySum) {
				highestNumberOfArmies = armySum;
				indexOfHighest = i;
			}
		}
		System.out.println("Number of Territories: " + getTerritories().size());

		returns.add(getTerritories().get(indexOfHighest));
		returns.add(1);

		return returns;
//		int highestNumberOfArmies = 0;
//		int armySum;
//		int indexOfHighest = 0;
//		int armyDifference = 0;
//		Territory temp;
//		Player tempPlayer;
//		ArrayList<Territory> neighbors = new ArrayList<Territory>();
//		ArrayList<Object> returns = new ArrayList<Object>();
//		for (int i = 0; i < territories.size(); i++) {
//			temp = territories.get(i);
//			neighbors = temp.getNeighbors();
//			armySum = 0;
//			for (int j = 0; j < neighbors.size(); j++) {
//				tempPlayer = neighbors.get(j).getOwner();
//				if (!temp.getName().equals(this.getName())) {
//					armySum += neighbors.get(j).getUnits();
//				}
//
//			}
//			armyDifference = armySum - temp.getUnits();
//
//			if (highestNumberOfArmies < armyDifference) {
//				highestNumberOfArmies = armyDifference;
//				indexOfHighest = i;
//			}
//		}
//
//		//System.out.println(highestNumberOfArmies);
//		
//		returns.add(territories.get(indexOfHighest));
//		returns.add(highestNumberOfArmies);
//
//		return returns;
	}

	private ArrayList<Object> deployArmy(ArrayList<Territory> territories) {
		/*
		 * Use the total number of enemy armies surrounding the territory to
		 * figure out how many armies to place in a certain territory. You want
		 * to make sure you are powerful enough to withstand an attack from any
		 * angle
		 */
		int highestNumberOfArmies = 0;
		int armySum;
		int indexOfHighest = 0;
		int armyDifference = 0;
		Territory temp;
		Player tempPlayer;
		ArrayList<Territory> neighbors = new ArrayList<Territory>();
		ArrayList<Object> returns = new ArrayList<Object>();
		for (int i = 0; i < territories.size(); i++) {
			temp = territories.get(i);
			neighbors = temp.getNeighbors();
			armySum = 0;
			for (int j = 0; j < neighbors.size(); j++) {
				tempPlayer = neighbors.get(j).getOwner();
				if (!temp.getName().equals(this.getName())) {
					armySum += neighbors.get(j).getUnits();
				}

			}
			armyDifference = armySum - temp.getUnits();

			if (highestNumberOfArmies < armyDifference) {
				highestNumberOfArmies = armyDifference;
				indexOfHighest = i;
			}
		}

		//System.out.println(highestNumberOfArmies);
		
		returns.add(territories.get(indexOfHighest));
		returns.add(highestNumberOfArmies);

		return returns;

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
		 * territoryAndArmyNum.add(TerritoryToFortify);
		 * territoryAndArmyNum.add(NumberOfArmiesToMove);
		 */
		ArrayList<Territory> friendlyConnected = new ArrayList<Territory>();
		ArrayList<Object> deployTerrAndArmy = new ArrayList<Object>();
		ArrayList<Territory> enemies = new ArrayList<Territory>();
System.out.println(connected.size());
		for (int i = 0; i < connected.size(); i++) {
			if (connected.get(i).getOwner().getName().equals(currentTerr.getOwner().getName())) {
				friendlyConnected.add(connected.get(i));
			}
			if (!connected.get(i).getOwner().getName().equals(currentTerr.getOwner().getName())
					&& !enemies.contains(connected.get(i))) {
				enemies.add(connected.get(i));
			}
		}
System.out.println(friendlyConnected.size());


		//System.out.println(friendlyConnected.size());
if(friendlyConnected.size()!=0)
{
		deployTerrAndArmy = deployArmy(friendlyConnected);
		int totalEnemiesSorrounding;
		Player currentEnemy;
		for (int i = 0; i < enemies.size(); i++) {
			currentEnemy = enemies.get(i).getOwner();
			int totalEnemyUnits = 0;
			for (int j = 0; j < enemies.size(); j++) {
				if (currentEnemy.getName().equals(enemies.get(j))) {
					totalEnemyUnits += enemies.get(j).getUnits();
				}

			}
			if (currentTerr.getUnits() < totalEnemyUnits) {
				deployTerrAndArmy.set(1, 0);
			}
		}
}
else
{
	deployTerrAndArmy.add(currentTerr);
	deployTerrAndArmy.add(0);
}
	//	System.out.println(deployTerrAndArmy.get(1));
		return deployTerrAndArmy;
	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		
	}

}
