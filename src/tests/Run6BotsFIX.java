package tests;

import java.awt.Color;
import java.util.Random;

import model.BattleLogic;
import model.GameLogic;
import model.Player;
import model.Territory;
import typesOfPlayers.MediumAI;
import typesOfPlayers.HardAI;
import typesOfPlayers.EasyAI;

public class Run6BotsFIX {
	/*
	 * TODO LIST
	 * 
	 * TODO: Fix HardAI to actually function and not have an empty if statement
	 * (CAUSING IOB ERROR CURRENTLY) TODO: Check attack logic a few more times
	 * to make sure corner cases are covered TODO: Try to move some of the
	 * battle logic stuff somewhere else, there is too much here
	 */

	public static void main(String[] args) {

		Random r = new Random();
		int easyCount = 0;
		int mediumCount = 0;
		int hardCount = 0;
		System.out.println("Loading bar");
		System.out.println("0%\t10%\t20%\t30%\t40%\t50%\t60%\t70%\t80%\t90%\t100%");
		System.out.print("*\t");
		for (int i = 0; i < 1000; i++) {
			Player easy1 = new MediumAI("easy1", Color.RED, 0);
			Player easy2 = new MediumAI("easy2", Color.BLACK, 0);
			Player easy3 = new MediumAI("easy3", Color.CYAN, 0);
			Player easy4 = new MediumAI("easy4", Color.RED, 0);
			Player easy5 = new MediumAI("easy5", Color.BLACK, 0);
			Player easy6 = new MediumAI("easy6", Color.CYAN, 0);

			Player medium1 = new MediumAI("medium1", Color.RED, 0);
			Player medium2 = new MediumAI("medium2", Color.BLACK, 0);
			Player medium3 = new MediumAI("medium3", Color.CYAN, 0);
			Player medium4 = new EasyAI("medium4", Color.BLUE, 0);
			Player medium5 = new EasyAI("medium5", Color.PINK, 0);
			Player medium6 = new EasyAI("medium6", Color.PINK, 0);

			Player hard1 = new MediumAI("hard1", Color.RED, 0);
			Player hard2 = new MediumAI("hard2", Color.BLACK, 0);
			Player hard3 = new MediumAI("hard3", Color.CYAN, 0);
			Player hard4 = new MediumAI("hard1", Color.RED, 0);
			Player hard5 = new HardAI("hard5", Color.RED, 0);
			Player hard6 = new HardAI("hard6", Color.RED, 0);
			Player currPlayer = null;
			GameLogic gameLogic = new GameLogic(easy1, easy2, easy3, medium4, medium5, medium6);
			BattleLogic battleLogic;
			int turnCount = -1;

			gameLogic.startGame();
			while (gameLogic.getNumOfPlayers() > 1 && turnCount < 360) {
				turnCount++;
				currPlayer = gameLogic.nextPlayer();
				// System.out.println("~~~~~~~~~~~~~~");
				// System.out.println(currPlayer.getName());
				// System.out.println("Number of Territories: " +
				// currPlayer.getTerritories().size());

				/*
				 * ~~~~~~~~~~~~~~~~~~~ DEPLOY ARMIES LOGIC ~~~~~~~~~~~~~~~~~~~
				 */

				// ALL OF THE TURN IN CARD LOGIC MOVED TO GAMELOGIC
				gameLogic.turnInCard();

				// ALL REINFORCEMENT LOGIC MOVED TO GAMELOGIC
				if (turnCount >= gameLogic.getNumOfPlayers())
					gameLogic.addReinforcements();

				// ALL OF DEPLOYING REINFORCEMENT ARMIES MOVED TO GAMELOGIC
				while (currPlayer.getNumOfArmies() > 0)
					gameLogic.deployAllArmies();

				/*
				 * ~~~~~~~~~~~~~~~~~~~ ATTACK ARMIES LOGIC ~~~~~~~~~~~~~~~~~~~
				 */

				Territory attackingTerritory = currPlayer.getTerritories()
						.get(r.nextInt(currPlayer.getTerritories().size()));
				Territory defendingTerritory = currPlayer.attackTerritory(attackingTerritory,
						attackingTerritory.getNeighbors());

				if (defendingTerritory != null) {

					battleLogic = new BattleLogic(currPlayer, defendingTerritory.getOwner(), attackingTerritory,
							defendingTerritory);

					// FIGURE OUT HOW MANY DICE TO ROLL

					// System.out.println("Units in attacking territory: " +
					// attackingTerritory.getUnits());
					while (currPlayer.chooseRetreat(attackingTerritory) && attackingTerritory.getUnits() > 1) {
						int attackerDiceNum, defenderDiceNum;
						if (attackingTerritory.getUnits() <= 3) {
							attackerDiceNum = attackingTerritory.getUnits() - 1;
						} else {
							attackerDiceNum = 3;
						}

						// System.out.println("Attacking Territory: " +
						// attackingTerritory.getName());
						// System.out.println("Attacking Units at Territory: " +
						// attackingTerritory.getUnits());
						// System.out.println("Defending Territory: " +
						// defendingTerritory.getName());
						// System.out.println("Defending Units at Territory: " +
						// defendingTerritory.getUnits());

						if (defendingTerritory.getUnits() <= 2) {
							defenderDiceNum = defendingTerritory.getUnits();
						} else
							defenderDiceNum = 2;

						// System.out.println(defendingTerritory.getUnits());
						// System.out.println("Attacking Dice: " +
						// attackerDiceNum);
						// System.out.println("Defender: " +
						// defendingTerritory.getOwner().getName());
						// System.out.println("Defending Dice: " +
						// defenderDiceNum);

						battleLogic.attackPlayer(attackerDiceNum, defenderDiceNum);
						int[] unitsToLose = battleLogic.subtractArmies();

						// System.out.println("Num of Armies Attacker Lost: " +
						// unitsToLose[0]);
						// System.out.println("Num of Armies Defender Lost: " +
						// unitsToLose[1]);
						gameLogic.attackLogic(attackingTerritory, defendingTerritory, unitsToLose);
					}
				}

				/*
				 * ~~~~~~~~~~~~~~~ FORTIFY POSITION LOGIC ~~~~~~~~~~~~~~~~~
				 */

				// gameLogic.fortifyPosition();
			}
			int highestNumOfTerritories = 0;
			int playerIndexOfHighestTerr = 0;

			for (int j = 0; j < gameLogic.getNumOfPlayers(); j++) {
				if (highestNumOfTerritories < gameLogic.getPlayerAt(j).getTerritories().size()) {
					highestNumOfTerritories = gameLogic.getPlayerAt(j).getTerritories().size();
					playerIndexOfHighestTerr = j;
				}
			}

			Player winner = gameLogic.getPlayerAt(playerIndexOfHighestTerr);

			if ((i+1) % 100 == 0) {
				System.out.print("*\t");
			}

			if (i == 999)
				System.out.println();
			/*
			 * if (i == 249 || i == 499 || i == 749) { System.out.println(
			 * "Game " + (i + 1) + " Over!"); System.out.println("Easy Wins: " +
			 * easyCount); System.out.println("Medium Wins: " + mediumCount);
			 * System.out.println("Hard Winds: " + hardCount);
			 * System.out.println("Still playing more games");
			 * System.out.println(); }
			 */

			if (winner.getName().equals("easy1") || winner.getName().equals("easy2")
					|| winner.getName().equals("easy3")) {
				easyCount++;
			}
			if (winner.getName().equals("medium3") || winner.getName().equals("medium4")
					|| winner.getName().equals("medium5") || winner.getName().equals("medium6")) {
				mediumCount++;
			}
			if (winner.getName().equals("hard4") || winner.getName().equals("hard5")
					|| winner.getName().equals("hard6")) {
				hardCount++;
			}

		}

		System.out.println("Easy Wins: " + easyCount);
		System.out.println("Medium Wins: " + mediumCount);
		System.out.println("Hard Winds: " + hardCount);
	}

}
