package tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

import model.Player;
import model.PlayerCollection;
import typesOfPlayers.Human;

public class PlayerCollectionTest {

	@Test
	public void test() {
		PlayerCollection collectionTest=new PlayerCollection();
		ArrayList<Player> playerList= new ArrayList<Player>();
		Player newP=new Human("plaer", Color.RED, 0);
		assertEquals(0, collectionTest.getNumOfPlayers());
		assertEquals(true,collectionTest.addPlayers(newP));
		assertEquals(1, collectionTest.getNumOfPlayers());
		assertEquals(newP, collectionTest.getPlayer(0));
		collectionTest.addPlayers(newP);
		collectionTest.addPlayers(newP);
		collectionTest.addPlayers(newP);
		collectionTest.addPlayers(newP);
		collectionTest.addPlayers(newP);
		assertEquals(false,collectionTest.addPlayers(newP));
		collectionTest.setPlayerList(playerList);
		assertEquals(0, collectionTest.getNumOfPlayers());
		assertEquals(true,collectionTest.addPlayers(newP));
		assertEquals(1, collectionTest.getNumOfPlayers());
		

	}

}
