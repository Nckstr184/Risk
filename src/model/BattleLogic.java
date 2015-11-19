package model;

import java.util.ArrayList;

//WE NEED TO CHECK TO SEE IF ATTACKER HAS MORE THAN ONE ARMY BEFORE WE RUN BATTLE LOGIC!!!!!!!!!!!////////

public class BattleLogic {
	private Player attacker, defender;
	private Dice attackDice, defendDice;
	private int numOfAttackDice, numOfDefendDice, mostDiceOnField;

	public BattleLogic(Player attacker, Player defender) {
		this.attacker = attacker;
		this.defender = defender;
	}

	public void attackPlayer(int numOfAttackDice, int numOfDefendDice) {
	
		this.numOfAttackDice = numOfAttackDice;
		this.numOfDefendDice = numOfDefendDice;
		
		if(numOfAttackDice <= numOfDefendDice)
			mostDiceOnField = numOfDefendDice;
		else
			mostDiceOnField = numOfAttackDice;
		
		// roll the attackers dice (1-3)
		attackDice = new Dice(numOfAttackDice);

		// roll the defending dice (1-2)
		defendDice = new Dice(numOfDefendDice);
		
	}
	
	public int armiesAttackerLost() {
		int count = 0;
		
		for(int i=0; i<mostDiceOnField;i++) {
			if(attackDice.getDice().get(i) <= defendDice.getDice().get(i))
				count++;
		}
		return count;
	}
	
	public int armiesDefenderLost() {
		int count = 0;
		
		for(int i=0; i<mostDiceOnField;i++) {
			if(attackDice.getDice().get(i) > defendDice.getDice().get(i))
				count++;
		}
		return count;
	}
	
	public boolean attackerWin()
	{
		if(defender.getNumOfArmies()==0)
		{
			return true;
		}
		return false;
	}
	
}
