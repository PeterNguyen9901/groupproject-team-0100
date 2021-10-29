

public enum weaponType {
	SWORD, AXE, BOW, SPEAR, DAGGER;
	
	public String toString() {
		switch(this) {
		case SWORD: return "sword";
		case AXE: return "axe";
		case BOW: return "bow";
		case SPEAR: return "spear";
		case DAGGER: return "dagger";
		
		}
		return "N/A";
	}
	
	

}