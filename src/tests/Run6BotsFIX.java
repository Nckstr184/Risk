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

public class Run6BotsFIX {
	/*
	 * TODO LIST
	 * 
	 * TODO: Fix HardAI to actually function and not have an empty if statement (CAUSING IOB ERROR CURRENTLY)
	 * TODO: Check attack logic a few more times to make sure corner cases are covered
	 * TODO: Transfer territories on Attacker win
	 * TODO: Try to move some of the battle logic stuff somewhere else, there is too much here
	 */

	public static void main(String[] args) {

		Random r = new Random();
		for (int i = 0; i < 1; i++) {
			Player easy1 = new EasyAI("easy1", Color.RED, 20);
			Player easy2 = new EasyAI("easy2", Color.RED, 20);
			Player medium3 = new MediumAI("medium3", Color.RED, 20);
			Player medium4 = new MediumAI("medium4", Color.RED, 20);
			//Player hard5 = new HardAI("hard5", Color.RED, 20);
			//Player hard6 = new HardAI("hard6", Color.RED, 20);
			Player currPlayer;
			GameLogic gameLogic = new GameLogic(easy1, easy2, medium3, medium4, null, null);
			BattleLogic battleLogic;

			gameLogic.startGame();
			while (!gameLogic.isGameComplete()) {
				currPlayer = gameLogic.nextPlayer();
				System.out.println(currPlayer.getName());
				System.out.println("Number of Territories: " + currPlayer.getTerritories().size());

				/*
				 * ~~~~~~~~~~~~~~~~~~~ DEPLOY ARMIES LOGIC ~~~~~~~~~~~~~~~~~~~
				 */

				// ALL OF THE TURN IN CARD LOGIC MOVED TO GAMELOGIC
				gameLogic.turnInCard();

				// ALL REINFORCEMENT LOGIC MOVED TO GAMELOGIC
				gameLogic.addReinforcements();

				// ALL OF DEPLOYING REINFORCEMENT ARMIES MOVED TO GAMELOGIC
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

					while (!currPlayer.chooseRetreat(attackingTerritory) && attackingTerritory.getUnits() > 1) {
						int attackerDiceNum, defenderDiceNum;
						if (attackingTerritory.getUnits() <= 3) {
							attackerDiceNum = attackingTerritory.getUnits() - 1;
						} else {
							attackerDiceNum = 3;
						}

						if (defendingTerritory.getUnits() <= 2) {
							System.out.println("Defending Units at Territory: " + defendingTerritory.getUnits());
							defenderDiceNum = defendingTerritory.getUnits();
						} else
							defenderDiceNum = 2;
						
						System.out.println("Attacking Dice: " + attackerDiceNum);
						System.out.println("Defending Dice: " + defenderDiceNum);
						battleLogic.attackPlayer(attackerDiceNum, defenderDiceNum);
						int[] unitsToLose = battleLogic.subtractArmies();

						gameLogic.attackLogic(attackingTerritory, defendingTerritory, unitsToLose);
					}
				}

				/*
				 * ~~~~~~~~~~~~~~~ FORTIFY POSITION LOGIC ~~~~~~~~~~~~~~~~~
				 */

				gameLogic.fortifyPosition();

			}
		}
	}

}
