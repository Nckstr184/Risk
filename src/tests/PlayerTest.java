package tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

import model.Card;
import model.Human;
import model.Player;
import model.RiskCard;
import model.Territory;

public class PlayerTest {

	@Test
	public void test() {
		Player test=new Human("test",Color.BLACK, 0);
		Card temp=new RiskCard(null, null, null);
		Territory tempT= new Territory(null, null, null, test, 0);

		assertEquals("test", test.getName());
		assertEquals(Color.BLACK, test.returnColor());
		ArrayList<Territory> tList=test.getTerritories();
		assertEquals(0, tList.size());
		ArrayList<Card> cList=test.getCards();
		assertEquals(0, cList.size());
		test.addCard(temp);
		test.addTerritories(tempT);
		assertEquals(1, tList.size());
		assertEquals(1, cList.size());
		test.removeCard(temp);
		test.removeTerritory(tempT);
		assertEquals(0, tList.size());
		assertEquals(0, cList.size());
		test.setDiceRoll(1);
		assertEquals(1, test.getDiceRoll());
		assertEquals(0, test.getNumOfArmies());
	}

}
