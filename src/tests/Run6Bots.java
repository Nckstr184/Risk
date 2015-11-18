package tests;

import java.awt.Color;

import model.EasyAI;
import model.GameLogic;
import model.MediumAI;

public class Run6Bots {
	
	public static void main(String[] args) {
		EasyAI ai1 = new EasyAI("1", Color.RED, 20);
		EasyAI ai2 = new EasyAI("2", Color.BLUE, 20);
		EasyAI ai3 = new EasyAI("3", Color.GREEN, 20);
		MediumAI ai4 = new MediumAI("4", Color.BLACK, 20);
		MediumAI ai5 = new MediumAI("5", Color.CYAN, 20);
		MediumAI ai6 = new MediumAI("6", Color.GRAY, 20);
		GameLogic logic = new GameLogic();
		logic.addPlayers(ai1);
		logic.addPlayers(ai2);
		logic.addPlayers(ai3);
		logic.addPlayers(ai4);
		logic.addPlayers(ai5);
		logic.addPlayers(ai6);
		
		logic.startGame();
		
		
	}
}
