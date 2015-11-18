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

		languages = new Languages("languages", false);
		dino = new Dino("dino", false);
		wildcat = new Wildcat("wildcat", false);
		pizza = new Pizza("pizza", false);
		crescent = new Crescent("crescent", false);
		sun = new Sun("sun", false);

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

		setNeighbors(allTerritories);
	}

	private void setNeighbors(ArrayList<Territory> allTerritories2) {

		Territory Java = allTerritories2.get(0);
		Territory Python = allTerritories2.get(1);
		Territory C = allTerritories2.get(2);
		Territory SQL = allTerritories2.get(3);
		Territory Ruby = allTerritories2.get(4);
		Territory Git = allTerritories2.get(5);
		Territory Perl = allTerritories2.get(6);
		Territory Rawrville = allTerritories2.get(7);
		Territory Laiegges = allTerritories2.get(8);
		Territory Dactilito = allTerritories2.get(9);
		Territory Dirtydan = allTerritories2.get(10);
		Territory BlackBeard = allTerritories2.get(11);
		Territory Monisaurus = allTerritories2.get(12);
		Territory ToyStory = allTerritories2.get(13);
		Territory Wilber = allTerritories2.get(14);
		Territory Wilma = allTerritories2.get(15);
		Territory Rich = allTerritories2.get(16);
		Territory Miller = allTerritories2.get(17);
		Territory Scooby = allTerritories2.get(18);
		Territory McKale = allTerritories2.get(19);
		Territory Zona = allTerritories2.get(20);
		Territory PapaJohns = allTerritories2.get(21);
		Territory Dominos = allTerritories2.get(22);
		Territory PizzaHut = allTerritories2.get(23);
		Territory BlackJack = allTerritories2.get(24);
		Territory HungryHowies = allTerritories2.get(25);
		Territory Brooklyns = allTerritories2.get(26);
		Territory Mamas = allTerritories2.get(27);
		Territory Scraptopia = allTerritories2.get(28);
		Territory LandOfZach = allTerritories2.get(29);
		Territory Giant = allTerritories2.get(30);
		Territory NewLandOfZach = allTerritories2.get(31);
		Territory SouthScraptopia = allTerritories2.get(32);
		Territory BlooBawl = allTerritories2.get(33);
		Territory CrescentCapital = allTerritories2.get(34);
		Territory Apollo = allTerritories2.get(35);
		Territory Ra = allTerritories2.get(36);
		Territory Helios = allTerritories2.get(37);
		Territory Inti = allTerritories2.get(38);
		Territory Horus = allTerritories2.get(39);
		Territory Tonatiuh = allTerritories2.get(40);
		Territory Amun = allTerritories2.get(41);

		/////////////////////////// LANGUAGES//////////////////////////////////////////////////////
		Java.addNeighbors(Python);
		Java.addNeighbors(C);
		Java.addNeighbors(SQL);
		Java.addNeighbors(Helios);

		Python.addNeighbors(Java);
		Python.addNeighbors(C);
		Python.addNeighbors(SQL);
		Python.addNeighbors(Git);
		Python.addNeighbors(Perl);

		C.addNeighbors(Java);
		C.addNeighbors(Python);
		C.addNeighbors(SQL);
		C.addNeighbors(Ruby);

		SQL.addNeighbors(Java);
		SQL.addNeighbors(Python);
		SQL.addNeighbors(C);
		SQL.addNeighbors(Ruby);
		SQL.addNeighbors(Git);

		Ruby.addNeighbors(C);
		Ruby.addNeighbors(SQL);
		Ruby.addNeighbors(Ruby);
		Ruby.addNeighbors(Giant);

		Git.addNeighbors(Python);
		Git.addNeighbors(SQL);
		Git.addNeighbors(Ruby);
		Git.addNeighbors(Perl);

		Perl.addNeighbors(Python);
		Perl.addNeighbors(Git);

		/////////////////////////// DINO//////////////////////////////////////////////////////

		Rawrville.addNeighbors(Laiegges);
		Rawrville.addNeighbors(Dactilito);

		Laiegges.addNeighbors(Rawrville);
		Laiegges.addNeighbors(Dactilito);
		Laiegges.addNeighbors(Dirtydan);
		Laiegges.addNeighbors(CrescentCapital);

		Dactilito.addNeighbors(Rawrville);
		Dactilito.addNeighbors(Laiegges);
		Dactilito.addNeighbors(Dirtydan);
		Dactilito.addNeighbors(BlackBeard);
		Dactilito.addNeighbors(ToyStory);

		Dirtydan.addNeighbors(Laiegges);
		Dirtydan.addNeighbors(Dactilito);
		Dirtydan.addNeighbors(BlackBeard);
		Dirtydan.addNeighbors(Monisaurus);
		Dirtydan.addNeighbors(NewLandOfZach);
		Dirtydan.addNeighbors(BlooBawl);
		Dirtydan.addNeighbors(CrescentCapital);

		BlackBeard.addNeighbors(Dactilito);
		BlackBeard.addNeighbors(Dirtydan);
		BlackBeard.addNeighbors(Monisaurus);
		BlackBeard.addNeighbors(ToyStory);

		Monisaurus.addNeighbors(Dirtydan);
		Monisaurus.addNeighbors(BlackBeard);
		Monisaurus.addNeighbors(ToyStory);
		Monisaurus.addNeighbors(NewLandOfZach);

		ToyStory.addNeighbors(Dactilito);
		ToyStory.addNeighbors(BlackBeard);
		ToyStory.addNeighbors(Monisaurus);

		/////////////////////////// WILDCAT//////////////////////////////////////////////////////
		Wilber.addNeighbors(Wilma);
		Wilber.addNeighbors(Rich);
		Wilber.addNeighbors(Scooby);
		Wilber.addNeighbors(PapaJohns);
		Wilber.addNeighbors(Dominos);
		Wilber.addNeighbors(Brooklyns);
		Wilber.addNeighbors(Tonatiuh);

		Wilma.addNeighbors(Wilber);
		Wilma.addNeighbors(Rich);
		Wilma.addNeighbors(Miller);

		Rich.addNeighbors(Wilber);
		Rich.addNeighbors(Wilma);
		Rich.addNeighbors(Miller);
		Rich.addNeighbors(Scooby);
		Rich.addNeighbors(McKale);

		Miller.addNeighbors(Wilma);
		Miller.addNeighbors(Rich);
		Miller.addNeighbors(McKale);
		Miller.addNeighbors(Scraptopia);

		Scooby.addNeighbors(Wilber);
		Scooby.addNeighbors(Rich);
		Scooby.addNeighbors(McKale);
		Scooby.addNeighbors(Zona);
		Scooby.addNeighbors(PapaJohns);

		McKale.addNeighbors(Rich);
		McKale.addNeighbors(Miller);
		McKale.addNeighbors(Scooby);
		McKale.addNeighbors(Zona);

		Zona.addNeighbors(Scooby);
		Zona.addNeighbors(McKale);

		/////////////////////////// PIZZA//////////////////////////////////////////////////////
		PapaJohns.addNeighbors(Dominos);
		PapaJohns.addNeighbors(PizzaHut);
		PapaJohns.addNeighbors(BlackJack);
		PapaJohns.addNeighbors(Wilber);
		PapaJohns.addNeighbors(Scooby);

		Dominos.addNeighbors(PapaJohns);
		Dominos.addNeighbors(PizzaHut);
		Dominos.addNeighbors(HungryHowies);
		Dominos.addNeighbors(Brooklyns);
		Dominos.addNeighbors(Wilber);

		PizzaHut.addNeighbors(PapaJohns);
		PizzaHut.addNeighbors(Dominos);
		PizzaHut.addNeighbors(BlackJack);
		PizzaHut.addNeighbors(HungryHowies);

		BlackJack.addNeighbors(PapaJohns);
		BlackJack.addNeighbors(Dominos);
		BlackJack.addNeighbors(PizzaHut);

		HungryHowies.addNeighbors(Dominos);
		HungryHowies.addNeighbors(PizzaHut);
		HungryHowies.addNeighbors(BlackJack);
		HungryHowies.addNeighbors(Brooklyns);

		Brooklyns.addNeighbors(Dominos);
		Brooklyns.addNeighbors(HungryHowies);
		Brooklyns.addNeighbors(Mamas);
		Brooklyns.addNeighbors(Wilber);
		Brooklyns.addNeighbors(Tonatiuh);

		Mamas.addNeighbors(Brooklyns);
		Mamas.addNeighbors(Apollo);
		Mamas.addNeighbors(Tonatiuh);

		/////////////////////////// CRESCENT//////////////////////////////////////////////////////
		Scraptopia.addNeighbors(LandOfZach);
		Scraptopia.addNeighbors(Miller);

		LandOfZach.addNeighbors(Scraptopia);
		LandOfZach.addNeighbors(Giant);
		LandOfZach.addNeighbors(NewLandOfZach);

		Giant.addNeighbors(LandOfZach);
		Giant.addNeighbors(SouthScraptopia);
		Giant.addNeighbors(BlooBawl);
		Giant.addNeighbors(Ruby);

		NewLandOfZach.addNeighbors(LandOfZach);
		NewLandOfZach.addNeighbors(SouthScraptopia);
		NewLandOfZach.addNeighbors(BlooBawl);
		NewLandOfZach.addNeighbors(Dirtydan);
		NewLandOfZach.addNeighbors(Monisaurus);

		SouthScraptopia.addNeighbors(Giant);
		SouthScraptopia.addNeighbors(NewLandOfZach);

		BlooBawl.addNeighbors(Giant);
		BlooBawl.addNeighbors(NewLandOfZach);
		BlooBawl.addNeighbors(CrescentCapital);
		BlooBawl.addNeighbors(Dirtydan);

		CrescentCapital.addNeighbors(BlooBawl);
		CrescentCapital.addNeighbors(Laiegges);
		CrescentCapital.addNeighbors(Dirtydan);

		/////////////////////////// SUN//////////////////////////////////////////////////////
		Apollo.addNeighbors(Ra);
		Apollo.addNeighbors(Tonatiuh);
		Apollo.addNeighbors(Amun);
		Apollo.addNeighbors(Mamas);

		Ra.addNeighbors(Apollo);
		Ra.addNeighbors(Helios);
		Ra.addNeighbors(Amun);

		Helios.addNeighbors(Ra);
		Helios.addNeighbors(Inti);
		Helios.addNeighbors(Horus);
		Helios.addNeighbors(Amun);
		Helios.addNeighbors(Java);

		Inti.addNeighbors(Helios);
		Inti.addNeighbors(Horus);

		Horus.addNeighbors(Helios);
		Horus.addNeighbors(Inti);
		Horus.addNeighbors(Tonatiuh);
		Horus.addNeighbors(Amun);

		Tonatiuh.addNeighbors(Apollo);
		Tonatiuh.addNeighbors(Horus);
		Tonatiuh.addNeighbors(Amun);
		Tonatiuh.addNeighbors(Brooklyns);
		Tonatiuh.addNeighbors(Mamas);

		Amun.addNeighbors(Apollo);
		Amun.addNeighbors(Ra);
		Amun.addNeighbors(Helios);
		Amun.addNeighbors(Horus);
		Amun.addNeighbors(Tonatiuh);
	}

	public ArrayList<Territory> getTerritories() {
		return allTerritories;
	}

	public Player getPlayerAt(int index) {
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
			roll = turnDice.rollDice();
			temp.setDiceRoll(roll);
			tempList.add(temp);
		}
		// sorts the players based on dice roll *DOESNT ROLL AGAIN FOR
		// DUPLICATES*
		// However, duplicates do not break the sorting (Insertion Sort FTW)
		tempList = InsertionSort(tempList.toArray());

		// sets the master Player List to the sorted one
		allPlayers.setPlayerList(tempList);

		// TODO: Randomly set 1 army per turn to a territory
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
			((Player) objects[i + 1]).setDiceRoll(key); // Put the key in its
														// proper location
		}

		// converts Player[] to ArrayList<Player>
		ArrayList<Player> temp = new ArrayList<Player>();
		for (int k = 0; k < objects.length; k++) {
			temp.add((Player) objects[k]);
		}

		return temp;
	}

	public PlayerCollection getPlayerList() {
		return allPlayers;
	}

	public boolean isGameComplete() {
		if (languages.cConquered())
			if (dino.cConquered())
				if (wildcat.cConquered())
					if (pizza.cConquered())
						if (crescent.cConquered())
							if (sun.cConquered())
								return true;

		return false;
	}

}