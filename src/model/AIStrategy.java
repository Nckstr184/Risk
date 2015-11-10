package model;

import java.util.ArrayList;

public interface AIStrategy {
	
	public Territory deployArmy(ArrayList<Territory> territories);
	
	public boolean chooseRetreat();
	
	public Territory attackTerritory(ArrayList<Territory> connected);
	
	public void fortifyPosition(ArrayList<Territory> connected);
}
