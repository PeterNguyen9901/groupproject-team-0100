
import java.util.HashMap;
//test
public class Character {
	private int monsterKilled;
	private Gold Currency;
	HashMap<weaponType,weapons> weaponList;
	HashMap<monsterType, Monster> monsterList;
	//ArrayList<weapons> weaponList;
	//ArrayList<Monster> monsterList;
	Level currLevel;
	HP health;
	public Character() {
		monsterKilled = 0;
		Currency = new Gold();
		health = new HP();
		currLevel = new Level();
		weaponList = new HashMap<weaponType, weapons>();
		monsterList = new HashMap<monsterType, Monster>();
		initWeaponsList();
		initMonsterList();
	}
	public int getmonsterKilled() {
		return monsterKilled;
	}


	public void setMonsterKilled(int monsterKilled) {
		this.monsterKilled = monsterKilled;
	}
	public void setLevel(int x) {
		currLevel.setLevel(x);
	}
	public int getLevel() {
		return currLevel.getLevel();
	}
	
	public void initWeaponsList() {
		//fill
		weaponList.put(weaponType.AXE, new weapons(weaponType.AXE));
		weaponList.put(weaponType.SWORD, new weapons(weaponType.SWORD));
		weaponList.put(weaponType.BOW, new weapons(weaponType.BOW));
		weaponList.put(weaponType.SPEAR, new weapons(weaponType.SPEAR));
		weaponList.put(weaponType.DAGGER, new weapons(weaponType.DAGGER));
	}
	public void initMonsterList() {
		monsterList.put(monsterType.SLIME,new Monster(monsterType.SLIME, getLevel()));
		monsterList.put(monsterType.GOBLIN,new Monster(monsterType.GOBLIN, getLevel()));
		monsterList.put(monsterType.WEREWOLF,new Monster(monsterType.WEREWOLF, getLevel()));
		monsterList.put(monsterType.BANDIT,new Monster(monsterType.BANDIT, getLevel()));
		monsterList.put(monsterType.KNIGHT,new Monster(monsterType.KNIGHT, getLevel()));
		monsterList.put(monsterType.DEMON,new Monster(monsterType.DEMON, getLevel() + 10));
	}
	public HashMap<weaponType, weapons> getWeaponList() {
		return weaponList;
	}
	public HashMap<monsterType, Monster> getMonsterList() {
		
		return monsterList;
		
	}
	public void setCurrency(int x) {
		Currency.setGold(x);
	}
	public int getCurrency() {
		return Currency.getGold();
	}
	public void loseHP(int dmg) {
		health.takeDamage(dmg);
	}
	public void setHP(int x) {
		health.setHp(x);
	}
	public int getHP() {
		return health.getHp();
	}
}
