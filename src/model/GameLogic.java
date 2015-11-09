package model;

import java.util.ArrayList;


public class GameLogic {
	private final int NUM_OF_TERRITORIES = 7;
	
	private ArrayList<Territory> allTerritories;
	private ArrayList<Continent> allContinents;
	private ArrayList<Player> allPlayers;
	private Languages languages;
	private Dino dino;
	private Wildcat wildcat;
	private Pizza pizza;
	private Crescent crescent;
	private Sun sun;
	
	public GameLogic() {
		allTerritories = new ArrayList<Territory>();
		allContinents = new ArrayList<Continent>();
		
		// Adding all the continent objects to an arraylist
		allContinents.add(languages);
		allContinents.add(dino);
		allContinents.add(wildcat);
		allContinents.add(pizza);
		allContinents.add(crescent);
		allContinents.add(sun);
		
		// Filling in the territories list
		ArrayList<Territory> tempTerritories;
		for(int i=0; i<allContinents.size(); i++) {
			tempTerritories = allContinents.get(i).getTerritories();
			for(int j=0; j<NUM_OF_TERRITORIES; j++) {
				allTerritories.add(tempTerritories.get(j));
			}
		}
	}
	
	public void startGame(ArrayList<Player> allPlayers) {
		this.allPlayers = allPlayers;
	}
}
