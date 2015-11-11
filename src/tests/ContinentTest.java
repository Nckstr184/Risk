package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Continent;
import model.Crescent;
import model.Dino;
import model.Languages;
import model.Pizza;
import model.Sun;
import model.Territory;
import model.Wildcat;

public class ContinentTest {

	@Test
	public void test() {
		ArrayList<Territory> cTerritories=new ArrayList<Territory>();
		Continent Crescent=new Crescent("Crescent", cTerritories, false);
		Continent Dino=new Dino("Dino", cTerritories, false);
		Continent Pizza=new Pizza("Pizza", cTerritories, false);
		Continent Sun=new Sun("Sun", cTerritories, false);
		Continent Languages=new Languages("Languages", cTerritories, false);
		Continent Wildcat=new Wildcat("Wildcat", cTerritories, false);

		assertEquals("Wildcat", Wildcat.getName());
		assertEquals("Languages", Languages.getName());
		assertEquals("Crescent", Crescent.getName());
		assertEquals("Dino", Dino.getName());
		assertEquals("Pizza", Pizza.getName());
		assertEquals("Sun", Sun.getName());
		assertEquals(cTerritories, Sun.getTerritories());
		assertEquals(false, Sun.cConquered());


	}

}
