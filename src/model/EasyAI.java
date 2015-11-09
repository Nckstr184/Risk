package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

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
	

	@Override
	public void deployArmy() {
		// choose random territories to add reward units
	}

	@Override
	public boolean chooseRetreat() {
		// chooses whether to retreat in the middle of battle
		return false;
	}

	@Override
	public void attackTerritory() {
		// chooses a random connected territory to attack, as long
		// as there is more than one army in it

	}

	@Override
	public void fortifyPosition() {
		// randomly decides to move armies to friendly connected territory
	}

}
