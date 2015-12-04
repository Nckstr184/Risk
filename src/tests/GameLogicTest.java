package tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

import model.Continent;
import model.Crescent;
import model.Dino;
import model.GameLogic;
import model.Languages;
import model.Pizza;
import model.Player;
import model.Sun;
import model.Territory;
import model.Wildcat;
import typesOfPlayers.Human;

public class GameLogicTest {

	@Test
	public void test() {
		ArrayList<Territory> cTerritories = new ArrayList<Territory>();
		Continent Crescent = new Crescent("Crescent", false);
		Continent Dino = new Dino("Dino", false);
		Continent Pizza = new Pizza("Pizza", false);
		Continent Sun = new Sun("Sun", false);
		Continent Languages = new Languages("Languages", false);
		Continent Wildcat = new Wildcat("Wildcat", false);
		Player human = new Human("human", Color.RED, 0);
		Player human2 = new Human("human2", Color.BLACK, 0);
		Player human3 = new Human("human3", Color.BLACK, 0);
		Player human4 = new Human("human4", Color.BLACK, 0);

		GameLogic logic = new GameLogic(human, human2, human3, human4, null, null);

		cTerritories = logic.getTerritories();
		assertEquals(42, cTerritories.size());
		assertEquals(human, logic.getPlayerAt(0));
		logic.startGame();
		assertEquals(human, logic.getPlayerAt(0));

		assertEquals(4, logic.getNumOfPlayers());
		logic.removePlayer(human);
		assertEquals(logic.getNumOfPlayers(), 3);
	}

}