package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Dice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9128934455085698074L;
	private int diceRolled, numOfDice;
	private double tempDice;

	private Dice tester;
	ArrayList<Integer> diceList = new ArrayList<Integer>();
	Integer[] diceListArray;

	public Dice(int numOfDiceRolled) {
		this.numOfDice = numOfDiceRolled;
		diceListArray = new Integer[numOfDiceRolled];

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

		for (int i = 0; i < numOfDice; i++) {
			diceListArray[i] = diceList.get(i);
		}

		// directly changes the diceList ArrayList and sorts in descending order
		InsertionSort(diceListArray);
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

	public int[] getDiceArray() {
		int[] temp = new int[diceList.size()];
		for (int i = 0; i < diceList.size(); i++)
			temp[i] = diceList.get(i);

		return temp;
	}

	public int getDice1() {
		return diceList.get(0);
	}

	public int getDice2() {
		return diceList.get(1);
	}

	public int getDice3() {
		return diceList.get(2);
	}

	public void setDice1(int number) {
		diceList.set(0, number);
	}

	public void setDice2(int number) {
		diceList.set(1, number);
	}

	public void setDice3(int number) {
		diceList.set(2, number);
	}

	public void InsertionSort(Integer[] objects) {
		int j; // the number of items sorted so far
		int key; // the item to be inserted
		int i;

		for (j = 1; j < objects.length; j++) // Start with 1 (not 0)
		{
			key = ((Integer) objects[j]);
			for (i = j - 1; (i >= 0) && (((Integer) objects[i]) < key); i--) // Smaller
																				// values
																				// move
																				// down
			{
				objects[i + 1] = objects[i];
			}
			(objects[i + 1]) = (key); // Put the key in its proper location
		}
		// set the values of diceList ArrayList in descending order (Highest =
		// Dice1)
		for (int k = 0; k < objects.length; k++) {
			diceList.set(k, objects[k]);
		}
	}
}
