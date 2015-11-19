package model;

import java.awt.Color;
import java.util.ArrayList;

public abstract class Player {

	private String name;
	private Color playerColor;
	private ArrayList<Card> playerCards;
	private ArrayList<Territory> playerTerritories;
	private int numOfArmies;
	private int diceRoll;

	public Player(String name, Color color, int numOfArmies) {
		this.name = name;
		this.playerColor = color;
		this.numOfArmies = numOfArmies;
		playerCards = new ArrayList<Card>();
		playerTerritories = new ArrayList<Territory>();
	}

	public ArrayList<Territory> getTerritories() {
		return playerTerritories;
	}

	public ArrayList<Card> getCards() {
		return playerCards;
	}

	public void addArmies(int numArmies) {
		numOfArmies = numOfArmies + numArmies;
	}

	public String getName() {
		return name;
	}

	public int getNumOfArmies() {
		return numOfArmies;
	}

	public Color returnColor() {
		return playerColor;
	}

	public void addCard(Card newCard) {
		playerCards.add(newCard);
	}

	public void addTerritories(Territory newTerritory) {
		playerTerritories.add(newTerritory);
	}

	public void removeTerritory(Territory removedTerritory) {
		int index = playerTerritories.indexOf(removedTerritory);
		if (index >= 0) {
			playerTerritories.remove(index);
		}
	}

	public void removeCard(Card removedCard) {
		int index = playerCards.indexOf(removedCard);
		if (index >= 0) {
			playerCards.remove(index);
		}
	}

	public void setDiceRoll(int roll) {
		diceRoll = roll;
	}

	public int getDiceRoll() {
		return diceRoll;
	}

	public String toString() {
		return name;
	}

	public boolean turnInCard() {
		if(playerCards.size() < 3)
			return false;
		
		// 3 of same type or using wilds
		int repeatCount;
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		for (int i = 0; i < playerCards.size(); i++) {
			indexes.clear();
			repeatCount = 0;
			indexes.add(i);
			for (int j = i + 1; j < playerCards.size(); j++) {
				if (i != j && (playerCards.get(i).getType().equals(playerCards.get(j).getType())
						|| playerCards.get(j).getType().equals(CardType.WILD))) {
					repeatCount++;
					indexes.add(j);
					if (indexes.size() == 3)
						break;
				}
			}
			if (repeatCount >= 3) {
				Card card = playerCards.get(indexes.get(0));
				for (int k = 0; k < 3; k++) {
					this.removeCard(playerCards.get(indexes.get(k)));
				}
				return true;
			}
		}

		repeatCount = 0;
		ArrayList<CardType> availableType = new ArrayList<CardType>();
		availableType.add(CardType.GARY);
		availableType.add(CardType.PATRICK);
		availableType.add(CardType.SPONGEBOB);
		for (int j = 0; j < playerCards.size(); j++) {
			if (availableType.indexOf(playerCards.get(j).getType()) != -1) {
				repeatCount++;
				availableType.remove(availableType.indexOf(playerCards.get(j).getType()));
				indexes.add(j);
				if (indexes.size() == 3)
					break;
			}
		}
		if (repeatCount >= 3) {
			for (int k = 0; k < 3; k++) {
				this.removeCard(playerCards.get(indexes.get(k)));
			}
			return true;
		}
		// if there is no card able to be turned in then it returns false
		return false;
	}

	public void startGame() {
	}

	public Territory deployArmy(ArrayList<Territory> territories) {
		return null;
	}

	public boolean chooseRetreat(Territory currentTerr) {
		return false;
	}

	public Territory attackTerritory(Territory currentTerr, ArrayList<Territory> connected) {
		return null;
	}

	public void fortifyPosition(Territory currentTerr, ArrayList<Territory> connected) {
	}
}
