package tests;

import static org.junit.Assert.*;

import java.awt.Image;

import org.junit.Test;

import model.RiskCard;

public class CardTest {

	@Test
	public void test() {
		Image image=null;
		RiskCard test= new RiskCard("territory","type", image);
		assertEquals("territory", test.getTerritory());
	}

}
