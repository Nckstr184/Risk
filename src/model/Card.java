package model;

import java.awt.Image;
import java.io.Serializable;

public class Card implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3005289275114639521L;
	CardType type;
	Image img;

	public Card(CardType type, Image img) {
		this.type = type;
		this.img = img;
	}

	public CardType getType() {
		return type;
	}

	public Image getImage() {
		return img;
	}

}
