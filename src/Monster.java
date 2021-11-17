public class Monster {
	private int Health;
	private int Attack;
	private monsterType MonType;
	//private weaponType Weakness;
	public Monster(monsterType monType) {
		MonType = monType;
		Health = 50;
		Attack = 5;
	}
	public int getHP() {
		return Health;
	}
	public void setHP(int n) {
		Health = n;
	}
	public int getAtk() {
		return Attack;
	}
	public void setAtk(int n) {
		Attack = n;
	}
	
	 public monsterType getMonType(){
	 	return MonType;
	 }/*
	 public WeaponType getWeakness(){
	 	return Weakness;
	 }
	 */
}