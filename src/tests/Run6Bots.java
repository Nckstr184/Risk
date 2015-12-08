package tests;

import java.awt.Color;
import java.util.Random;

import model.BattleLogic;
import model.GameLogic;
import model.Player;
import model.Territory;
import typesOfPlayers.EasyAI;
import typesOfPlayers.HardAI;
import typesOfPlayers.MediumAI;

public class Run6Bots {
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
			Player easy1 = new EasyAI("easy1", Color.RED, 0, true);
			Player easy2 = new EasyAI("easy2", Color.BLACK, 0, true);
			Player easy3 = new EasyAI("easy3", Color.CYAN, 0, true);
			Player easy4 = new EasyAI("easy4", Color.RED, 0, true);
			Player easy5 = new EasyAI("easy5", Color.BLACK, 0, true);
			Player easy6 = new EasyAI("easy6", Color.CYAN, 0, true);

			Player medium1 = new MediumAI("medium1", Color.RED, 0, true);
			Player medium2 = new MediumAI("medium2", Color.BLACK, 0, true);
			Player medium3 = new MediumAI("medium3", Color.CYAN, 0, true);
			Player medium4 = new MediumAI("medium4", Color.BLUE, 0, true);
			Player medium5 = new MediumAI("medium5", Color.PINK, 0, true);
			Player medium6 = new MediumAI("medium6", Color.PINK, 0, true);

			Player hard1 = new HardAI("hard1", Color.RED, 0, true);
			Player hard2 = new HardAI("hard2", Color.BLACK, 0, true);
			Player hard3 = new HardAI("hard3", Color.CYAN, 0, true);
			Player hard4 = new HardAI("hard1", Color.RED, 0, true);
			Player hard5 = new HardAI("hard5", Color.RED, 0, true);
			Player hard6 = new HardAI("hard6", Color.RED, 0, true);
			Player currPlayer = null;
			GameLogic gameLogic = new GameLogic(hard1, medium2, easy3, hard4, medium5, easy6);
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

			if ((i + 1) % 100 == 0) {
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
			String winName = winner.getName().substring(0, 4);

			if (winName.equals("easy")) {
				easyCount++;
			}
			if (winName.equals("medi")) {
				mediumCount++;
			}
			if (winName.equals("hard")) {
				hardCount++;
			}

		}

		System.out.println("Easy Wins: " + easyCount);
		System.out.println("Medium Wins: " + mediumCount);
		System.out.println("Hard Winds: " + hardCount);
	}

}
