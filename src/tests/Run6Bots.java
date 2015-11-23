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
			while (!gameLogic.isGameComplete()) {
				currPlayer = allPlayers.getPlayer((count % 6));
				ArrayList<Territory> territories = currPlayer.getTerritories();
				System.out.println(currPlayer.getName());
				noMoreRewardCard = false;
				if (currPlayer.turnInCard()) {
					if (numberOfCardTurnIns < 6) {
						currPlayer.addArmies(numberOfRewardArmies);
						numberOfRewardArmies += 2;
					} else {
						currPlayer.addArmies(numberOfRewardArmies);
						numberOfRewardArmies += 5;
					}
					int rewardArmyNumber = numberOfRewardArmies;

					while (rewardArmyNumber != 0) {

						// System.out.println(currPlayer.getNumOfArmies());
						System.out.println("Placing Armies");
						currPlayer.deployArmy(currPlayer.getTerritories()).addUnits(1);
						currPlayer.addArmies(1);
						rewardArmyNumber--;
					}
				}
				// System.out.println("Finishing Army placement");

				// Attack Phase
				// System.out.println("Starting attack phase");
				int mostArmies = 0, indexOfMost = 0;
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
				// System.out.println("About to check to see if we are
				// attacking");
				if (defendingTerritory != null) {
					battleLogic = new BattleLogic(currPlayer, defendingTerritory.getOwner(), currTerritory,
							defendingTerritory);

					while (currPlayer.chooseRetreat(currTerritory) && currTerritory.getUnits() > 1
							&& defendingTerritory.getUnits() > 0) {
						 System.out.println("Attacking");
						// System.out.println(currTerritory.getUnits());
						int temp1, temp2;
						if (currTerritory.getUnits() < 3) {
							temp1 = currTerritory.getUnits() - 1;
						} else {
							temp1 = Math.abs(currTerritory.getUnits() % 3);
							if (temp1 == 0)
								temp1 = 3;
						}

						temp2 = Math.abs(defendingTerritory.getUnits() % 2);
						if (temp2 == 0)
							temp2 = 2;
						System.out.println(temp1 + "   " + temp2);
						int currTerrDiceNum = temp1;
						int attackingTerrDiceNum = temp2;
						battleLogic.attackPlayer(currTerrDiceNum, attackingTerrDiceNum);
						battleLogic.subtractArmies();
					}

					if (battleLogic.attackerWin()) {
						System.out.println("Attacker Won");
						// changing owner of territory
						// giving reward card (only if it's the first win)
						if (!noMoreRewardCard && nextCard < 44) {
							// System.out.println("Giving Reward Card");
							noMoreRewardCard = true;
							currPlayer.addCard(allCards.getCard(nextCard));
							nextCard++;
						}
					}
				}

				// Fortify Phase
				// System.out.println("Fortifying Position");

				// System.out.println(territories.get(0).getOwner().getName());
				// System.out.println(territories.get(0).getNeighbors());
				currPlayer.fortifyPosition(territories.get(0), territories.get(0).getNeighbors());
				// System.out.println("Going to the next player");
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
}
