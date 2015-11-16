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
		Continent Crescent=new Crescent("Crescent", false);
		Continent Dino=new Dino("Dino", false);
		Continent Pizza=new Pizza("Pizza", false);
		Continent Sun=new Sun("Sun", false);
		Continent Languages=new Languages("Languages", false);
		Continent Wildcat=new Wildcat("Wildcat", false);
		
		cTerritories = Wildcat.getTerritories();
		assertNotEquals(cTerritories, Pizza.getTerritories());

		assertEquals("Wildcat", Wildcat.getName());
		assertEquals("Languages", Languages.getName());
		assertEquals("Crescent", Crescent.getName());
		assertEquals("Dino", Dino.getName());
		assertEquals("Pizza", Pizza.getName());
		assertEquals("Sun", Sun.getName());
		assertEquals(false, Sun.cConquered());


	}

}
