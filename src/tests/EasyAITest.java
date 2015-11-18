package tests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import ai.EasyAI;
import model.Player;

public class EasyAITest {

	@Test
	public void test() {
		Player easy= new EasyAI("AI", Color.RED, 0);
		
	}

}
