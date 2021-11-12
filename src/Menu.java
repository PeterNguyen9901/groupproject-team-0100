import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.*;
import javax.swing.border.Border;

public class Menu {
	JFrame frame = new JFrame("Click Click Go");
	private JPanel deck = new JPanel();
	private JPanel mainPanel = new JPanel();
	private JPanel shopPanel = new JPanel();
	CardLayout LAYOUT = new CardLayout();

	public Menu() {
		deck.setLayout(LAYOUT);
		
		MainMenu(mainPanel);
		shop(shopPanel);
		LAYOUT.show(deck, "main");
		frame.add(deck);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
	}
	public void MainMenu(Container pane) {
		JButton MainShopButton = new JButton("Shop");
		JButton MainFightButton = new JButton("Fight");
		JButton MainStatsButton = new JButton("Stats");
		pane.add(MainShopButton);
		pane.add(MainFightButton);
		pane.add(MainStatsButton);
		
		//action listener for shop button
		MainShopButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				LAYOUT.show(deck, "shop");
			}
		});
		//action listener for fight button
		MainFightButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				LAYOUT.show(deck, "fight");
			}
		});
		//action listener for stats button
		MainStatsButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				LAYOUT.show(deck, "stats");
			}
		});
		
		deck.add(pane, "main");
	}
	public void shop(Container pane) {
		JLabel goldLabel, levelLabel;
		JButton ShopQuit = new JButton("Quit");
		JButton ShopFightButton = new JButton("Fight");
		JButton ShopStatsButton = new JButton("Stats");
		JButton ShopMainButton = new JButton("Main");
		pane.add(ShopQuit, BorderLayout.NORTH); 
		//pane.add(new Button("Buy")); I think we don't need a buy button and instead we can have button with pictures of weapon 
		//and when clicked on, it will buy the weapon
		pane.add(ShopMainButton);
		pane.add(ShopFightButton);
		pane.add(ShopStatsButton);
		ShopMainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LAYOUT.show(deck, "main");
			}
		});
		Border goldAndLevel = BorderFactory.createLineBorder(Color.black);
		goldLabel = new JLabel(); 
		goldLabel.setText("<html>Gold:   <br/>Level:   </html>"); 
		goldLabel.setBorder(goldAndLevel);
		pane.add(goldLabel);
		 
		deck.add(pane,"shop");
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
            public void run() {
                new Menu();
            }
        });
	}
}
