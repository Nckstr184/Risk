package tests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import model.BattleLogic;
import model.Player;
import model.Territory;
import typesOfPlayers.Human;

public class BattleLogicTest {

	@Test
	public void test() {
		Player Test1=new Human("Test1", Color.RED, 0);
		Player Test2=new Human("Test2", Color.BLACK, 0);
		Territory terrTest1=new Territory("Terr1", null, null, Test1, 5);
		Territory terrTest2=new Territory("Terr1", null, null, Test2, 5);
		BattleLogic battleTest= new BattleLogic(Test1, Test2, terrTest1, terrTest2);
		
		assertEquals(Test1,battleTest.getAttacker());
		assertEquals(Test2,battleTest.getDefender());
		assertEquals(terrTest1,battleTest.getAttackingTerritory());
		assertEquals(terrTest2,battleTest.getDefendingTerritory());
		


	}

}
