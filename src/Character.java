
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
		weaponList = new HashMap<weaponType, weapons>();
		monsterList = new HashMap<monsterType, Monster>();
		initWeaponsList();
		initMonsterList();
		currLevel = new Level();
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
		monsterList.put(monsterType.SLIME,new Monster(monsterType.SLIME));
		monsterList.put(monsterType.GOBLIN,new Monster(monsterType.GOBLIN));
		monsterList.put(monsterType.WEREWOLF,new Monster(monsterType.WEREWOLF));
		monsterList.put(monsterType.BANDIT,new Monster(monsterType.BANDIT));
		monsterList.put(monsterType.KNIGHT,new Monster(monsterType.KNIGHT));
		monsterList.put(monsterType.DEMON,new Monster(monsterType.DEMON));
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
}
