package model;

import java.awt.Image;

public abstract class Card {

	String type;
	Image img;

	public Card(String type, Image img) {
		this.type = type;
		this.img = img;
	}

	public String getType() {
		return type;
	}

	public Image getImage() {
		return img;
	}

}
