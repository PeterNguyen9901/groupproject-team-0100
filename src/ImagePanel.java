import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ImagePanel extends JPanel {

  private Image img;
  
  public ImagePanel(String img) {
	    this(new ImageIcon(img).getImage());
	    }

  public ImagePanel(String img, Character player, Monster currentMonster, JLabel statusLabel) {
    this(new ImageIcon(img).getImage());
    
    addMouseListener(new MouseAdapter() { //listener for when user clicks onto the background so we can use that to deal damage to monster

        @Override
        public void mousePressed(MouseEvent e) {
        	currentMonster.loseHP(player.getLevel());
        	String mHpStr = "<html>Monster Health: ";
    		String cHpStr = "<br/>Character Health: ";
    		//String text = mHpStr + currentMonster.getHP().getHp() + cHpStr + player.getHP();
    		String text = mHpStr + currentMonster.getHP() + cHpStr + player.getHP(); // 
    		statusLabel.setText(text);
    		//MonCharHp.setBorder(blackLine);
            System.out.println("clicked");
        }
    });
    
  }

  public ImagePanel(Image img) {
    this.img = img;
    setLayout(null);
  }
  
  //scales image to window size
  public void paintComponent(Graphics g) {
	super.paintComponent(g);
	Dimension d = getSize();
    g.drawImage(img, 0, 0, d.width, d.height, null);
  }

}