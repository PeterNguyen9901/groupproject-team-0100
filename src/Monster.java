public class Monster {
	private HP health;
	private int Attack;
	private monsterType MonType;
	private int reward;//variable to hold how much gold the player would get
	public Monster(monsterType monType, int level) {
		Level l = new Level();
		level = l.getLevel();
		MonType = monType;
		health = new HP();
		health.setHp(level * 2 + (20 * (level*10/5)) );
		Attack = level * 5 / 2;
		reward = level * 30;
	}
	/*public HP getHP() {
		return health;
	}*/
	
	public int getHP() { 
		return health.getHp();
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