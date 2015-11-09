package model;

import java.util.Random;

public class EasyAI extends Player implements AIStrategy {

	Random r;
	int randomChoice;

	public EasyAI() {
		r = new Random();
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
