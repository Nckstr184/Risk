package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class GameLogic implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -145536232043601557L;
	private final int NUM_OF_TERRITORIES = 7;
	public Random r;

	private ArrayList<Territory> allTerritories;
	private ArrayList<Continent> allContinents;
	private CardCollection allCards;
	private PlayerCollection allPlayers;
	private Dice attackDice, defendDice, turnDice;
	private int numOfPlayers, playerTurn, indexOfPlayerTurn, nextCard;
	private Languages languages;
	private Dino dino;
	private Wildcat wildcat;
	private Pizza pizza;
	private Crescent crescent;
	private Sun sun;
	private boolean noMoreRewardCard;

	public GameLogic(Player p1, Player p2, Player p3, Player p4, Player p5, Player p6) {
		allTerritories = new ArrayList<Territory>();
		allContinents = new ArrayList<Continent>();
		allPlayers = new PlayerCollection();
		allCards = new CardCollection();

		nextCard = 0;
		indexOfPlayerTurn = 0;
		noMoreRewardCard = false;

		attackDice = new Dice(3);
		defendDice = new Dice(2);
		turnDice = new Dice(1);

		if (p1 != null) {
			allPlayers.addPlayers(p1);
		}
		if (p2 != null) {
			allPlayers.addPlayers(p2);
		}
		if (p3 != null) {
			allPlayers.addPlayers(p3);
		}
		if (p4 != null) {
			allPlayers.addPlayers(p4);
		}
		if (p5 != null) {
			allPlayers.addPlayers(p5);
		}
		if (p6 != null) {
			allPlayers.addPlayers(p6);
		}

		playerTurn = allPlayers.getNumOfPlayers() - 1;

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

	public Player nextPlayer() {
		playerTurn++;
		noMoreRewardCard = false;
		indexOfPlayerTurn = playerTurn % (allPlayers.getNumOfPlayers());
		return allPlayers.getPlayer(indexOfPlayerTurn);
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
		Ruby.addNeighbors(Git);
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

	public void removePlayer(Player player) {
		allPlayers.removePlayer(player);
		numOfPlayers = allPlayers.getNumOfPlayers();
	}

	public int getNumOfPlayers() {
		return allPlayers.getNumOfPlayers();
	}

	public void startGame() {
		numOfPlayers = allPlayers.getNumOfPlayers();
		allCards.shuffle();

		disperseNumberOfArmies();
		startUpPlaceReinforcementPhase();
	}

	private void startUpPlaceReinforcementPhase() {
		// make temp list of territories
		ArrayList<Territory> tempTerrs = new ArrayList<Territory>(this.getTerritories());
		r = new Random();
		int randomIndex;
		Territory tempTerritory;
		Player tempPlayer;
		int count = 0;
		while (!tempTerrs.isEmpty()) {
			for (int i = 0; i < allPlayers.getNumOfPlayers(); i++) {
				if (!tempTerrs.isEmpty()) {
					// System.out.println(count++);
					randomIndex = r.nextInt(tempTerrs.size());
					tempTerritory = tempTerrs.get(randomIndex);
					tempPlayer = allPlayers.getPlayer(i);
					// System.out.println(tempTerritory.getOwner());
					if (tempPlayer.getNumOfArmies() > 0) {
						tempPlayer.addTerritories(tempTerritory);
						tempTerritory.setOwner(tempPlayer);
						tempTerrs.remove(randomIndex);
						while (tempTerritory.getUnits() != 1)
							tempTerritory.addUnits(1);
					}
				}
			}
		}

		for (int i = 0; i < allTerritories.size(); i++) {
			// System.out.println(allTerritories.get(i).getName() + " has " +
			// allTerritories.get(i).getUnits() + " units");
		}
	}

	private void disperseNumberOfArmies() {
		if (allPlayers.getNumOfPlayers() == 3) {
			for (int i = 0; i < 3; i++) {
				Player temp = allPlayers.getPlayer(i);
				temp.addArmies(3);
			}
		}
		if (allPlayers.getNumOfPlayers() == 4) {
			for (int i = 0; i < 4; i++) {
				Player temp = allPlayers.getPlayer(i);
				temp.addArmies(30);
			}
		}
		if (allPlayers.getNumOfPlayers() == 5) {
			for (int i = 0; i < 5; i++) {
				Player temp = allPlayers.getPlayer(i);
				temp.addArmies(25);
			}
		}
		if (allPlayers.getNumOfPlayers() == 6) {
			for (int i = 0; i < 6; i++) {
				Player temp = allPlayers.getPlayer(i);
				temp.addArmies(20);
			}
		}
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
			// System.out.println(objects[k]);
			temp.add((Player) objects[k]);
		}

		return temp;
	}

	public PlayerCollection getPlayerList() {
		return allPlayers;
	}

	public CardCollection getCards() {
		return allCards;
	}

	public ArrayList<Continent> getContinents() {
		return allContinents;
	}

	public ArrayList<Territory> getTerritory() {
		return allTerritories;
	}

	public void setPlayerList(PlayerCollection newPlayers) {
		allPlayers = newPlayers;
	}

	public void setCards(CardCollection newCards) {
		allCards = newCards;
	}

	public void setContinents(ArrayList<Continent> newContinents) {
		allContinents = newContinents;
	}

	public void setTerritory(ArrayList<Territory> newTerritories) {
		allTerritories = newTerritories;
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

	public void addReinforcements() {
		Player currPlayer = allPlayers.getPlayer(indexOfPlayerTurn);
		int totalNumOfTerritories = currPlayer.getTerritories().size();

		if (totalNumOfTerritories < 9) {
			currPlayer.addArmies(3);
		} else {
			currPlayer.addArmies((int) (totalNumOfTerritories / 3));
		}

		// System.out.println(currPlayer.getNumOfArmies());
	}

	public void deployAllArmies() {
		Player currPlayer = allPlayers.getPlayer(indexOfPlayerTurn);
		// System.out.println("Current player being deployed: " +
		// currPlayer.getName());

		ArrayList<Object> deployingList = currPlayer.deployArmy();
		if (deployingList != null) {
			Territory tempTerr = (Territory) deployingList.get(0);
			Integer tempInt = (Integer) deployingList.get(1);

			// if (tempTerr.getUnits() <= 10)
			tempTerr.addUnits(tempInt);
			currPlayer.removeArmies(tempInt);
		}
	}

	public void attackLogic(Territory attackingTerr, Territory defendingTerr, int[] unitsToLose) {
		Player attacker = attackingTerr.getOwner();
		Player defender = defendingTerr.getOwner();
		// System.out.println("Defender: " + defender.getName());

		attackingTerr.removeUnits(unitsToLose[0]);
		defendingTerr.removeUnits(unitsToLose[1]);

		if (defendingTerr.getUnits() <= 0) {
			// System.out.println("Attacker won!");
			defender.removeTerritory(defendingTerr);
			attacker.addTerritories(defendingTerr);
			defendingTerr.setOwner(attacker);

			attackingTerr.removeUnits(1);
			while (defendingTerr.getUnits() <= 0) {
				defendingTerr.addUnits(1);
			}

			if (!noMoreRewardCard && nextCard < 44) {
				noMoreRewardCard = true;
				attacker.addCard(allCards.getCard(nextCard));
				nextCard++;
			}

			// System.out.println("Should be the attacker's name -> " +
			// defendingTerr.getOwner().getName());

			if (defender.getTerritories().size() == 0) {
				allPlayers.removePlayer(defender);
			}
		}

	}

	public void fortifyPosition() {
		Player currPlayer = allPlayers.getPlayer(playerTurn % (allPlayers.getNumOfPlayers()));
		int rand = r.nextInt(currPlayer.getTerritories().size());

		ArrayList<Object> fortifyReturn = currPlayer.fortifyPosition(currPlayer.getTerritories().get(rand),
				currPlayer.getTerritories().get(rand).getNeighbors());

		if (fortifyReturn != null && fortifyReturn.size() == 2) {
			Territory territoryToFortify = (Territory) fortifyReturn.get(0);
			int armiesToAdd = (Integer) fortifyReturn.get(1);

			territoryToFortify.addUnits(armiesToAdd);
			// System.out.println("The player that is fortifying: " +
			// currPlayer.getName());
			// System.out.println("Number of Units at currTerr: " +
			// currPlayer.getTerritories().get(rand).getUnits());
			// System.out.println("Number of Units leaving currTerr: " +
			// armiesToAdd);
			currPlayer.getTerritories().get(rand).removeUnits(armiesToAdd);
			// System.out.println("Units at territory after fortify: " +
			// currPlayer.getTerritories().get(rand).getUnits());
		}
	}

	public boolean attackerWin(Territory defendingTerr) {
		if (defendingTerr.getUnits() <= 0) {
			return true;
		}

		return false;
	}

	public void transferTerritory(Player attacker, Player defender, Territory attackingTerr, Territory defendingTerr) {

		defender.removeTerritory(defendingTerr);
		attacker.addTerritories(defendingTerr);
		defendingTerr.setOwner(attacker);
		attackingTerr.removeUnits(1);
		defendingTerr.addUnits(1);
	}

	// CARD LOGIC SECTION

	private int numOfRewardArmies = 4;
	private int numOfCardTurnIns = 0;

	public void turnInCard() {
		Player currPlayer = allPlayers.getPlayer(indexOfPlayerTurn);

		if (currPlayer.turnInCard()) {
			if (numOfCardTurnIns < 6) {
				currPlayer.addArmies(numOfRewardArmies);
				numOfRewardArmies += 2;
			} else {
				currPlayer.addArmies(numOfRewardArmies);
				numOfRewardArmies += 5;
			}
			currPlayer.addArmies(numOfRewardArmies);
		}
	}
}