
public enum monsterType {
	SLIME, GOBLIN, WEREWOLF, BANDI, KNIGHTT, DEMON;
	
	public String toString() {
		switch(this) {
			case SLIME: return "slime";
			case GOBLIN: return "goblin";
			case WEREWOLF: return "werewolf";
			case BANDI: return "bandit";
			case KNIGHTT: return "knight";
			case DEMON: return "demon";
		}
		return "n/a";
	}
}
