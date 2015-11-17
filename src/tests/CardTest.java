package tests;

import static org.junit.Assert.assertEquals;

import java.awt.Image;

import org.junit.Test;

import model.CardType;
import model.RiskCard;
import model.WildCard;

public class CardTest {

	@Test
	public void test() {
		Image image=null;
		RiskCard test= new RiskCard("territory",CardType.SPONGEBOB, image);
		assertEquals("territory", test.getTerritory());
		WildCard test1= new WildCard(CardType.WILD,image);
		assertEquals("territory", test1.getType());
		assertEquals(image, test1.getImage());

	}

}
