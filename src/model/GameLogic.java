package model;

import java.util.ArrayList;

public class GameLogic {
	private final int NUM_OF_TERRITORIES = 7;

	private ArrayList<Territory> allTerritories;
	private ArrayList<Continent> allContinents;
	private PlayerCollection allPlayers;
	private Dice attackDice, defendDice, turnDice;
	private int numOfPlayers;
	private Languages languages;
	private Dino dino;
	private Wildcat wildcat;
	private Pizza pizza;
	private Crescent crescent;
	private Sun sun;

	public GameLogic() {
		allTerritories = new ArrayList<Territory>();
		allContinents = new ArrayList<Continent>();
		allPlayers = new PlayerCollection();
		attackDice = new Dice(3);
		defendDice = new Dice(2);
		turnDice = new Dice(1);
		
		languages=new Languages("languages", false);
		dino=new Dino("dino", false);
		wildcat=new Wildcat("wildcat", false);
		pizza=new Pizza("pizza", false);
		crescent=new Crescent("crescent", false);
		sun=new Sun("sun", false);

		
		// Adding all the continent objects to an arraylist
		allContinents.add(languages);
		allContinents.add(dino);
		allContinents.add(wildcat);
		allContinents.add(pizza);
		allContinents.add(crescent);
		allContinents.add(sun);

		// Filling in the territories list
		ArrayList<Territory> tempTerritories;
		for (int i = 0; i < allContinents.size(); i++) {
			tempTerritories = allContinents.get(i).getTerritories();
			for (int j = 0; j < NUM_OF_TERRITORIES; j++) {
				allTerritories.add(tempTerritories.get(j));
			}
		}
	}

	public ArrayList<Territory> getTerritories()
	{
		return allTerritories;
	}
	
	public Player getPlayerAt(int index)
	{
		return allPlayers.getPlayer(index);
	}
	
	public void addPlayers(Player player) {
		allPlayers.addPlayers(player);
	}

	public void startGame() {
		numOfPlayers = allPlayers.getNumOfPlayers();
		Player temp;
		int roll;
		ArrayList<Player> tempList = new ArrayList<Player>();
		// this rolls the dice per person to check to see who goes first
		for (int i = 0; i < numOfPlayers; i++) {
			temp = allPlayers.getPlayer(i);
			turnDice.rollDice();
			roll = turnDice.getDice1();
			temp.setDiceRoll(roll);
			tempList.add(temp);
		}
		// sorts the players based on dice roll *DOESNT ROLL AGAIN FOR DUPLICATES*
		// However, duplicates do not break the sorting (Insertion Sort FTW)
		tempList = InsertionSort(tempList.toArray());
		
		// sets the master Player List to the sorted one
		allPlayers.setPlayerList(tempList);
	}

	public ArrayList<Player> InsertionSort(Object[] objects) {
		int j; // the number of items sorted so far
		int key; // the item to be inserted
		int i;

		for (j = 1; j < objects.length; j++) // Start with 1 (not 0)
		{
			key = ((Player) objects[j]).getDiceRoll();
			for (i = j - 1; (i >= 0) && (((Player) objects[i]).getDiceRoll() < key); i--) // Smaller
																			// values
			// are moving up
			{
				objects[i + 1] = objects[i];
			}
			((Player) objects[i + 1]).setDiceRoll(key); // Put the key in its proper location
		}
		
		// converts Player[] to ArrayList<Player>
		ArrayList<Player> temp = new ArrayList<Player>();
		for (int k = 0; k < objects.length; k++) {
			temp.add((Player) objects[k]);
		}
		
		return temp;
	}

}