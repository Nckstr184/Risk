package model;

import java.awt.Image;

public class Card {

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
