package model;

import java.util.ArrayList;

public interface AIStrategy {
	
	public Territory deployArmy(ArrayList<Territory> territories);
	
	public boolean chooseRetreat(Territory currentTerr);
	
	public Territory attackTerritory(Territory currentTerr, ArrayList<Territory> connected);
	
	public void fortifyPosition(Territory currentTerr, ArrayList<Territory> connected);
}
