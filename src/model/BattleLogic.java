package model;

import java.util.ArrayList;

//WE NEED TO CHECK TO SEE IF ATTACKER HAS MORE THAN ONE ARMY BEFORE WE RUN BATTLE LOGIC!!!!!!!!!!!////////

public class BattleLogic {
	private Player attacker, defender; 
	private Dice attackDice, defendDice;
	private Territory attackingTerritory, defendingTerritory;
	private int numOfAttackDice, numOfDefendDice, leastDiceOnField;

	public BattleLogic(Player attacker, Player defender, Territory attackingTerritory, Territory defendingTerritory) {
		this.attacker = attacker;
		this.defender = defender;
		this.attackingTerritory=attackingTerritory;
		this.defendingTerritory=defendingTerritory;
	}

	public void attackPlayer(int numOfAttackDice, int numOfDefendDice) {
	
		this.numOfAttackDice = numOfAttackDice;
		this.numOfDefendDice = numOfDefendDice;
		
		if(numOfAttackDice >= numOfDefendDice)
			leastDiceOnField = numOfDefendDice;
		else
			leastDiceOnField = numOfAttackDice;
		
		// roll the attackers dice (1-3)
		attackDice = new Dice(numOfAttackDice);

		// roll the defending dice (1-2)
		defendDice = new Dice(numOfDefendDice);
		
	}
	
	public int armiesAttackerLost() {
		int count = 0;
		
		for(int i=0; i<leastDiceOnField;i++) {
			if(attackDice.getDice().get(i) <= defendDice.getDice().get(i))
				count++;
		}
		return count;
	}
	
	public int armiesDefenderLost() {
		int count = 0;
		
		for(int i=0; i<leastDiceOnField;i++) {
			if(attackDice.getDice().get(i) > defendDice.getDice().get(i))
				count++;
		}
		return count;
	}
	
	public boolean attackerWin()
	{
		if(defendingTerritory.getUnits()<=0)
		{
			System.out.println("CHECK2");
			return true;
		}
		return false;
	}
	
	public boolean defenderWin() {
		if(attackingTerritory.getUnits()<=0)
		{
			System.out.println("CHECK3");
			return true;
		}
		return false;
	}
	
}
