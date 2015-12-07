package tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

import model.Continent;
import model.Crescent;
import model.Dino;
import model.Languages;
import model.Pizza;
import model.Player;
import model.Sun;
import model.Territory;
import model.Wildcat;
import typesOfPlayers.Human;

public class ContinentTest {

	@Test
	public void test() {
		Player Test1 = new Human("Test1", Color.BLACK, 10, false);
		Player Test2 = new Human("Test2", Color.BLACK, 10, false);

		ArrayList<Territory> cTerritories = new ArrayList<Territory>();
		Continent Crescent = new Crescent("Crescent", false);
		Continent Dino = new Dino("Dino", false);
		Continent Pizza = new Pizza("Pizza", false);
		Continent Sun = new Sun("Sun", false);
		Continent Languages = new Languages("Languages", false);
		Continent Wildcat = new Wildcat("Wildcat", false);
		ArrayList<Territory> territories = new ArrayList<Territory>();

		cTerritories = Wildcat.getTerritories();
		assertNotEquals(cTerritories, Pizza.getTerritories());

		assertEquals("Wildcat", Wildcat.getName());
		assertEquals("Languages", Languages.getName());
		assertEquals("Crescent", Crescent.getName());
		assertEquals("Dino", Dino.getName());
		assertEquals("Pizza", Pizza.getName());
		assertEquals("Sun", Sun.getName());
		territories = Wildcat.getTerritories();
		for (int i = 0; i < 7; i++) {
			territories.get(i).setOwner(Test1);
		}
		for (int i = 0; i < 6; i++) {
			Crescent.getTerritories().get(i).setOwner(Test1);
		}
		for (int i = 0; i < 6; i++) {
			Dino.getTerritories().get(i).setOwner(Test1);
		}
		for (int i = 0; i < 6; i++) {
			Pizza.getTerritories().get(i).setOwner(Test1);
		}
		for (int i = 0; i < 6; i++) {
			Sun.getTerritories().get(i).setOwner(Test1);
		}
		for (int i = 0; i < 6; i++) {
			Languages.getTerritories().get(i).setOwner(Test1);
		}

		Crescent.getTerritories().get(6).setOwner(Test2);
		Dino.getTerritories().get(6).setOwner(Test2);
		Pizza.getTerritories().get(6).setOwner(Test2);
		Sun.getTerritories().get(6).setOwner(Test2);
		Languages.getTerritories().get(6).setOwner(Test2);

		assertEquals(false, Languages.isConquered());
		assertEquals(false, Crescent.isConquered());
		assertEquals(false, Dino.isConquered());
		assertEquals(false, Pizza.isConquered());
		assertEquals(false, Sun.isConquered());
		assertEquals(true, Wildcat.isConquered());

		Crescent.getTerritories().get(6).setOwner(Test1);
		Dino.getTerritories().get(6).setOwner(Test1);
		Pizza.getTerritories().get(6).setOwner(Test1);
		Sun.getTerritories().get(6).setOwner(Test1);
		Languages.getTerritories().get(6).setOwner(Test1);
		territories.get(6).setOwner(Test2);

		assertEquals(true, Languages.isConquered());
		assertEquals(true, Crescent.isConquered());
		assertEquals(true, Dino.isConquered());
		assertEquals(true, Pizza.isConquered());
		assertEquals(true, Sun.isConquered());
		assertEquals(false, Wildcat.isConquered());

	}

}
