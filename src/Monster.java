public class Monster {
	private int Health;
	private int Attack;
	//private MonsterType MonType;
	//private WeaponType Weakness;
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
	/*
	 public MonsterType getMonType(){
	 	return MonType;
	 }
	 public WeaponType getWeakness(){
	 	return Weakness;
	 }
	 */
}