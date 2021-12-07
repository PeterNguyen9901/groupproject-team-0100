public class Monster {
	private HP health;
	private int Attack;
	private monsterType MonType;
	private Level monsterLevel;
	private int reward;//variable to hold how much gold the player would get
	public Monster(monsterType monType) {
		monsterLevel = new Level();
		MonType = monType;
		health = new HP();
		int level = monsterLevel.getLevel();
		health.setHp(level * 2 + (20 * (level*10/5)) );
		Attack = level * 3 / 2;
		reward = level * 30;
	}
	public int getLevel() {
		return monsterLevel.getLevel();
	}
	public void addLevel(int x) {
		monsterLevel.addLevel(x);
		int level = monsterLevel.getLevel();
		health.setHp(level * 2 + (20 * (level*10/5)) );
		Attack = level * 3 / 2;
		reward = level * 30;
	}
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