package model;

import java.awt.Color;
import java.util.ArrayList;

public abstract class Player {

	private String name;
	private Color playerColor;
	private ArrayList<Card> playerCards;
	private ArrayList<Territory> playerTerritories;
	
	
	public Player(String name, Color color)
	{
		this.name=name;
		this.playerColor=color;
		playerCards=new ArrayList<Card>();
		playerTerritories=new ArrayList<Territory>();
	}
	
	public ArrayList<Territory> getTerritories()
	{
		return playerTerritories;
	}
	
	public ArrayList<Card> getCards()
	{
		return playerCards;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Color returnColor()
	{
		return playerColor;
	}
	
	public void addCard(Card newCard)
	{
		playerCards.add(newCard);
	}
	
	public void addTerritories(Territory newTerritory)
	{
		playerTerritories.add(newTerritory);
	}
	
	public void removeTerritory(Territory removedTerritory)
	{
		int index=playerTerritories.indexOf(removedTerritory);
		if(index>=0)
		{
			playerTerritories.remove(index);
		}
	}
	
	public void removeCard(Card removedCard)
	{
		int index=playerCards.indexOf(removedCard);
		if(index>=0)
		{
			playerCards.remove(index);
		}
	}
	
}
