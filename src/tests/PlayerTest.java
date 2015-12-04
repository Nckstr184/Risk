package tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.Card;
import model.CardType;
import model.Player;
import model.RiskCard;
import model.Territory;
import typesOfPlayers.Human;

public class PlayerTest {

	@Test
	public void test() {
		Player test = new Human("test", Color.BLACK, 0);
		Card temp = new RiskCard("Card1", CardType.GARY, null);
		Card temp1 = new RiskCard("Card2", CardType.GARY, null);
		Card temp2 = new RiskCard("Card3", CardType.GARY, null);
		Card temp3 = new RiskCard("Card4", CardType.WILD, null);
		Card temp4 = new RiskCard("Card5", CardType.SPONGEBOB, null);
		Card temp5 = new RiskCard("Card6", CardType.PATRICK, null);

		Territory tempT = new Territory("terr", null, null, test, 0);
		ArrayList<Card> tempCards = new ArrayList<Card>();

		assertEquals("test", test.getName());
		assertEquals(Color.BLACK, test.returnColor());
		ArrayList<Territory> tList = test.getTerritories();
		assertEquals(0, tList.size());
		ArrayList<Card> cList = test.getCards();
		assertEquals(0, cList.size());
		test.addCard(temp);
		assertEquals(false, test.turnInCard());
		test.addTerritories(tempT);
		assertEquals(1, tList.size());
		assertEquals(1, cList.size());
		test.removeTerritory(tempT);
		tempCards.add(temp);
		test.removeCard(tempCards);
		tList = test.getTerritories();
		assertEquals(0, tList.size());
		assertEquals(0, cList.size());
		test.setDiceRoll(1);
		assertEquals(1, test.getDiceRoll());
		assertEquals(0, test.getNumOfArmies());
		test.addCard(temp);
		test.addCard(temp1);
		test.addCard(temp2);
		assertEquals(true, test.turnInCard());
		test.addCard(temp);
		test.addCard(temp1);
		test.addCard(temp3);
		assertEquals(true, test.turnInCard());
		test.addCard(temp);
		test.addCard(temp4);
		test.addCard(temp5);
		assertEquals(true, test.turnInCard());
		test.addArmies(5);
		assertEquals(5, test.getNumOfArmies());
		test.removeArmies(5);
		assertEquals(0, test.getNumOfArmies());
		assertEquals("test", test.toString());
		
	}

}
