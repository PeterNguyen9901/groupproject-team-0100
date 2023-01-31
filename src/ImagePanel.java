import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

class ImagePanel extends JPanel {

  private Image img;
  private static Random random = new Random();
  
  public ImagePanel(String img) {
	    this(new ImageIcon(img).getImage());
	    
	    }

  public ImagePanel(String img, Character player, Monster currentMonster, JLabel statusLabel, JLabel levelsGold) {
    this(new ImageIcon(img).getImage());
    
    addMouseListener(new MouseAdapter() { //listener for when user clicks onto the background so we can use that to deal damage to monster

        @Override
        public void mousePressed(MouseEvent e) {
        	currentMonster.loseHP(player.getLevel());
        	String mHpStr = "<html>Monster Health: ";
    		String cHpStr = "<br/>Character Health: ";
    		String MonsterDialogue = "<br/>" ;
    		String Message = GetCharacterDialogue();
    		
    		String text = mHpStr + currentMonster.getHP() + cHpStr + player.getHP() + MonsterDialogue + Message; //
    		statusLabel.setText(text);
            System.out.println("clicked");
            if(currentMonster.getHP()<=0) {
            	text = mHpStr + 0 + cHpStr + player.getHP(); 
        		statusLabel.setText(text);
        		player.addLevel(1);
        		currentMonster.addLevel(1);
        		player.setCurrency(player.getCurrency()+currentMonster.getReward());
        		String goldStr = "<html>Gold: ";
        		String levelStr = "<br/>Level: ";
        		
        		String FullText = goldStr + player.getCurrency() + levelStr + player.getLevel();
        		levelsGold.setText(FullText);
        		text = mHpStr + currentMonster.getHP() + cHpStr + player.getHP(); 
        	
            }
        }
    });
    
  }

  public ImagePanel(Image img) {
    this.img = img;
    setLayout(null);
  }
  public String GetCharacterDialogue() {
		List<String> lines = new ArrayList<>();
		lines.add("Ouch");
		lines.add("I am Hit!");
		lines.add("Bang!");
		int index = random.nextInt(lines.size());
		return lines.get(index);
		
		
	}
  
  //scales image to window size
  public void paintComponent(Graphics g) {
	super.paintComponent(g);
	Dimension d = getSize();
    g.drawImage(img, 0, 0, d.width, d.height, null);
  }

}