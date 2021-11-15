import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

class ImagePanel extends JPanel {

  private Image img;

  public ImagePanel(String img) {
    this(new ImageIcon(img).getImage());
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