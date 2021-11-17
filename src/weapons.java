
public class weapons {
	
	double damage;
	int level;
	private weaponType weapon; 
	
	/*
	public enum weaponType {
		Sword, Axe, Bow, Spear, Dagger
	}
	*/
	
	public double getDamage() {
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
		return weapon; 
	}
	
}
