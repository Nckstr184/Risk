package tests;

import static org.junit.Assert.*;

import java.awt.Image;

import org.junit.Test;

import model.RiskCard;
import model.WildCard;

public class CardTest {

	@Test
	public void test() {
		Image image=null;
		RiskCard test= new RiskCard("territory","type", image);
		assertEquals("territory", test.getTerritory());
		WildCard test1= new WildCard("territory",image);
		assertEquals("territory", test1.getType());
		assertEquals(image, test1.getImage());

	}

}
