package model;

import java.awt.Image;

public class RiskCard extends Card {

	String territory;
	
	public RiskCard(String territory, CardType type, Image img) {
		super(type, img);
		this.territory = territory;
	}

	public String getTerritory(){
		return territory;
	}
}
