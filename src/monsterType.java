
public enum monsterType {
	SLIME, GOBLIN, WEREWOLF, BANDIT, KNIGHT, DEMON;
	
	public String toString() {
		switch(this) {
			case SLIME: return "slime";
			case GOBLIN: return "goblin";
			case WEREWOLF: return "werewolf";
			case BANDIT: return "bandit";
			case KNIGHT: return "knight";
			case DEMON: return "demon";
		}
		return "n/a";
	}
}
