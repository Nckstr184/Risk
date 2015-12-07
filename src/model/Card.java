package model;

import java.awt.Image;
import java.io.Serializable;

public class Card implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3005289275114639521L;
	private CardType type;
	private Image img;
	private String territory;

	public Card(String territory, CardType type, Image img) {
		this.type = type;
		this.img = img;
	}

	public String getTerritory() {
		return territory;
	}
	
	public CardType getType() {
		return type;
	}

	public Image getImage() {
		return img;
	}

}
