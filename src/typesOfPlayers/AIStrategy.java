package typesOfPlayers;

import java.util.ArrayList;

import model.Territory;

public interface AIStrategy {
	
	public ArrayList<Object> deployArmy();
	
	public boolean chooseRetreat(Territory currentTerr);
	
	public Territory attackTerritory(Territory currentTerr, ArrayList<Territory> connected);
	
	public ArrayList<Object> fortifyPosition(Territory currentTerr, ArrayList<Territory> connected);
}
