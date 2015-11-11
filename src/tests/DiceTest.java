package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Dice;

public class DiceTest {

	@Test
	public void testRandom3() {
		Dice test = new Dice(3);
		ArrayList<Integer> testList = test.getDice();
		assertEquals(3,testList.size());	
	}
	@Test
	public void testRandom2() {
		Dice test = new Dice(2);
		ArrayList<Integer> testList = test.getDice();
		assertEquals(2,testList.size());	
	}
	@Test
	public void testRandom1() {
		Dice test = new Dice(1);
		ArrayList<Integer> testList = test.getDice();
		assertEquals(1,testList.size());	
	}
	
	@Test
	public void testDiceGetters() {
		Dice test = new Dice(3);
		test.setDice1(0);
		test.setDice2(1);
		test.setDice3(2);

		assertEquals(0, test.getDice1());
		assertEquals(1, test.getDice2());
		assertEquals(2, test.getDice3());

	}

}
