package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;

public class CardCollection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6250934081881949608L;
	ArrayList<Card> cardCollection, cardCollectionShuffled;
	Image C1T1, C1T2, C1T3, C1T4, C1T5, C1T6, C1T7, C2T1, C2T2, C2T3, C2T4, C2T5, C2T6, C2T7, C3T1, C3T2, C3T3, C3T4,
			C3T5, C3T6, C3T7, C4T1, C4T2, C4T3, C4T4, C4T5, C4T6, C4T7, C5T1, C5T2, C5T3, C5T4, C5T5, C5T6, C5T7, C6T1,
			C6T2, C6T3, C6T4, C6T5, C6T6, C6T7, wildCard1, wildCard2;

	public CardCollection() {

		try {
			C1T1 = ImageIO.read(new File("./Pictures/C1T1.png"));
			C1T2 = ImageIO.read(new File("./Pictures/C1T2.png"));
			C1T3 = ImageIO.read(new File("./Pictures/C1T3.png"));
			C1T4 = ImageIO.read(new File("./Pictures/C1T4.png"));
			C1T5 = ImageIO.read(new File("./Pictures/C1T5.png"));
			C1T6 = ImageIO.read(new File("./Pictures/C1T6.png"));
			C1T7 = ImageIO.read(new File("./Pictures/C1T7.png"));
			C2T1 = ImageIO.read(new File("./Pictures/C2T1.png"));
			C2T2 = ImageIO.read(new File("./Pictures/C2T2.png"));
			C2T3 = ImageIO.read(new File("./Pictures/C2T3.png"));
			C2T4 = ImageIO.read(new File("./Pictures/C2T4.png"));
			C2T5 = ImageIO.read(new File("./Pictures/C2T5.png"));
			C2T6 = ImageIO.read(new File("./Pictures/C2T6.png"));
			C2T7 = ImageIO.read(new File("./Pictures/C2T7.png"));
			C3T1 = ImageIO.read(new File("./Pictures/C3T1.png"));
			C3T2 = ImageIO.read(new File("./Pictures/C3T2.png"));
			C3T3 = ImageIO.read(new File("./Pictures/C3T3.png"));
			C3T4 = ImageIO.read(new File("./Pictures/C3T4.png"));
			C3T5 = ImageIO.read(new File("./Pictures/C3T5.png"));
			C3T6 = ImageIO.read(new File("./Pictures/C3T6.png"));
			C3T7 = ImageIO.read(new File("./Pictures/C3T7.png"));
			C4T1 = ImageIO.read(new File("./Pictures/C4T1.png"));
			C4T2 = ImageIO.read(new File("./Pictures/C4T2.png"));
			C4T3 = ImageIO.read(new File("./Pictures/C4T3.png"));
			C4T4 = ImageIO.read(new File("./Pictures/C4T4.png"));
			C4T5 = ImageIO.read(new File("./Pictures/C4T5.png"));
			C4T6 = ImageIO.read(new File("./Pictures/C4T6.png"));
			C4T7 = ImageIO.read(new File("./Pictures/C4T7.png"));
			C5T1 = ImageIO.read(new File("./Pictures/C5T1.png"));
			C5T2 = ImageIO.read(new File("./Pictures/C5T2.png"));
			C5T3 = ImageIO.read(new File("./Pictures/C5T3.png"));
			C5T4 = ImageIO.read(new File("./Pictures/C5T4.png"));
			C5T5 = ImageIO.read(new File("./Pictures/C5T5.png"));
			C5T6 = ImageIO.read(new File("./Pictures/C5T6.png"));
			C5T7 = ImageIO.read(new File("./Pictures/C5T7.png"));
			C6T1 = ImageIO.read(new File("./Pictures/C6T1.png"));
			C6T2 = ImageIO.read(new File("./Pictures/C6T2.png"));
			C6T3 = ImageIO.read(new File("./Pictures/C6T3.png"));
			C6T4 = ImageIO.read(new File("./Pictures/C6T4.png"));
			C6T5 = ImageIO.read(new File("./Pictures/C6T5.png"));
			C6T6 = ImageIO.read(new File("./Pictures/C6T6.png"));
			C6T7 = ImageIO.read(new File("./Pictures/C6T7.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR!!!");
			e.printStackTrace();
		}

		cardCollection = new ArrayList<Card>();
		cardCollection.add(new RiskCard("Java", CardType.SPONGEBOB, C1T1));
		cardCollection.add(new RiskCard("Python", CardType.PATRICK, C1T2));
		cardCollection.add(new RiskCard("C", CardType.GARY, C1T3));
		cardCollection.add(new RiskCard("SQL", CardType.SPONGEBOB, C1T4));
		cardCollection.add(new RiskCard("Ruby", CardType.PATRICK, C1T5));
		cardCollection.add(new RiskCard("Git", CardType.GARY, C1T6));
		cardCollection.add(new RiskCard("Perl", CardType.SPONGEBOB, C1T7));
		cardCollection.add(new RiskCard("Wilber", CardType.PATRICK, C2T1));
		cardCollection.add(new RiskCard("Wilma", CardType.GARY, C2T2));
		cardCollection.add(new RiskCard("Rich", CardType.SPONGEBOB, C2T3));
		cardCollection.add(new RiskCard("Miller", CardType.PATRICK, C2T4));
		cardCollection.add(new RiskCard("Scooby", CardType.GARY, C2T5));
		cardCollection.add(new RiskCard("McKale", CardType.SPONGEBOB, C2T6));
		cardCollection.add(new RiskCard("Zone", CardType.GARY, C2T7));
		cardCollection.add(new RiskCard("Papa Johns", CardType.GARY, C3T1));
		cardCollection.add(new RiskCard("Dominos", CardType.SPONGEBOB, C3T2));
		cardCollection.add(new RiskCard("PizzaHut", CardType.PATRICK, C3T3));
		cardCollection.add(new RiskCard("Black Jack", CardType.GARY, C3T4));
		cardCollection.add(new RiskCard("Hungry Howie", CardType.SPONGEBOB, C3T5));
		cardCollection.add(new RiskCard("Brooklyn's", CardType.PATRICK, C3T6));
		cardCollection.add(new RiskCard("Pizza Planet", CardType.GARY, C3T7));
		cardCollection.add(new RiskCard("RawrVille", CardType.SPONGEBOB, C4T1));
		cardCollection.add(new RiskCard("Laiegges", CardType.PATRICK, C4T2));
		cardCollection.add(new RiskCard("Dactilito", CardType.GARY, C4T3));
		cardCollection.add(new RiskCard("Miller", CardType.PATRICK, C4T4));
		cardCollection.add(new RiskCard("DirtyDan", CardType.SPONGEBOB, C4T5));
		cardCollection.add(new RiskCard("BlackBeard", CardType.PATRICK, C4T6));
		cardCollection.add(new RiskCard("Monisaurus", CardType.GARY, C4T7));
		cardCollection.add(new RiskCard("Scraptopia", CardType.SPONGEBOB, C5T1));
		cardCollection.add(new RiskCard("Land Of Zach", CardType.GARY, C5T2));
		cardCollection.add(new RiskCard("Giant", CardType.SPONGEBOB, C5T3));
		cardCollection.add(new RiskCard("New Land Of Zach", CardType.PATRICK, C5T4));
		cardCollection.add(new RiskCard("South Scraptopia", CardType.GARY, C5T5));
		cardCollection.add(new RiskCard("Bloo Bawl", CardType.SPONGEBOB, C5T6));
		cardCollection.add(new RiskCard("Crescent Capital", CardType.PATRICK, C5T7));
		cardCollection.add(new RiskCard("Apollo", CardType.GARY, C6T1));
		cardCollection.add(new RiskCard("Ra", CardType.SPONGEBOB, C6T2));
		cardCollection.add(new RiskCard("Helios", CardType.PATRICK, C6T3));
		cardCollection.add(new RiskCard("Inti", CardType.GARY, C6T4));
		cardCollection.add(new RiskCard("Horus", CardType.SPONGEBOB, C6T5));
		cardCollection.add(new RiskCard("Tonatiuh", CardType.PATRICK, C6T6));
		cardCollection.add(new RiskCard("Amun", CardType.GARY, C6T7));
		cardCollection.add(new WildCard("wild1", CardType.WILD, wildCard1));
		cardCollection.add(new WildCard("wild2", CardType.WILD, wildCard2));

	}

	public ArrayList<Card> getCardCollection() {

		return cardCollection;
	}

	public void shuffle() {
		Collections.shuffle(cardCollection);
	}

	public Card getCard(int i) {
		return cardCollection.get(i);
	}
	
	public ArrayList<String> getNamesOfCards()
	{
		Card temp=null;
		ArrayList<String> names= new ArrayList<String>();
		for(int i=0; i<42; i++)
		{
			temp=cardCollection.get(i);
			names.add(temp.getTerritory());
		}
		return names;
	}
	
	public void setLoadedCardOrder(ArrayList<String> oldCards)
	{
		String name="";
		for(int i=0; i<42; i++)
		{
			Card temp=null;
			name=oldCards.get(i);
			for(int j=0; j<42; j++)
			{
				if(((RiskCard) this.getCard(j)).getTerritory().equals(name))
				{
					temp=cardCollection.get(i);
					cardCollection.set(i, cardCollection.get(j));
					cardCollection.set(j, temp);
				}
			}
		}
		}

}