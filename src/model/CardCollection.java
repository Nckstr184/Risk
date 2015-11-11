package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class CardCollection implements Serializable{
	
	ArrayList<Card> cardCollection;
	
	public CardCollection(){
		cardCollection = new ArrayList<Card>();
	}
	
	public ArrayList<Card> getCardCollection(){
		
		return cardCollection;
	}
	
	public ArrayList<Card> shuffle(){
		Collections.shuffle(cardCollection);
		return cardCollection;
	}
	public Card getCard(int i){
		return cardCollection.get(i);
	}
	

}
