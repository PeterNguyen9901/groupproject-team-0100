import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

//class for GUI, but code within as of now is just an example
public class MainMenu implements ItemListener{
	private static JPanel cards;
	public JLabel label;
	//private static JPanel mainMenu;
	public void addComponentToPane(Container pane) {
		JPanel main = new JPanel();
		
		Border blackLine = BorderFactory.createLineBorder(Color.black);
		label = new JLabel();
		label.setText("<html>Gold: <br/>Level: </html>");
		
		label.setBorder(blackLine);
		main.add(label);

		
		
		main.add(new Button("Shop"));
		main.add(new Button("Fight"));
		main.add(new Button("Stats"));
		cards = new JPanel(new CardLayout(50,50));
		cards.add(main);
		pane.add(cards, BorderLayout.PAGE_END);
		
		
		JFrame newFrame = new JFrame("Shop");  
        MainMenu newGame = new MainMenu(); 
        newGame.shop(newFrame.getContentPane());  
        newFrame.pack(); 
        newFrame.setVisible(true);  

	}
	private static void ShowGUI() {
		JFrame frame = new JFrame("Click Click Go");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainMenu game = new MainMenu();
        game.addComponentToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
	}
	
	
	public void shop(Container pane) {
		JPanel shop = new JPanel();
		JLabel goldLabel, levelLabel;
		cards = new JPanel(new CardLayout());
		shop.add(new Button("Quit")); 
		shop.add(new Button("Buy"));
		
		Border goldAndLevel = BorderFactory.createLineBorder(Color.black);
		goldLabel = new JLabel(); 
		goldLabel.setText("<html>Gold:   <br/>Level:   </html>"); 
		goldLabel.setBorder(goldAndLevel);
		shop.add(goldLabel);
		 
		cards = new JPanel(new CardLayout());
		cards.add(shop);
		
		pane.add(cards, BorderLayout.CENTER); 
	}

	
	public static void main(String[] args) {
		//from example on documentation, but not sure if we need it
		/*try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        //Turn off metal's use of bold fonts 
        UIManager.put("swing.boldMetal", Boolean.FALSE);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ShowGUI();
            }
        });*/
		ShowGUI();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)e.getItem());
	}
}
