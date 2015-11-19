package tests;

import java.awt.Color;
import java.util.ArrayList;

import model.BattleLogic;
import model.CardCollection;
import model.GameLogic;
import model.Player;
import model.PlayerCollection;
import model.Territory;
import typesOfPlayers.EasyAI;
import typesOfPlayers.MediumAI;

public class Run6Bots {

	public static void main(String[] args) {
		Player ai1 = new EasyAI("easy", Color.RED, 20);
		Player ai2 = new EasyAI("easy", Color.BLUE, 20);
		Player ai3 = new EasyAI("easy", Color.GREEN, 20);
		Player ai4 = new MediumAI("medium", Color.BLACK, 20);
		Player ai5 = new MediumAI("medium", Color.CYAN, 20);
		Player ai6 = new MediumAI("medium", Color.GRAY, 20);
		GameLogic gameLogic = new GameLogic();
		BattleLogic battleLogic;
		gameLogic.addPlayers(ai1);
		gameLogic.addPlayers(ai2);
		gameLogic.addPlayers(ai3);
		gameLogic.addPlayers(ai4);
		gameLogic.addPlayers(ai5);
		gameLogic.addPlayers(ai6);
		int easyWin = 0, mediumWin = 0, nextCard = 0;
		
		CardCollection allCards = new CardCollection();
		allCards.shuffle();

		for (int i = 0; i < 1000; i++) {
			gameLogic.startGame();
			PlayerCollection allPlayers = gameLogic.getPlayerList();
			int count = 0;
			Player currPlayer = null;
			while (!gameLogic.isGameComplete()) {
				// TODO: Deploy Armies Phase
				
				// TODO: Figure out rewarding cards
				// Attack Phase
				currPlayer = allPlayers.getPlayer(count % 6);
				ArrayList<Territory> territories = currPlayer.getTerritories();
				currPlayer.deployArmy(territories);
				int mostArmies = 0, indexOfMost = 0;
				for (int j = 0; j < territories.size(); j++) {
					if (mostArmies < territories.get(j).getUnits()) {
						mostArmies = territories.get(j).getUnits();
						indexOfMost = j;
					}
				}
				Territory currTerritory = territories.get(indexOfMost);
				Territory attackingTerritory = currPlayer.attackTerritory(currTerritory, currTerritory.getNeighbors());
				if (attackingTerritory != null) {
					battleLogic = new BattleLogic(currPlayer, attackingTerritory.getOwner());

					while (currPlayer.chooseRetreat(currTerritory)) {
						battleLogic.attackPlayer((currTerritory.getUnits() - 1) % 3,
								(attackingTerritory.getUnits() - 1) % 2);
						currPlayer.addArmies(battleLogic.armiesAttackerLost());
						attackingTerritory.getOwner().addArmies(battleLogic.armiesDefenderLost());
					}
				}
				
				// Fortify Phase
				currPlayer.fortifyPosition(currTerritory, currTerritory.getNeighbors());
			}
			if(currPlayer.getName().equals("easy")) {
				easyWin++;
			}
			else if(currPlayer.getName().equals("medium")) {
				mediumWin++;
			}
		}
		
		System.out.println("EasyAI wins: " + easyWin);
		System.out.println("MediumAI wins: " + mediumWin);
	}
}
