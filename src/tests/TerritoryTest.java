package tests;

import static org.junit.Assert.*;

import java.awt.Point;

import javax.swing.JButton;

import org.junit.Test;

import model.Player;
import model.Territory;
import typesOfPlayers.Human;

public class TerritoryTest {

	@Test
	public void test() {
		Player temp = new Human("Player", null, 0);
		JButton button = new JButton();
		Point point = new Point(0, 0);
		Territory terr = new Territory("terr", point, button, temp, 0);

		assertEquals("terr", terr.getName());
		assertEquals(temp, terr.getOwner());
		assertEquals(button, terr.getButton());
		assertEquals(point, terr.getPoint());
		assertEquals(0, terr.getUnits());
		terr.addUnits(1);
		assertEquals(1, terr.getUnits());
		double x = 0;
		double y = 0;
		assertEquals(x, terr.getX(), 0);
		assertEquals(y, terr.getY(), 0);

	}

}
