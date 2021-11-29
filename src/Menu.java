import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.*;
import javax.swing.border.Border;
import java.util.Timer;
public class Menu {
	JFrame frame = new JFrame("Click Click Go");
	private JPanel deck = new JPanel();
	private JPanel mainPanel = new JPanel();
	private JPanel shopPanel = new JPanel();
	private JPanel startPanel = new JPanel();
	private JPanel fightPanel = new JPanel();
	private JPanel statsPanel = new JPanel();
	CardLayout LAYOUT = new CardLayout();
	private Border blackLine = BorderFactory.createLineBorder(Color.black);
	

	Character player = new Character();
	Level GameLevel = new Level();
	HP playerHp = new HP();
	//Monster monsterHp = new Monster();
	
	
	public Menu() {
		deck.setLayout(LAYOUT);
		
		start(startPanel);
		MainMenu(mainPanel);
		shop(shopPanel);
		fight(fightPanel);
		stats(statsPanel);
		
		LAYOUT.show(deck, "start");
		frame.add(deck);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500,500);
        frame.setVisible(true);
	}
	public void MainMenu(Container pane) {
		ImagePanel background = new ImagePanel("background1.jpg");
		background.setLayout(new BorderLayout());
		pane.setLayout(new BorderLayout()); //make pane border layout
		
		
		int gold = player.getCurrency(); //will be used to create JLabel to show gold
		int level = GameLevel.getLevel();
		
		
		ImageIcon characterPicture = new ImageIcon("Gifcharacter.gif");
		JLabel character = new JLabel(characterPicture);
		character.setOpaque(false);
		character.setMaximumSize(new Dimension(60,60));
		character.setPreferredSize(new Dimension(60,60));
		character.setMinimumSize(new Dimension(60,60));
		background.add(character);
		pane.add(background);
		
		
		
		
		JPanel BottomButtons = new JPanel(); //JPanel to hold buttons that will be on bottom of the screen
		JPanel TopButtons = new JPanel();
		//JPanel MiddleButtons = new JPanel();
		
		
		BottomButtons.setLayout(new GridLayout(1,3,1,1)); //makes JPanel a grid that is 1 by 3 and has a horizontal and vertical gap of 1
		
		
		//creates label
		JLabel goldAndLevel = new JLabel();
		String gold1 = String.valueOf(gold);
		String level1 = String.valueOf(level);
		
		String goldStr = "<html>Gold: ";
		String levelStr = "<br/>Level: ";
		String FullText = goldStr + gold1 + levelStr + level1;
		goldAndLevel.setText(FullText);
		goldAndLevel.setBorder(blackLine);
		
		//creates buttons
		JButton MainShopButton = new JButton("Shop");
		MainShopButton.setBorder(blackLine);
		JButton MainFightButton = new JButton("Fight");
		MainFightButton.setBorder(blackLine);
		JButton MainStatsButton = new JButton("Stats");
		MainStatsButton.setBorder(blackLine);
		JButton MainQuitButton = new JButton("<html><font color=red size=4><b>Quit</b></html>");
		MainQuitButton.setBorder(blackLine);
		
		//add buttons to BottomButtons Panel
		BottomButtons.add(MainShopButton);
		BottomButtons.add(MainFightButton);
		BottomButtons.add(MainStatsButton);
		
		TopButtons.add(MainQuitButton);
		TopButtons.add(goldAndLevel);
		//TopButtons.add(character);
		
		//MiddleButtons.add(character);
		
		//Add JPanel to the bottom of pane 
		pane.add(BottomButtons, BorderLayout.PAGE_END);
		pane.add(TopButtons, BorderLayout.PAGE_START);
		//pane.add(MiddleButtons, BorderLayout.CENTER);
		
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
		MainQuitButton.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e) {
				LAYOUT.previous(deck);
				 }
			});

		
		deck.add(pane, "main");
	}
	public void shop(Container pane) {
		JLabel goldLabel;
		JButton ShopQuit = new JButton("<html><font color=red size=4><b>Quit</b></html>");
		JButton ShopFightButton = new JButton("Fight");
		JButton ShopStatsButton = new JButton("Stats");
		JButton ShopMainButton = new JButton("Main");
		pane.add(ShopQuit, BorderLayout.NORTH); 
		//pane.add(new Button("Buy")); I think we don't need a buy button and instead we can have button with pictures of weapon 
		//and when clicked on, it will buy the weapon
		pane.add(ShopMainButton);
		pane.add(ShopFightButton);
		pane.add(ShopStatsButton);
		ShopQuit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) { //go back to start menu
				  LAYOUT.show(deck, "start");
				 }
			});

		ShopMainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LAYOUT.show(deck, "main");
			}
		});
		
		ShopStatsButton.addActionListener(new ActionListener() { // go to stats menu
			@Override 
			public void actionPerformed(ActionEvent e) {
				LAYOUT.show(deck, "stats");;
			}
		});
		
		ShopFightButton.addActionListener(new ActionListener() { // go to fight menu
			@Override 
			public void actionPerformed(ActionEvent e) {
				LAYOUT.show(deck, "fight");;
			}
		});
		
		Border goldAndLevel = BorderFactory.createLineBorder(Color.orange);
		goldLabel = new JLabel(); 
		Gold g = new Gold();
		int goldX = g.getGold();
		Level l = new Level();
		int levelX = l.getLevel();
		String goldAmount = String.valueOf(goldX);
		String theLevel = String.valueOf(levelX);
		String gold = "<html>Gold: ";
		String level = "<br/>Level: ";
		String FullText = gold + goldAmount + level + theLevel;
		
		goldLabel.setText(FullText); 
		goldLabel.setBorder(goldAndLevel);
		pane.add(goldLabel);
		 

		// JPanel that will hold all of the buy weapons buttons 
		JPanel buyButtons = new JPanel();
		buyButtons.setLayout(new GridLayout(1,3,1,1));
	
		// buy button for axe
		ImageIcon axe = new ImageIcon("wip_axe.jpg");
		JButton axeButton = new JButton(axe);
		buyButtons.add(axeButton); // add axeButton to buyButtons panel 
				
		// buy button for bow
		ImageIcon bow = new ImageIcon("wip_bow.jpg");
		JButton bowButton = new JButton(bow);
		buyButtons.add(bowButton); // add bowButton to buyButtons panel

		// buy button for dagger
		ImageIcon dagger = new ImageIcon("wip_dagger.jpg");
		JButton daggerButton = new JButton(dagger);
		buyButtons.add(daggerButton); // add daggerButton to buyButtons panel		
		
		// buy button for spear 
		ImageIcon spear = new ImageIcon("wip_spear.jpg");
		JButton spearButton = new JButton(spear);
		buyButtons.add(spearButton);	// add spearButton to buyButtons panel
		
		// buy button for sword
		ImageIcon sword = new ImageIcon("wip_sword.jpg");
		JButton swordButton = new JButton(sword);
		buyButtons.add(swordButton); 	// add swordButton to buyButtons panel
		
		// adds buyButtons to end of pane 
		pane.add(buyButtons, BorderLayout.PAGE_END); 
				
		//buy button for health
		JButton healthButton = new JButton("Upgrade");
		pane.add(healthButton);
		
		deck.add(pane,"shop");
	}
	
	
	public void fight(Container pane){
		Timer timer = new Timer(); //Created start of timer
		JButton FightMainButton = new JButton("Main");
		pane.add(FightMainButton, BorderLayout.NORTH); 

		JPanel TopButtons = new JPanel();
		
		JButton fightQuit = new JButton("<html><font color=red size=4><b>Quit</b></html>");

		fightQuit.setBorder(blackLine);
		
		
		
		
		
		JLabel enemyHp = new JLabel();
		JLabel playerHp = new JLabel();
		JLabel goldandLevel = new JLabel();
		
		
		TopButtons.add(fightQuit);
		TopButtons.add(enemyHp);
		TopButtons.add(playerHp);
		TopButtons.add(goldandLevel);
		
		pane.add(TopButtons);
		
		deck.add(pane, "fight");
		
		//Creates layout of all buttons in fight menu
		JPanel fightButtons = new JPanel();
		fightButtons.setLayout(new GridLayout(1,3,1,1));
		
		//Quit Button, going back to start menu
		fightQuit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) { //go back to start menu
				  LAYOUT.show(deck, "start");
				 }
			});

		FightMainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LAYOUT.show(deck, "main");
			}
		});
		
		deck.add(pane, "fight");
	}
	
	public void stats(Container pane) {
		pane.setLayout(new BorderLayout());
		
		JPanel BottomButtons = new JPanel();
		BottomButtons.setLayout(new GridLayout(1,3,1,1));
		
		JButton statsQuit = new JButton("<html><font color=red size=4><b>Quit</b></html>");
		statsQuit.setBorder(blackLine);
		BottomButtons.add(statsQuit);

		statsQuit.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) { //goes back to start menu when QUIT is clicked in stats menu 
				LAYOUT.show(deck, "start");
			}
		});
		
		JButton statsShopButton = new JButton("Shop");
		statsShopButton.setBorder(blackLine);
		BottomButtons.add(statsShopButton);
		
		JButton statsFightButton = new JButton("Fight");
		statsFightButton.setBorder(blackLine);
		BottomButtons.add(statsFightButton);
		
		pane.add(BottomButtons, BorderLayout.PAGE_END);
		
		statsShopButton.addActionListener(new ActionListener() { // goes to shop menu if Shop is clicked in stats menu 
			@Override
			public void actionPerformed(ActionEvent e) {
				LAYOUT.show(deck, "shop");
			}
		});
		
		statsFightButton.addActionListener(new ActionListener() { // goes to fight menu if Fight is clicked in stats menu 
			@Override
			public void actionPerformed(ActionEvent e) {
				LAYOUT.show(deck, "fight"); 
			}
		});
		
		// holds all the labels 
		JPanel labels = new JPanel(new GridLayout(4,1,10,10));
		//labels.setLayout(new GridLayout(4,1,10,10));
		
		// damage label 
		JLabel damage = new JLabel();
		String damageStr = "<html><font size=8>Damage:</html>";
		damage.setText(damageStr);
		damage.setBorder(blackLine);
		labels.add(damage); 
		 
		
		// kills label 
		JLabel kills = new JLabel();
		String killStr = "<html><font size=8>Kills:</font></html>";
		kills.setText(killStr);
		kills.setBorder(blackLine);
		labels.add(kills);
		
		// deaths label 
		JLabel deaths = new JLabel();
		String deathStr = "<html><font size=8>Deaths:";
		deaths.setText(deathStr);
		deaths.setBorder(blackLine);
		labels.add(deaths);
		
		// level label 
		JLabel level = new JLabel();
		String levelStr = "<html><font size=8>Level:";
		level.setText(levelStr);
		level.setBorder(blackLine);
		labels.add(level); 
		
		// adds all the labels to pane
		pane.add(labels, BorderLayout.PAGE_START); 
		
		deck.add(pane, "stats"); 
	}

	
	public void start(Container pane) {
		ImagePanel background = new ImagePanel("castle1.jpg");
		pane.setLayout(new BorderLayout()); 
		pane.add(background);
		
		JPanel BottomButtons = new JPanel(); 
		BottomButtons.setLayout(new GridLayout(1,2,1,1)); 
		Border blackLine = BorderFactory.createLineBorder(Color.black);
		JButton startButton = new JButton("Press Here To Start a Adventure!");
		JButton startQuit= new JButton("<html><font color=red size=4><b>Quit</b></html>");
		startQuit.setBorder(blackLine);
		startButton.setBorder(blackLine);
		BottomButtons.add(startButton);
		BottomButtons.add(startQuit);
		
		
		pane.add(BottomButtons, BorderLayout.PAGE_END);
		startQuit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) {
				  System.exit(0);
				 }
			});

		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LAYOUT.show(deck, "main");
			}
		});
		deck.add(pane, "start");
		
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
