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

			if (attackDice.getDice().get(i) > defendDice.getDice().get(i)) {
				countDefend++;
			}
		}
		//defender.addArmies((-1)*countDefend);
		//attacker.addArmies((-1)*countAttack);

		//System.out.println("countAttack"+countAttack);
		//System.out.println("countDefend"+countDefend);
		unitsToLose[0] = ((-1) * countAttack);
		unitsToLose[1] = ((-1) * countDefend);
		//System.out.println("UNITS TO LOOSE"+unitsToLose[0]);
		//System.out.println(unitsToLose[1]);

		return unitsToLose;
	}

	public boolean attackerWin() {
		if (defendingTerritory.getUnits() <= 0) {
			//System.out.println("CHECK2");
			defender.removeTerritory(defendingTerritory);
			attacker.addTerritories(defendingTerritory);
			defendingTerritory.setOwner(attacker);
			attackingTerritory.addUnits(-1);
			defendingTerritory.addUnits(1);
			return true;
		}
		return false;
	}

}
