import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.Timer;

//import java.awt.event.*;
import javax.swing.border.Border;

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
	
	Monster monsterHp = new Monster(null, 0);
	Damage playerDamage = new Damage(); //
	
	//Timer code for monster damage every five seconds
	ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            //simulation of monster dealing damage over time
        	if(player.getHP()>0) {
        		System.out.println("Gah! HIT!.");
        		player.loseHP(1+(player.getLevel()*2));
        		if(player.getHP() < 0) {
        			player.setHP(0);
        		}
        		System.out.println("HP: " + player.getHP());
        	}
        		else {
        			System.out.println("HP: DEAD!");
        		}
            
        }
    };
    Timer timer = new Timer(5000 ,taskPerformer);
    int tmp_HP;
    int perm_HP = 20;
   
	
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
        frame.setSize(800,800);
        frame.setVisible(true);
	}
	public void resettimer() {
		timer.stop();
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
				timer.restart();
				tmp_HP = player.getHP();
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
		pane.setLayout(new BorderLayout());
		JPanel BottomButtons = new JPanel(); //JPanel to hold buttons that will be on bottom of the screen
		BottomButtons.setLayout(new GridLayout(1,4,1,1)); //makes JPanel a grid that is 1 by 3 and has a horizontal and vertical gap of 1
		JLabel goldLabel;
		JButton ShopQuit = new JButton("<html><font color=red size=4><b>Quit</b></html>");
		JButton ShopFightButton = new JButton("Fight");
		JButton ShopStatsButton = new JButton("Stats");
		JButton ShopMainButton = new JButton("Main");
		//pane.add(ShopQuit, BorderLayout.NORTH); 
		//pane.add(new Button("Buy")); I think we don't need a buy button and instead we can have button with pictures of weapon 
		//and when clicked on, it will buy the weapon
		//pane.add(ShopMainButton);
		//pane.add(ShopFightButton);
		//pane.add(ShopStatsButton);
		BottomButtons.add(ShopQuit);
		BottomButtons.add(ShopFightButton);
		BottomButtons.add(ShopMainButton);
		BottomButtons.add(ShopStatsButton);
		
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
		pane.add(goldLabel, BorderLayout.PAGE_START);
		 

		// JPanel that will hold all of the buy weapons buttons 
		JPanel buyButtons = new JPanel();
		buyButtons.setLayout(new GridLayout(1,5,1,1));
	
		// buy button for axe
		ImageIcon axe = new ImageIcon("w_axe.png");
		JButton axeButton = new JButton(axe);
		buyButtons.add(axeButton); // add axeButton to buyButtons panel 
		axeButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) { //go back to start menu
				  player.manipWeaponList(weaponType.AXE);
				  System.out.println("axe lvl: " + player.getWeaponList().get(weaponType.AXE).getLevel());			}
		});
		// buy button for bow
		ImageIcon bow = new ImageIcon("w_bow.png");
		JButton bowButton = new JButton(bow);
		buyButtons.add(bowButton); // add bowButton to buyButtons panel
		
		bowButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) { //go back to start menu
				  player.manipWeaponList(weaponType.BOW);
				  System.out.println("bow lvl: " + player.getWeaponList().get(weaponType.BOW).getLevel());			}
		});
		
		// buy button for dagger
		ImageIcon dagger = new ImageIcon("w_dagger.png");
		JButton daggerButton = new JButton(dagger);
		buyButtons.add(daggerButton); // add daggerButton to buyButtons panel		
		
		daggerButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) { //go back to start menu
				  player.manipWeaponList(weaponType.DAGGER);
				  System.out.println("dagger lvl: " + player.getWeaponList().get(weaponType.DAGGER).getLevel());			}
		});
		
		// buy button for spear 
		ImageIcon spear = new ImageIcon("w_spear.png");
		JButton spearButton = new JButton(spear);
		buyButtons.add(spearButton);	// add spearButton to buyButtons panel
		
		spearButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) { //go back to start menu
				  player.manipWeaponList(weaponType.SPEAR);
				  System.out.println("spear lvl: " + player.getWeaponList().get(weaponType.SPEAR).getLevel());			}
		});
		
		// buy button for sword
		ImageIcon sword = new ImageIcon("w_sword.png");
		JButton swordButton = new JButton(sword);
		buyButtons.add(swordButton); 	// add swordButton to buyButtons panel
		
		swordButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) { //go back to start menu
				  player.manipWeaponList(weaponType.SWORD);
				  System.out.println("sword lvl: " + player.getWeaponList().get(weaponType.SWORD).getLevel());
			}
		});
		
		// adds buyButtons to end of pane 
		pane.add(buyButtons); 
		pane.add(BottomButtons, BorderLayout.PAGE_END);
		//buy button for health
		JButton healthButton = new JButton("Upgrade Health");
		//pane.add(healthButton);
		buyButtons.add(healthButton);
		//button that increases player health by 20 each time
		healthButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) { //go back to start menu
				  player.setHP(player.getHP() + 20);
				  System.out.println(player.getHP());
				  perm_HP = perm_HP + 20;
				  
			}
		});
		
		deck.add(pane,"shop");
	}
	
	
	public void fight(Container pane){
		JLabel MonCharHp = new JLabel();
		MonCharHp.setBorder(blackLine);
		ImagePanel background = new ImagePanel("background 2.jpg", player, monsterHp, MonCharHp);
		
		background.setLayout(new BorderLayout());
		pane.setLayout(new BorderLayout()); 

		
		
		
		int gold = player.getCurrency(); //will be used to create JLabel to show gold
		int level = GameLevel.getLevel();
		//HP MonsterHp = monsterHp.getHP();
		int MonsterHp = monsterHp.getHP();// 
		int CharacterHp = player.getHP();

		JPanel TopButtons = new JPanel();
		TopButtons.setLayout(new GridLayout(1,4,1,1));
		
		JButton fightQuit = new JButton("<html><font color=red size=4><b>Quit</b></html>");
		

		fightQuit.setBorder(blackLine);
		

		ImageIcon slimePicture = new ImageIcon("slime.png");
		JLabel slime = new JLabel(slimePicture);
		slime.setOpaque(false);
		slime.setMaximumSize(new Dimension(60,60));
		slime.setPreferredSize(new Dimension(60,60));
		slime.setMinimumSize(new Dimension(60,60));
		background.add(slime);
		pane.add(background);
		
		JLabel start = new JLabel();

		//pane.add(start);
		
		JLabel goldAndLevel = new JLabel();
		String gold1 = String.valueOf(gold);
		String level1 = String.valueOf(level);
		
		String goldStr = "<html>Gold: ";
		String levelStr = "<br/>Level: ";
		if(monsterHp.getHP() <= 0) {
			gold++; // thought this would increase gold but i don't think so
		} 
		String FullText = goldStr + gold1 + levelStr + level1;
		goldAndLevel.setText(FullText);
		goldAndLevel.setBorder(blackLine);
		
		
		//String mHp = String.valueOf(MonsterHp.getHp());
		String mHp = String.valueOf(MonsterHp); //
		String cHp = String.valueOf(CharacterHp);
		
		String mHpStr = "<html>Monster Health: ";
		String cHpStr = "<br/>Character Health: ";
		String text = mHpStr + mHp + cHpStr + cHp;
		MonCharHp.setText(text);
		
		
		
	
		
		
		TopButtons.add(fightQuit);
		TopButtons.add(start);
		TopButtons.add(MonCharHp);
		TopButtons.add(goldAndLevel);
		
		pane.add(TopButtons, BorderLayout.PAGE_START);
		
		
		deck.add(pane, "fight");
		
		//Creates layout of all buttons in fight menu
		//JPanel fightButtons = new JPanel();
		//fightButtons.setLayout(new GridLayout(1,3,1,1));
		
		//Quit Button, going back to start menu
		fightQuit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) { //go back to start menu
				  LAYOUT.show(deck, "start");
				  timer.stop();
				  player.setHP(tmp_HP);
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
		
		JButton statsFightButton = new JButton("Main");
		statsFightButton.setBorder(blackLine);
		BottomButtons.add(statsFightButton);
		
		JButton statsShopButton = new JButton("Shop");
		statsShopButton.setBorder(blackLine);
		BottomButtons.add(statsShopButton);
		
		
		pane.add(BottomButtons, BorderLayout.PAGE_END);
		
		
		statsFightButton.addActionListener(new ActionListener() { // goes to fight menu if Fight is clicked in stats menu 
			@Override
			public void actionPerformed(ActionEvent e) {
				LAYOUT.show(deck, "main"); 
			}
		});
		
		statsShopButton.addActionListener(new ActionListener() { // goes to shop menu if Shop is clicked in stats menu 
			@Override
			public void actionPerformed(ActionEvent e) {
				LAYOUT.show(deck, "shop");
			}
		});
		
		
		// holds all the labels 
		JPanel labels = new JPanel(new GridLayout(4,1,10,10));
		//labels.setLayout(new GridLayout(4,1,10,10));
		
		// damage label 
		JLabel damage = new JLabel();
		String damageStr = "<html><font size=8>Damage:</html>";
		int numDamage = playerDamage.gettotalDamage(); // get players damage 
		String currDamage = String.valueOf(numDamage);  //
		damage.setText(damageStr + currDamage); // add the damage to label 
		damage.setBorder(blackLine);
		labels.add(damage); 
		 
		
		// kills label 
		JLabel kills = new JLabel();
		String killStr = "<html><font size=8>Kills:</font></html>";
		int monsterKilled = 0; //
		if(monsterHp.getHP() <= 0) {
			monsterKilled++;  //
		} 
		player.setMonsterKilled(monsterKilled); //
		int numKills = player.getmonsterKilled(); // get number of monsters killed
		String currKills = String.valueOf(numKills); // 
		String killText = killStr + currKills;
		kills.setText(killText); // add number of monsters killed to label
		kills.setBorder(blackLine);
		labels.add(kills);
		
		
		// deaths label 
		JLabel deaths = new JLabel();
		String deathStr = "<html><font size=8>Deaths:";
		int playerDeath = 0;
		if(player.getHP() <= 0) {
			playerDeath++; 
		}
		playerHp.setCharacterDeath(playerDeath);
		int numDeaths = playerHp.getCharacterDeath();
		String currDeaths = String.valueOf(numDeaths);
		String deathText = deathStr + currDeaths;
		deaths.setText(deathText);
		deaths.setBorder(blackLine);
		labels.add(deaths);
		
		
		// level label 
		JLabel level = new JLabel();
		String levelStr = "<html><font size=8>Level:";
		//Level newLevel = new Level(); //
		int levelX = GameLevel.getLevel(); //
		String currentLevel = String.valueOf(levelX); //
		String LevelText = levelStr + currentLevel; // displays current level
		level.setText(LevelText); // 
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
