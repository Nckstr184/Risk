package model;

import java.io.Serializable;
import java.util.ArrayList;

public class PlayerCollection implements Serializable {

	ArrayList<Player> playerList;

	public PlayerCollection() {
		playerList = new ArrayList<Player>();
	}

	public boolean addPlayers(Player player) {
		if (playerList.size() < 6) {
			playerList.add(player);
			return true;
		} else
			return false;
	}

	public Player getPlayer(int index) {
		return playerList.get(index);
	}
	
	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}
	
	public int getNumOfPlayers() {
		return playerList.size();
	}
}
