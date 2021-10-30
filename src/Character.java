import java.util.ArrayList;
//test
public class Character {
	private int HP;
	private int totalDamage;
	private int gold;
	private int level;
	private int characterDeath;
	private int monsterKilled;
	ArrayList<weaponType> weaponList;
	ArrayList<monsterType> monsterList;

	public int getHp() {
		return HP;
	}


	public void setHp(int HP) {
		this.HP = HP;
	}
	public int gettotalDamage() {
		return totalDamage;
	}


	public void setTotalDamage(int totalDamage) {
		this.totalDamage = totalDamage;
	}


	public int getgold() {
		return gold;
	}


	public void setgold(int gold) {
		this.gold = gold;
	}


	public int getlevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public int getCharacterDeath() {
		return characterDeath;
	}


	public void setCharacterDeath(int characterDeath) {
		this.characterDeath = characterDeath;
	}


	public int getmonsterKilled() {
		return monsterKilled;
	}


	public void setMonsterKilled(int monsterKilled) {
		this.monsterKilled = monsterKilled;
	}
	
	public void setWeaponsOwned() {
		//Fill
	}
	public void setMonsterList() {
		//Fill
	}
	public weaponType getWeaponList() {
		
		//Fill
		return weaponType.SWORD;
	}
	public monsterType getMonsterList() {
		
		
		//Fill
		return monsterType.SLIME;
		
	}

}
