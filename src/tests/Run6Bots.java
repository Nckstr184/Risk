package tests;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import model.BattleLogic;
import model.Card;
import model.CardCollection;
import model.GameLogic;
import model.Player;
import model.PlayerCollection;
import model.Territory;
import typesOfPlayers.EasyAI;
import typesOfPlayers.MediumAI;

public class Run6Bots {

	public static void main(String[] args) {

		Player ai1 = new EasyAI("easy1", Color.RED, 20);
		Player ai2 = new EasyAI("easy2", Color.BLUE, 20);
		Player ai3 = new EasyAI("easy3", Color.GREEN, 20);
		Player ai4 = new MediumAI("medium4", Color.BLACK, 20);
		Player ai5 = new MediumAI("medium5", Color.CYAN, 20);
		Player ai6 = new MediumAI("medium6", Color.GRAY, 20);

		GameLogic gameLogic = new GameLogic();
		BattleLogic battleLogic;
		gameLogic.addPlayers(ai6);
		gameLogic.addPlayers(ai5);
		gameLogic.addPlayers(ai4);
		gameLogic.addPlayers(ai3);
		gameLogic.addPlayers(ai2);
		gameLogic.addPlayers(ai1);
		int easyWin = 0, mediumWin = 0, nextCard = 0;
		boolean noMoreRewardCard;
		Random r = new Random();
		Card rewardCard;

		for (int i = 0; i < 1; i++) {
			gameLogic.startGame();
			int numberOfCardTurnIns = 0, numberOfRewardArmies = 4;
			PlayerCollection allPlayers = gameLogic.getPlayerList();
			CardCollection allCards = new CardCollection();
			allCards.shuffle();
			int count = 6;
			Player currPlayer = null;
			// System.out.println("START");
			while (!gameLogic.isGameComplete()) {
				currPlayer = allPlayers.getPlayer((count % allPlayers.getNumOfPlayers()));
				ArrayList<Territory> territories = currPlayer.getTerritories();
				// System.out.println(currPlayer.getName());
				noMoreRewardCard = false;
				int rand;

				int reinforcementNumber = (int) currPlayer.getTerritories().size() / 3;
				if (reinforcementNumber < 3) {
					reinforcementNumber = 3;
				}
				currPlayer.addArmies(reinforcementNumber);

				// System.out.println("Number of Armies: " +
				// currPlayer.getNumOfArmies());
				if (currPlayer.turnInCard()) {
					System.out.println("Turning in card");
					if (numberOfCardTurnIns < 6) {
						currPlayer.addArmies(numberOfRewardArmies);
						numberOfRewardArmies += 2;
					} else {
						currPlayer.addArmies(numberOfRewardArmies);
						numberOfRewardArmies += 5;
					}
					currPlayer.addArmies(numberOfRewardArmies);
				}

				while (currPlayer.getNumOfArmies() != 0) {
					// System.out.println("ArmiesBeforeDeployment "+
					// currPlayer.getNumOfArmies());
					currPlayer.deployArmy(territories).addUnits(1);
					currPlayer.addArmies(-1);
					// System.out.println("ArmiesAfterDeployment "+
					// currPlayer.getNumOfArmies());

				}

				// System.out.println("Number of Armies: " +
				// currPlayer.getNumOfArmies());

				// Attack Phase
				int mostArmies = 0, indexOfMost = 0;
				// System.out.println(territories.size());
				for (int j = 0; j < territories.size(); j++) {
					if (mostArmies < territories.get(j).getUnits()) {
						mostArmies = territories.get(j).getUnits();
						indexOfMost = j;
					}
				}
				// System.out.println("Found the territory with the most
				// armies");
				Territory currTerritory = territories.get(indexOfMost);
				// System.out.println(currTerritory);
				// System.out.println(currTerritory.getNeighbors());
				Territory defendingTerritory = currPlayer.attackTerritory(currTerritory, currTerritory.getNeighbors());

				if (defendingTerritory != null) {
					Player defender = defendingTerritory.getOwner();
					battleLogic = new BattleLogic(currPlayer, defendingTerritory.getOwner(), currTerritory,
							defendingTerritory);
					System.out.println(currTerritory.getUnits() + " " + defendingTerritory.getUnits());
					while (currPlayer.chooseRetreat(currTerritory) && currTerritory.getUnits() > 1) {
						// System.out.println("Attacking");
						int temp1, temp2;
						if (currTerritory.getUnits() <= 3) {
							temp1 = currTerritory.getUnits();
						} else {
							temp1 = 3;
						}

						if (defendingTerritory.getUnits() <= 2) {
							temp2 = defendingTerritory.getUnits();
						} else
							temp2 = 2;

						int currTerrDiceNum = temp1;
						int attackingTerrDiceNum = temp2;
						// System.out.println(currTerritory.getUnits() + " " +
						// defendingTerritory.getUnits());
						battleLogic.attackPlayer(currTerrDiceNum, attackingTerrDiceNum);
						int[] unitsToLose = battleLogic.subtractArmies();

						// Subtracting armies from the players
						// System.out.println("Units to loose"+unitsToLose[0] +
						// " " + unitsToLose[1]);
						// System.out.println("BEFORE REMOVING
						// UNITs"+currPlayer.getNumOfArmies() + " " +
						// defender.getNumOfArmies());
						currTerritory.addUnits(unitsToLose[0]);
						defendingTerritory.addUnits(unitsToLose[1]);
						// System.out.println("AFTER REMOVING
						// UNITs"+currPlayer.getNumOfArmies() + " " +
						// defender.getNumOfArmies());
						if (defendingTerritory.getUnits() <= 0) {
							System.out.println("Attacker won");
							defender.removeTerritory(defendingTerritory);
							currPlayer.addTerritories(defendingTerritory);
							defendingTerritory.setOwner(currPlayer);
							
							currTerritory.addUnits(-1);
							while (defendingTerritory.getUnits() <= 0) {
								defendingTerritory.addUnits(1);
							}

							if (!noMoreRewardCard && nextCard < 44) {
								System.out.println("Giving Reward Card");
								noMoreRewardCard = true;
								currPlayer.addCard(allCards.getCard(nextCard));
								nextCard++;
							}
						}
					}
					if (defender.getTerritories().size() == 0) {
						allPlayers.removePlayer(defendingTerritory.getOwner());
					}
				}

				// Fortify Phase
				// System.out.println("Fortifying Position");
				currPlayer.fortifyPosition(territories.get(0), territories.get(0).getNeighbors());
				count++;
			}
			System.out.println("Game Over");
			if (currPlayer.getName().equals("easy1") || currPlayer.getName().equals("easy2")
					|| currPlayer.getName().equals("easy3")) {
				easyWin++;
			} else if (currPlayer.getName().equals("medium1") || currPlayer.getName().equals("medium2")
					|| currPlayer.getName().equals("medium3")) {
				mediumWin++;
			}
		}

		System.out.println("EasyAI wins: " + easyWin);
		System.out.println("MediumAI wins: " + mediumWin);
	}

	private static void attackLoop(Player currPlayer, Territory currTerritory, Territory defendingTerritory) {
		// TODO Auto-generated method stub

	}

	private static void getReinforcements(Player currPlayer) {
		// TODO Auto-generated method stub
		int reinforcementNumber = (int) currPlayer.getTerritories().size() / 3;
		if (reinforcementNumber < 3) {
			reinforcementNumber = 3;
		}
		currPlayer.addArmies(reinforcementNumber);

		// for(int index=0; index<currPlayer.getTerritories().size(); index++)
		// {
		// Territory temp=currPlayer.getTerritories().get(index);
		// temp.checkIfContinentIsConquered();
		// }
	}
}
