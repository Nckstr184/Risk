package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Continent;
import model.Crescent;
import model.Dino;
import model.Pizza;
import model.Sun;
import model.Territory;

public class ContinentTest {

	@Test
	public void test() {
		ArrayList<Territory> cTerritories=new ArrayList<Territory>();
	//	Continent Crescent=new Crescent("Crescent", cTerritories, false);
		Continent Dino=new Dino("Dino", cTerritories, false);
		Continent Pizza=new Pizza("Pizza", cTerritories, false);
		Continent Sun=new Sun("Sun", cTerritories, false);
		
		//assertEquals("Crescent", Crescent.getName());
		assertEquals("Dino", Dino.getName());
		assertEquals("Pizza", Pizza.getName());
		assertEquals("Sun", Sun.getName());

	}

}
