import javax.swing.*;  

//class for GUI, but code within as of now is just an example
public class MainMenu {
	private static JFrame screen;
	public static void main(String[] args) {
		screen = new JFrame();
		JButton b = new JButton("Shop");
		b.setBounds(200,200,100,100);
		screen.add(b);
		screen.setSize(800,800);
		screen.setLayout(null);
		screen.setVisible(true);
	}
}
