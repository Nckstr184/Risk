package model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Continent implements Serializable{
	
	String name;
	boolean conquered=false;
	
	public Continent(String cName, boolean cConquered){
		name=cName;
		conquered= cConquered;
		
		
	}
	public String getName(){
		return name;
	}
	public abstract ArrayList<Territory> getTerritories();
		
	public boolean cConquered(){
		return conquered;
	}
	

}
