package model;

public class BattleLogic {
	Player attacker, defender;
	Dice attackDice, defendDice;

	public BattleLogic(Player attacker, Player defender) {
		this.attacker = attacker;
		this.defender = defender;
	}
	
	public void attackPlayer(int numOfAttackDice, int numOfDefendDice) {
		// roll the attackers dice (1-3)
		attackDice = new Dice(numOfAttackDice);
		
		// roll the defending dice (1-2)
		defendDice = new Dice(numOfDefendDice);
	}
}
