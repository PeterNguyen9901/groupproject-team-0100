import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

class HP {
	
	private int Health;
	private int characterDeath;
	ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            //...Perform a task...

            System.out.println("Reading SMTP Info.");
            Health = Health -2;
            
        }
    };
    Timer timer = new Timer(5000 ,taskPerformer);
	
	public HP() {//constructor
		Health = 20;
		characterDeath = 0;
	}
	public int getHp() {//getter for health
		return Health;
	}


	public void setHp(int HP) {//setter for health
		Health = HP;
	}
	
	public int getCharacterDeath() {//getter for amount of death
		return characterDeath;
	}


	public void setCharacterDeath(int characterDeath) {//setter for amount of death
		this.characterDeath = characterDeath;
	}
	
	public double takeDamage(int dmg) {//damage
		Health -= dmg;
		if (Health <= 0) {
			characterDeath++;
			//return to start of game
		}
		return dmg;
	}
	
	public void start_t() {
		timer.setRepeats(true);
        timer.start();
        
	}
	
	
	public void end_t() {
		timer.restart();
	
	}
}
