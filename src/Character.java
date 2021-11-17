import java.util.ArrayList;
//test
public class Character {
	private int monsterKilled;
	private Gold Currency;
	ArrayList<weapons> weaponList;
	ArrayList<Monster> monsterList;
	public int getmonsterKilled() {
		return monsterKilled;
	}


	public void setMonsterKilled(int monsterKilled) {
		this.monsterKilled = monsterKilled;
	}
	
	public void initWeaponsOwned() {
		//fill
		//weaponList.add(null)
	}
	public void initMonsterList() {
		monsterList.add(new Monster(monsterType.SLIME));
		monsterList.add(new Monster(monsterType.BANDIT));
		monsterList.add(new Monster(monsterType.GOBLIN));
		monsterList.add(new Monster(monsterType.WEREWOLF));
		monsterList.add(new Monster(monsterType.KNIGHT));
		monsterList.add(new Monster(monsterType.DEMON));
	}
	public ArrayList<weapons> getWeaponList() {
		return weaponList;
	}
	public ArrayList<Monster> getMonsterList() {
		
		return monsterList;
		
	}
	public int getCurrency() {
		return Currency.getGold();
	}
}
