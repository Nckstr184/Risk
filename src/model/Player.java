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
