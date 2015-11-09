package tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

import model.Card;
import model.Human;
import model.Player;
import model.Territory;

public class PlayerTest {

	@Test
	public void test() {
		Player test=new Human("test",Color.BLACK);

		assertEquals("test", test.getName());
		assertEquals(Color.BLACK, test.returnColor());
		ArrayList<Territory> tList=test.getTerritories();
		assertEquals(0, tList.size());
		ArrayList<Card> cList=test.getCards();
		assertEquals(0, cList.size());
	}

}
