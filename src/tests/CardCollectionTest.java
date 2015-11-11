package tests;

import static org.junit.Assert.*;

import java.awt.Image;
import java.util.ArrayList;

import org.junit.Test;

import model.Card;
import model.CardCollection;
import model.RiskCard;


public class CardCollectionTest {
	Image img1;
	@Test
	public void testGetTerritory() {
		CardCollection collectionTest=new CardCollection();
		ArrayList<Card> cardList= new ArrayList<Card>();
		RiskCard card1 = new RiskCard("d", "GARY", img1);
		assertEquals("d", card1.getTerritory());
		assertNotEquals("f", card1.getTerritory());
	}
	


}
