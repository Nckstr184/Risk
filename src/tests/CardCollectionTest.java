package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.awt.Image;
import java.util.ArrayList;

import org.junit.Test;

import model.Card;
import model.CardCollection;
import model.CardType;
import model.RiskCard;


public class CardCollectionTest {
	Image img1;
	@Test
	public void testGetTerritory() {
		
		ArrayList<Card> cardList= new ArrayList<Card>();
		RiskCard card1 = new RiskCard("d",CardType.GARY, img1);
		RiskCard card2 = new RiskCard("c", CardType.SPONGEBOB, img1);		
		assertEquals("d", card1.getTerritory());
		assertNotEquals("f", card1.getTerritory());
		assertEquals("c", card2.getTerritory());
		assertNotEquals("d", card2.getTerritory());
		
	}
	
	@Test
	public void testCollectin(){
		CardCollection collectionTest=new CardCollection();
		Card A = collectionTest.getCard(0);
		Card B = collectionTest.getCard(1);
		Card C = collectionTest.getCard(2);
		CardType D = A.getType();
		CardType E = B.getType();
		CardType F = C.getType();
		
		assertEquals("SPONGEBOB", D);
		assertNotEquals("PATRICK", D);
		assertNotEquals("GARY", D);
		
		assertNotEquals("SPONGEBOB", E);
		assertEquals("PATRICK", E);
		assertNotEquals("GARY", E);
		
		assertNotEquals("SPONGEBOB", F);
		assertNotEquals("PATRICK", F);
		assertEquals("GARY", F);
		
	}
	
	@Test
	public void testShuffle(){
		CardCollection collectionTest1 = new CardCollection();
		CardCollection collectionTest2 = new CardCollection();
		
		
		
		Card card1 = collectionTest1.getCard(1);
		collectionTest1.shuffle();
		Card shuffledCard1 = collectionTest1.getCard(1);
		
		assertNotEquals(card1, shuffledCard1);
		
		
	}
	@Test
	public void testGetCard(){
		CardCollection collectionTest1 = new CardCollection();
		Card card1 = collectionTest1.getCard(1);
		Card card2 = collectionTest1.getCard(2);
	
		
		assertNotEquals(card1, card2);
		assertEquals(card1,card1);
		
		Card card3 = collectionTest1.getCard(24);
		Card card4 = collectionTest1.getCard(28);
		
		assertNotEquals(card1, card4);
		assertNotEquals(card3,card4);
		assertEquals(card4,card4);
		
	}
	


}
