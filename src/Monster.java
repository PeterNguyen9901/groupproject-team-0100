public class Monster {
	private HP health;
	private int Attack;
	private monsterType MonType;
	public Monster(monsterType monType) {
		MonType = monType;
		health = new HP();
		health.setHp(50);
		Attack = 5;
	}
	public HP getHP() {
		return health;
	}
	public void setHP(int n) {
		health.setHp(n);
	}
	public int getAtk() {
		return Attack;
	}
	public void setAtk(int n) {
		Attack = n;
	}
	
	 public monsterType getMonType(){
	 	return MonType;
	 }
}