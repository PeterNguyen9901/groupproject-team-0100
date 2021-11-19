
class HP {
	private int Health;
	private int characterDeath;
	
	public HP() {
		Health = 20;
	}
	public int getHp() {
		return Health;
	}


	public void setHp(int HP) {
		Health = HP;
	}
	
	public int getCharacterDeath() {
		return characterDeath;
	}


	public void setCharacterDeath(int characterDeath) {
		this.characterDeath = characterDeath;
	}
	
	public double takeDamage(int dmg) {
		Health -= dmg;
		if (Health==0) {
			characterDeath++;
			//return to start of game
		}
		return dmg;
	}
}
