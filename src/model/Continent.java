package model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Continent implements Serializable{
	
	String name;
	ArrayList<Territory> territories;
	boolean conquered=false;
	
	public Continent(String cName, ArrayList<Territory> cTerritories, boolean cConquered){
		name=cName;
		territories= cTerritories;
		conquered= cConquered;
		
		
	}
	public String getName(){
		return name;
	}
	public ArrayList<Territory> getTerritories(){
		return territories;
	}
	public boolean cConquered(){
		return conquered;
	}

}
