package tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

import model.Continent;
import model.Crescent;
import model.Dino;
import model.GameLogic;
import model.Human;
import model.Languages;
import model.Pizza;
import model.Player;
import model.Sun;
import model.Territory;
import model.Wildcat;

public class GameLogicTest {

	@Test
	public void test() {
		GameLogic logic= new GameLogic();
		ArrayList<Territory> cTerritories=new ArrayList<Territory>();
		ArrayList<Player> players=new ArrayList<Player>();

		Continent Crescent=new Crescent("Crescent", false);
		Continent Dino=new Dino("Dino", false);
		Continent Pizza=new Pizza("Pizza", false);
		Continent Sun=new Sun("Sun", false);
		Continent Languages=new Languages("Languages", false);
		Continent Wildcat=new Wildcat("Wildcat",false);
		Player human= new Human("human", Color.RED, 0);
		Player human1= new Human("human1", Color.RED, 1);
		Player human2= new Human("human2", Color.RED, 2);

		cTerritories=logic.getTerritories();
		human.setDiceRoll(2);
		human1.setDiceRoll(6);
		human2.setDiceRoll(2);
		logic.addPlayers(human);
		logic.addPlayers(human1);
		logic.addPlayers(human2);
	

		assertEquals(42, cTerritories.size());
		logic.startGame();
		assertEquals(human, logic.getPlayerAt(0));
		assertEquals(human1, logic.getPlayerAt(1));
		assertEquals(human2, logic.getPlayerAt(2));

	}

}
 