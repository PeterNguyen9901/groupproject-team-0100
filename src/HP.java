
class HP {
	private int HP;
	private int characterDeath;
	
	
	public int getHp() {
		return HP;
	}


	public void setHp(int HP) {
		this.HP = HP;
	}
	
	public int getCharacterDeath() {
		return characterDeath;
	}


	public void setCharacterDeath(int characterDeath) {
		this.characterDeath = characterDeath;
	}
	
	public double takeDamage(int dmg) {
		HP = HP - dmg;
		if (HP==0) {
			characterDeath++;
			//return to start of game
		}
		return dmg;
	}
}
