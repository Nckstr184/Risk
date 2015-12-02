package model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Continent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6326245065173389315L;
	String name;
	boolean conquered = false;

	public Continent(String cName, boolean cConquered) {
		name = cName;
		conquered = cConquered;

	}

	public String getName() {
		return name;
	}

	public abstract ArrayList<Territory> getTerritories();
	public abstract boolean isConquered();

	public void setConquered(boolean conquered) {
		this.conquered = conquered;
	}

	public boolean cConquered() {
		return conquered;
	}

}
