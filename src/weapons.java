
public class weapons {
	
	double damage;
	int level;
	private weaponType weaponType; 
	private monsterType monsterType;
	public weapons(weaponType type) {
		damage = 0;
		level = 0;
		weaponType = type;
	}
	/*
	public enum weaponType {
		Sword, Axe, Bow, Spear, Dagger
	}
	*/
	
	public double getDamage(monsterType type) { // Built constructor for weapons damage
		if (weaponType ==  weaponType.DAGGER) {
			if (monsterType == monsterType.SLIME) {
				
			}
			return damage;
		}
		else if (weaponType ==  weaponType.SWORD) {
			if (monsterType == monsterType.BANDIT) {
				
			}
			return damage;
		}
		else if (weaponType == weaponType.AXE) {
			if (monsterType == monsterType.GOBLIN) {
				
			}
			return damage;
		}
		else if (weaponType == weaponType.BOW) {
			if (monsterType == monsterType.WEREWOLF) {
				
			}
			return damage;
		}
		else if (weaponType == weaponType.SPEAR) {
			if (monsterType == monsterType.KNIGHT) {
				
			}
			return damage;
		}
		return damage;
		
	}
	
	
	
	
	public int getLevel() {
		return level; 
	}
	
	public int incrementLevel(int n) {
		
		return n += level;
		
	}
	
	public weaponType getType() {
		/*
		switch(weapon) {
		case Sword:
			return weaponType.Sword; 
			
		case Axe:
			return weaponType.Axe;
			
		case Bow:
			return weaponType.Bow;
			
		case Spear:
			return weaponType.Spear;
			
		case Dagger:
			return weaponType.Dagger;
		}
		*/
		return weaponType; 
	}
	
}
