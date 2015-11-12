package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import model.Card;

import javax.imageio.ImageIO;

public class CardCollection implements Serializable{
	ArrayList<Card> cards;
	
	public CardCollection(){
		BufferedImage newImg = null;
		BufferedImage newImg1 = null;
		BufferedImage newImg2 = null;
		BufferedImage newImg3 = null;
		BufferedImage newImg4 = null;
		BufferedImage newImg5 = null;
		BufferedImage newImg6 = null;
		BufferedImage newImg7 = null;
		BufferedImage newImg8 = null;
		BufferedImage newImg9 = null;
		BufferedImage newImg10 = null;
		BufferedImage newImg11 = null;
		BufferedImage newImg12 = null;
		BufferedImage newImg13 = null;
		BufferedImage newImg14 = null;
		BufferedImage newImg15 = null;
		BufferedImage newImg16 = null;
		BufferedImage newImg17 = null;
		BufferedImage newImg18 = null;
		BufferedImage newImg19 = null;
		BufferedImage newImg20 = null;
		BufferedImage newImg21 = null;
		BufferedImage newImg22 = null;
		BufferedImage newImg23 = null;
		BufferedImage newImg24 = null;
		BufferedImage newImg25 = null;
		BufferedImage newImg26 = null;
		BufferedImage newImg27 = null;
		BufferedImage newImg28 = null;
		BufferedImage newImg29 = null;
		BufferedImage newImg30 = null;
		BufferedImage newImg31 = null;
		BufferedImage newImg32 = null;
		BufferedImage newImg33 = null;
		BufferedImage newImg34 = null;
		BufferedImage newImg35 = null;
		BufferedImage newImg36 = null;
		BufferedImage newImg37 = null;
		BufferedImage newImg38 = null;
		BufferedImage newImg39 = null;
		BufferedImage newImg40 = null;
		BufferedImage newImg41 = null;
		
		
		try {
			newImg = ImageIO.read(new File("./Pictures/cards/C1T1.png"));
			newImg1 = ImageIO.read(new File("./Pictures/cards/C1T2.png"));
			newImg2 = ImageIO.read(new File("./Pictures/cards/C1T3.png"));
			newImg3 = ImageIO.read(new File("./Pictures/cards/C1T4.png"));
			newImg4 = ImageIO.read(new File("./Pictures/cards/C1T5.png"));
			newImg5 = ImageIO.read(new File("./Pictures/cards/C1T6.png"));
			newImg6 = ImageIO.read(new File("./Pictures/cards/C1T7.png"));
			
			newImg7 = ImageIO.read(new File("./Pictures/cards/C2T1.png"));
			newImg8 = ImageIO.read(new File("./Pictures/cards/C2T2.png"));
			newImg9 = ImageIO.read(new File("./Pictures/cards/C2T3.png"));
			newImg10 = ImageIO.read(new File("./Pictures/cards/C2T4.png"));
			newImg11 = ImageIO.read(new File("./Pictures/cards/C2T5.png"));
			newImg12 = ImageIO.read(new File("./Pictures/cards/C2T6.png"));
			newImg13 = ImageIO.read(new File("./Pictures/cards/C2T7.png"));
			
			newImg14 = ImageIO.read(new File("./Pictures/cards/C3T1.png"));
			newImg15 = ImageIO.read(new File("./Pictures/cards/C3T2.png"));
			newImg16 = ImageIO.read(new File("./Pictures/cards/C3T3.png"));
			newImg17 = ImageIO.read(new File("./Pictures/cards/C3T4.png"));
			newImg18 = ImageIO.read(new File("./Pictures/cards/C3T5.png"));
			newImg19 = ImageIO.read(new File("./Pictures/cards/C3T6.png"));
			newImg20 = ImageIO.read(new File("./Pictures/cards/C3T7.png"));
			
			newImg21 = ImageIO.read(new File("./Pictures/cards/C4T1.png"));
			newImg22 = ImageIO.read(new File("./Pictures/cards/C4T2.png"));
			newImg23 = ImageIO.read(new File("./Pictures/cards/C4T3.png"));
			newImg24 = ImageIO.read(new File("./Pictures/cards/C4T4.png"));
			newImg25 = ImageIO.read(new File("./Pictures/cards/C4T5.png"));
			newImg26 = ImageIO.read(new File("./Pictures/cards/C4T6.png"));
			newImg27 = ImageIO.read(new File("./Pictures/cards/C4T7.png"));
			
			newImg28 = ImageIO.read(new File("./Pictures/cards/C5T1.png"));
			newImg29 = ImageIO.read(new File("./Pictures/cards/C5T2.png"));
			newImg30 = ImageIO.read(new File("./Pictures/cards/C5T3.png"));
			newImg31 = ImageIO.read(new File("./Pictures/cards/C5T4.png"));
			newImg32 = ImageIO.read(new File("./Pictures/cards/C5T5.png"));
			newImg33 = ImageIO.read(new File("./Pictures/cards/C5T6.png"));
			newImg34 = ImageIO.read(new File("./Pictures/cards/C5T7.png"));
			
			newImg35 = ImageIO.read(new File("./Pictures/cards/C6T1.png"));
			newImg36 = ImageIO.read(new File("./Pictures/cards/C6T2.png"));
			newImg37 = ImageIO.read(new File("./Pictures/cards/C6T3.png"));
			newImg38 = ImageIO.read(new File("./Pictures/cards/C6T4.png"));
			newImg39 = ImageIO.read(new File("./Pictures/cards/C6T5.png"));
			newImg40 = ImageIO.read(new File("./Pictures/cards/C6T6.png"));
			newImg41 = ImageIO.read(new File("./Pictures/cards/C6T7.png"));
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cards.add(new Card(CardType.SPONGEBOB,  newImg));
		cards.add(new Card(CardType.PATRICK,  newImg1));
		cards.add(new Card(CardType.GARY,  newImg2));
		cards.add(new Card(CardType.SPONGEBOB,  newImg3));
		cards.add(new Card(CardType.PATRICK,  newImg5));
		cards.add(new Card(CardType.GARY,  newImg5));
		cards.add(new Card(CardType.SPONGEBOB,  newImg6));
		
		cards.add(new Card(CardType.PATRICK,  newImg7));
		cards.add(new Card(CardType.GARY,  newImg8));
		cards.add(new Card(CardType.SPONGEBOB,  newImg9));
		cards.add(new Card(CardType.PATRICK,  newImg10));
		cards.add(new Card(CardType.GARY,  newImg11));
		cards.add(new Card(CardType.SPONGEBOB,  newImg12));
		cards.add(new Card(CardType.PATRICK,  newImg13));
		
		cards.add(new Card(CardType.GARY,  newImg14));
		cards.add(new Card(CardType.SPONGEBOB,  newImg15));
		cards.add(new Card(CardType.PATRICK,  newImg16));
		cards.add(new Card(CardType.GARY,  newImg17));
		cards.add(new Card(CardType.SPONGEBOB,  newImg18));
		cards.add(new Card(CardType.PATRICK,  newImg19));
		cards.add(new Card(CardType.GARY,  newImg20));
		
		cards.add(new Card(CardType.SPONGEBOB,  newImg21));
		cards.add(new Card(CardType.PATRICK,  newImg22));
		cards.add(new Card(CardType.GARY,  newImg23));
		cards.add(new Card(CardType.SPONGEBOB,  newImg24));
		cards.add(new Card(CardType.PATRICK,  newImg25));
		cards.add(new Card(CardType.GARY,  newImg26));
		cards.add(new Card(CardType.PATRICK,  newImg27));
		
		cards.add(new Card(CardType.SPONGEBOB,  newImg28));
		cards.add(new Card(CardType.GARY,  newImg29));
		cards.add(new Card(CardType.SPONGEBOB,  newImg30));
		cards.add(new Card(CardType.PATRICK,  newImg31));
		cards.add(new Card(CardType.GARY,  newImg32));
		cards.add(new Card(CardType.SPONGEBOB,  newImg33));
		cards.add(new Card(CardType.PATRICK,  newImg34));
		
		cards.add(new Card(CardType.GARY,  newImg35));
		cards.add(new Card(CardType.SPONGEBOB,  newImg36));
		cards.add(new Card(CardType.PATRICK,  newImg37));
		cards.add(new Card(CardType.GARY,  newImg38));
		cards.add(new Card(CardType.SPONGEBOB,  newImg39));
		cards.add(new Card(CardType.PATRICK,  newImg40));
		cards.add(new Card(CardType.GARY,  newImg41));
	}

}
