package model;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Player implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 637979960045413951L;
	/**
	 * 
	 */
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
		numOfArmies += numArmies;
	}

	public void removeArmies(int numArmies) {
		// System.out.println("This should print as many times as the number
		// above");
		numOfArmies -= numArmies;
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
		for (int index = 0; index < playerTerritories.size(); index++) {
			String temp = playerTerritories.get(index).getName();
			if (temp != null) {
				if (removedTerritory.getName().equals(temp)) {
					playerTerritories.remove(index);
				}
			}
		}
	}

	public void removeCard(List<Card> removeTheseCards) {
		for (int i = 0; i < removeTheseCards.size(); i++) {
			int index = playerCards.indexOf(removeTheseCards.get(i));
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
		if (playerCards.size() < 3)
			return false;

		// 3 of same type or using wilds
		ArrayList<Card> indexes = new ArrayList<Card>();
		for (int i = 0; i < playerCards.size(); i++) {
			indexes.clear();
			indexes.add(playerCards.get(i));
			for (int j = i + 1; j < playerCards.size(); j++) {
				if ((playerCards.get(i).getType().equals(playerCards.get(j).getType())
						|| playerCards.get(j).getType().equals(CardType.WILD))) {
					indexes.add(playerCards.get(j));
				}
			}
			if (indexes.size() >= 3) {
				for (int k = 0; k < 3; k++) {
					playerCards.remove(indexes.get(k));
				}
				return true;
			}
		}
		// System.out.println(playerCards.size());
		indexes.clear();
		ArrayList<CardType> availableType = new ArrayList<CardType>();
		availableType.add(CardType.GARY);
		availableType.add(CardType.PATRICK);
		availableType.add(CardType.SPONGEBOB);
		for (int j = 0; j < playerCards.size(); j++) {
			if (availableType.indexOf(playerCards.get(j).getType()) != -1) {
				availableType.remove(availableType.indexOf(playerCards.get(j).getType()));
				indexes.add(playerCards.get(j));
			}
		}
		if (availableType.size() == 0) {
			for (int k = 0; k < 3; k++) {
				playerCards.remove(indexes.get(k));
			}
			return true;
		}

		// if there is no card able to be turned in then it returns false
		return false;
	}

	abstract public void startGame();

	abstract public ArrayList<Object> deployArmy();

	abstract public boolean chooseRetreat(Territory currentTerr);

	abstract public Territory attackTerritory(Territory currentTerr, ArrayList<Territory> connected);

	abstract public ArrayList<Object> fortifyPosition(Territory currentTerr, ArrayList<Territory> connected);
}
