package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Continent;
import model.Crescent;
import model.Dino;
import model.GameLogic;
import model.Languages;
import model.Pizza;
import model.Sun;
import model.Territory;
import model.Wildcat;

public class GameLogicTest {

	@Test
	public void test() {
		GameLogic logic= new GameLogic();
		ArrayList<Territory> cTerritories=new ArrayList<Territory>();
		Continent Crescent=new Crescent("Crescent", false);
		Continent Dino=new Dino("Dino", false);
		Continent Pizza=new Pizza("Pizza", false);
		Continent Sun=new Sun("Sun", false);
		Continent Languages=new Languages("Languages", false);
		Continent Wildcat=new Wildcat("Wildcat",false);
		
		cTerritories=Crescent.getTerritories();
		cTerritories.addAll(Dino.getTerritories());
		cTerritories.addAll(Pizza.getTerritories());
		cTerritories.addAll(Sun.getTerritories());
		cTerritories.addAll(Languages.getTerritories());
		cTerritories.addAll(Wildcat.getTerritories());

		assertEquals(cTerritories, logic.getTerritories());
	}

}
 