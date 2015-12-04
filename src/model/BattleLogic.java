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
		this.attackingTerritory = attackingTerritory;
		this.defendingTerritory = defendingTerritory;
	}
	
	public Player getAttacker()
	{
		return this.attacker;
	}

	public Player getDefender()
	{
		return this.defender;
	}
	
	public Territory getAttackingTerritory()
	{
		return this.attackingTerritory;
	}

	public Territory getDefendingTerritory()
	{
		return this.defendingTerritory;
	}
	public void attackPlayer(int numOfAttackDice, int numOfDefendDice) {

		this.numOfAttackDice = numOfAttackDice;
		this.numOfDefendDice = numOfDefendDice;

		if (numOfAttackDice >= numOfDefendDice)
			leastDiceOnField = numOfDefendDice;
		else
			leastDiceOnField = numOfAttackDice;

		// roll the attackers dice (1-3)
		attackDice = new Dice(numOfAttackDice);

		// roll the defending dice (1-2)
		defendDice = new Dice(numOfDefendDice);
		subtractArmies();
	}


	public int[] subtractArmies() {
		
		int countAttack = 0;
		int countDefend = 0;
		
		int[] unitsToLose = new int[2];

		for (int i = 0; i < leastDiceOnField; i++) {
			//System.out.println("Attack Dice"+attackDice.getDice().size() );
			//System.out.println("Defend Dice"+defendDice.getDice().size() );

			if (attackDice.getDice().get(i) <= defendDice.getDice().get(i))
				countAttack++;

			else if (attackDice.getDice().get(i) > defendDice.getDice().get(i)) {
				countDefend++;
			}
		}
		unitsToLose[0] = (countAttack);
		unitsToLose[1] = (countDefend);

		return unitsToLose;
	}

}
