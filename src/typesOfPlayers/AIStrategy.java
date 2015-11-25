package typesOfPlayers;

import java.util.ArrayList;

import model.Territory;

public interface AIStrategy {
	
	public Territory deployArmy(ArrayList<Territory> territories);
	
	public boolean chooseRetreat(Territory currentTerr);
	
	public Territory attackTerritory(Territory currentTerr, ArrayList<Territory> connected);
	
	public ArrayList<Object> fortifyPosition(Territory currentTerr, ArrayList<Territory> connected);
}
