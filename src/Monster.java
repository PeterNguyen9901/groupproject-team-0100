public class Monster {
	private HP health;
	private int Attack;
	private monsterType MonType;
	private int reward;//variable to hold how much gold the player would get
	public Monster(monsterType monType, int level) {
		MonType = monType;
		health = new HP();
		health.setHp(50);
		Attack = 5;
		reward = level * 30;
	}
	public HP getHP() {
		return health;
	}
	public void setHP(int n) {
		health.setHp(n);
	}
	public void loseHP(int dmg) {
		health.takeDamage(dmg);
	}
	public int getAtk() {
		return Attack;
	}
	public void setAtk(int n) {
		Attack = n;
	}
	public int getReward() {
		return reward;
	}
	public monsterType getMonType(){
		return MonType;
	}
}