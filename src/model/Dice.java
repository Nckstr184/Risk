package model;

import java.util.ArrayList;

public class Dice {

	private int diceRolled, numOfDice;
	private double tempDice;
	
	private Dice tester;
	ArrayList<Integer> diceList = new ArrayList<Integer>();

	public Dice(int numOfDiceRolled) {
		this.numOfDice = numOfDiceRolled;
		
		if (numOfDice == 3) {
			diceList.add(rollDice());
			diceList.add(rollDice());
			diceList.add(rollDice());

		}
		if (numOfDice == 2) {
			diceList.add(rollDice());
			diceList.add(rollDice());

		}
		if (numOfDice == 1) {
			diceList.add(rollDice());

		}

	}

	public int rollDice() {
		int max = 7;
		int min = 1;
		diceRolled = (int) (Math.random() * (max - min) + min);

		return diceRolled;
	}

	public ArrayList<Integer> getDice() {
		return diceList;
	}

	public int getDice1() {
		return diceList.get(0);
	}

	public int getDice2() {
		return diceList.get(2);
	}

	public int getDice3() {
		return diceList.get(3);
	}

}
