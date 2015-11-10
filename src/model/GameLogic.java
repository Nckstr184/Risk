package model;

import java.util.ArrayList;

public class GameLogic {
	private final int NUM_OF_TERRITORIES = 7;

	private ArrayList<Territory> allTerritories;
	private ArrayList<Continent> allContinents;
	private PlayerCollection allPlayers;
	private Dice attackDice, defendDice, turnDice;
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
	public void addPlayers(Player player) {
		allPlayers.addPlayers(player);
	}

	public void startGame() {
		
	}

}
