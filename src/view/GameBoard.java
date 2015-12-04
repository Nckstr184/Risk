package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.CardCollection;
import model.Continent;
import model.Player;
import model.GameLogic;
import model.Territory;

public class GameBoard extends JPanel {

	boolean reinforcementPhase;
	HashMap<JButton, JLabel> myMap;
	ArrayList<Continent> continents;
	ArrayList<Territory> territories;
	BufferedImage map, bottomDisplay, leftDisplay, rightDisplay;
	Player player1, player2, player3, player4, player5, player6, currPlayer;

	JPanel board, boardDisplay, boardInfo;

	JFrame temp;
	JTextField bottomField;

	int javaUnits, pythonUnits, cUnits, sqlUnits, rubyUnits, gitUnits, perlUnits;// number
																					// on
																					// the
																					// circLanguagee
																					// for
																					// language
	JButton javaLanguage, pythonLanguage, cLanguage, sqlLanguage, rubyLanguage, gitLanguage, perlLanguage;// circLanguagee
																											// button
																											// for
																											// language
	JLabel languageLabel1, languageLabel2, languageLabel3, languageLabel4, languageLabel5, languageLabel6,
			languageLabel7;// number for language
	JButton wilberWildcat, wilmaWildcat, richWildcat, millerWildcat, scoobyWildcat, mckaleWildcat, zonaWildcat;
	JLabel wildcatLabel1, wildcatLabel2, wildcatLabel3, wildcatLabel4, wildcatLabel5, wildcatLabel6, wildcatLabel7;
	int wilberUnits, wilmaUnits, richUnits, millerUnits, scoobyUnits, mckaleUnits, zonaUnits;

	JButton papajohnsPizza, dominosPizza, pizzahutPizza, blackjackPizza, hungryhowiesPizza, brooklynPizza,
			pizzaplanetPizza;
	JLabel pizzaLabel1, pizzaLabel2, pizzaLabel3, pizzaLabel4, pizzaLabel5, pizzaLabel6, pizzaLabel7;
	int pjUnits, domUnits, phUnits, bjUnits, hhUnits, bUnits, ppUnits;

	JButton rawrvilleDino, laieggesDino, dactilitoDino, dirtydanDino, blackbeardDino, monisaurusDino, toystoryDino;
	JLabel dinoLabel1, dinoLabel2, dinoLabel3, dinoLabel4, dinoLabel5, dinoLabel6, dinoLabel7;
	int rawrUnits, eggUnits, dacUnits, danUnits, bbUnits, moniUnits, tsUnits;

	JButton scraptopiaCresent, landofzachCresent, giantCresent, newlandofzachCresent, southscraptopiaCresent,
			bloobawlCresent, cresentcaptitalCresent;
	JLabel cresentLabel1, cresentLabel2, cresentLabel3, cresentLabel4, cresentLabel5, cresentLabel6, cresentLabel7;
	int scrapUnits, zachUnits, giantUnits, newzachUnits, southUnits, blooUnits, capUnits;

	JButton apolloSun, raSun, heliosSun, intiSun, horusSun, tonatiuhSun, amunSun;
	JLabel sunLabel1, sunLabel2, sunLabel3, sunLabel4, sunLabel5, sunLabel6, sunLabel7;
	int apolloUnits, raUnits, heliosUnits, intiUnits, horusUnits, tonatiuhUnits, amunUnits;

	ImageIcon gray, red, blue, purple, orange, yellow, green;
	JLabel picLanguageabel;
	StartWindow startWindow;

	OpenNewMenu newgame1;

	GameLogic newGame;

	JLabel playerTag, playerTag2, playerTag3, playerTag4, playerTag5, playerTag6, playerCount, playerCount2,
			playerCount3, playerCount4, playerCount5, playerCount6, turnMarker,gameStatus;

	private FileInputStream fis;
	private ObjectInputStream input;

	public GameBoard() {

		try {
			fis = new FileInputStream("saved");
			input = new ObjectInputStream(fis);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reinforcementPhase = true;

		newgame1 = new OpenNewMenu();
		while (newgame1.isDisplayable()) {
			System.out.print("");

			if (!newgame1.isDisplayable() && newgame1.isClicked() == false) {
				System.out.print("");

				startWindow = new StartWindow();
				// current = new Player();
				while (startWindow.isDisplayable()) {

					System.out.print("");


							if (!startWindow.isDisplayable()) {
								System.out.print("");
								this.setSize(1300, 750);
								this.setLocation(0, -5);

								try {
									map = ImageIO.read(new File("./Pictures/map1.png"));

									bottomDisplay = ImageIO.read(new File("./Pictures/bottomgui.png"));
									leftDisplay = ImageIO.read(new File("./Pictures/gui2n.png"));
									rightDisplay = ImageIO.read(new File("./Pictures/gui2n.png"));

									JLabel picLabel = new JLabel(new ImageIcon(map));
									JLabel bottomLabel = new JLabel(new ImageIcon(bottomDisplay));
									JLabel leftLabel = new JLabel(new ImageIcon(leftDisplay));
									JLabel rightLabel = new JLabel(new ImageIcon(rightDisplay));
									System.out.println("NUMBER OF PLAYERS: " + startWindow.getNumberOfPlayer());

									this.setLayout(new BorderLayout());
									startNewGame();
									playerTags();
									addButtons();
									currPlayer = newGame.getPlayerAt(0);

									add(picLabel, BorderLayout.CENTER);
									add(leftLabel, BorderLayout.WEST);
									add(rightLabel, BorderLayout.EAST);

									add(bottomLabel, BorderLayout.SOUTH);

								} catch (IOException e) {
									System.out.println("ERROR with map");
									e.printStackTrace();
								}

							}
						}
					}
					if (newgame1.isClicked() == true) {
						try {
							

							map = ImageIO.read(new File("./Pictures/map1.png"));

							bottomDisplay = ImageIO.read(new File("./Pictures/bottomgui.png"));
							leftDisplay = ImageIO.read(new File("./Pictures/gui2n.png"));
							rightDisplay = ImageIO.read(new File("./Pictures/gui2n.png"));

							JLabel picLabel = new JLabel(new ImageIcon(map));
							JLabel bottomLabel = new JLabel(new ImageIcon(bottomDisplay));
							JLabel leftLabel = new JLabel(new ImageIcon(leftDisplay));
							JLabel rightLabel = new JLabel(new ImageIcon(rightDisplay));
						//	System.out.println("NUMBER OF PLAYERS: " + startWindow.getNumberOfPlayer());

							this.setLayout(new BorderLayout());

							add(picLabel, BorderLayout.CENTER);
							add(leftLabel, BorderLayout.WEST);
							add(rightLabel, BorderLayout.EAST);

							add(bottomLabel, BorderLayout.SOUTH);
							newGame = (GameLogic) input.readObject();
							input.close();

						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}

			}

		

	

	private void playerTags() {
		int numberOfPlayers;

		numberOfPlayers = startWindow.getNumberOfPlayer();
		Font plyrTagFont = new Font("Verdana", Font.BOLD, 18);
		Font plyrCountFont = new Font("Verdana", Font.BOLD, 9);
		Font gameStatusFont = new Font("Verdana", Font.BOLD, 22);
		int count = 1;
		turnMarker = new JLabel();
		gameStatus = new JLabel();
		turnMarker.setText("IT'S YOUR TURN!!!");
		turnMarker.setForeground(Color.white);
		turnMarker.setFont(plyrCountFont);
		turnMarker.setSize(100,20);
		turnMarker.setLocation(150,590);
		gameStatus.setText("Assign Defense");
		gameStatus.setForeground(Color.white);
		gameStatus.setBackground(Color.BLACK);
		gameStatus.setFont(gameStatusFont);
		gameStatus.setSize(250,50);
		gameStatus.setLocation(1090,40);
		
		
		add(gameStatus)
;		add(turnMarker);

		if (numberOfPlayers == 6) {
			playerTag = new JLabel(startWindow.getPlayerName(0));
			playerTag.setSize(150, 40);
			playerTag.setLocation(170, 600);
			playerTag.setFont(plyrTagFont);
			playerTag.setForeground(startWindow.getPlayerColor(0));
			add(playerTag);
			playerCount = new JLabel("You have " + newGame.getPlayerAt(0).getNumOfArmies() + " units left to place!");
			playerCount.setSize(200, 40);
			playerCount.setLocation(130, 620);
			playerCount.setFont(plyrCountFont);
			playerCount.setForeground(startWindow.getPlayerColor(0));
			add(playerCount);
			playerTag2 = new JLabel(startWindow.getPlayerName(1));
			playerTag2.setSize(150, 40);
			playerTag2.setLocation(340, 600);
			playerTag2.setFont(plyrTagFont);
			playerTag2.setForeground(startWindow.getPlayerColor(1));
			add(playerTag2);
			playerCount2 = new JLabel("You have " + newGame.getPlayerAt(1).getNumOfArmies() + " units left to place!");
			playerCount2.setSize(200, 40);
			playerCount2.setLocation(290, 620);
			playerCount2.setFont(plyrCountFont);
			playerCount2.setForeground(startWindow.getPlayerColor(1));
			add(playerCount2);
			playerTag3 = new JLabel(startWindow.getPlayerName(2));
			playerTag3.setSize(150, 40);
			playerTag3.setLocation(490, 600);
			playerTag3.setFont(plyrTagFont);
			playerTag3.setForeground(startWindow.getPlayerColor(2));
			add(playerTag3);
			playerCount3 = new JLabel("You have " + newGame.getPlayerAt(2).getNumOfArmies() + " units left to place!");
			playerCount3.setSize(200, 40);
			playerCount3.setLocation(460, 620);
			playerCount3.setFont(plyrCountFont);
			playerCount3.setForeground(startWindow.getPlayerColor(2));
			add(playerCount3);
			playerTag4 = new JLabel(startWindow.getPlayerName(3));
			playerTag4.setSize(150, 40);
			playerTag4.setLocation(660, 600);
			playerTag4.setFont(plyrTagFont);
			playerTag4.setForeground(startWindow.getPlayerColor(3));
			add(playerTag4);
			playerCount4 = new JLabel("You have " + newGame.getPlayerAt(3).getNumOfArmies() + " units left to place!");
			playerCount4.setSize(200, 40);
			playerCount4.setLocation(630, 620);
			playerCount4.setFont(plyrCountFont);
			playerCount4.setForeground(startWindow.getPlayerColor(3));
			add(playerCount4);
			playerTag5 = new JLabel(startWindow.getPlayerName(4));
			playerTag5.setSize(150, 40);
			playerTag5.setLocation(830, 600);
			playerTag5.setFont(plyrTagFont);
			playerTag5.setForeground(startWindow.getPlayerColor(4));
			add(playerTag5);
			playerCount5 = new JLabel("You have " + newGame.getPlayerAt(4).getNumOfArmies() + " units left to place!");
			playerCount5.setSize(200, 40);
			playerCount5.setLocation(800, 620);
			playerCount5.setFont(plyrCountFont);
			playerCount5.setForeground(startWindow.getPlayerColor(4));
			add(playerCount5);
			playerTag6 = new JLabel(startWindow.getPlayerName(5));
			playerTag6.setSize(150, 40);
			playerTag6.setLocation(1000, 600);
			playerTag6.setFont(plyrTagFont);
			playerTag6.setForeground(startWindow.getPlayerColor(5));
			add(playerTag6);
			playerCount6 = new JLabel("You have " + newGame.getPlayerAt(5).getNumOfArmies() + " units left to place!");
			playerCount6.setSize(150, 40);
			playerCount6.setLocation(970, 620);
			playerCount6.setFont(plyrCountFont);
			playerCount6.setForeground(startWindow.getPlayerColor(5));
			add(playerCount6);
		}
		if (numberOfPlayers == 5) {
			playerTag = new JLabel(startWindow.getPlayerName(0));
			playerTag.setSize(150, 40);
			playerTag.setLocation(170, 600);
			playerTag.setFont(plyrTagFont);
			playerTag.setForeground(startWindow.getPlayerColor(0));
			add(playerTag);
			playerCount = new JLabel("You have " + newGame.getPlayerAt(0).getNumOfArmies() + " units left to place!");
			playerCount.setSize(200, 40);
			playerCount.setLocation(130, 620);
			playerCount.setFont(plyrCountFont);
			playerCount.setForeground(startWindow.getPlayerColor(0));
			add(playerCount);
			playerTag2 = new JLabel(startWindow.getPlayerName(1));
			playerTag2.setSize(150, 40);
			playerTag2.setLocation(340, 600);
			playerTag2.setFont(plyrTagFont);
			playerTag2.setForeground(startWindow.getPlayerColor(1));
			add(playerTag2);
			playerCount2 = new JLabel("You have " + newGame.getPlayerAt(1).getNumOfArmies() + " units left to place!");
			playerCount2.setSize(200, 40);
			playerCount2.setLocation(290, 620);
			playerCount2.setFont(plyrCountFont);
			playerCount2.setForeground(startWindow.getPlayerColor(1));
			add(playerCount2);
			playerTag3 = new JLabel(startWindow.getPlayerName(2));
			playerTag3.setSize(150, 40);
			playerTag3.setLocation(490, 600);
			playerTag3.setFont(plyrTagFont);
			playerTag3.setForeground(startWindow.getPlayerColor(2));
			add(playerTag3);
			playerCount3 = new JLabel("You have " + newGame.getPlayerAt(2).getNumOfArmies() + " units left to place!");
			playerCount3.setSize(200, 40);
			playerCount3.setLocation(460, 620);
			playerCount3.setFont(plyrCountFont);
			playerCount3.setForeground(startWindow.getPlayerColor(2));
			add(playerCount3);
			playerTag4 = new JLabel(startWindow.getPlayerName(3));
			playerTag4.setSize(150, 40);
			playerTag4.setLocation(660, 600);
			playerTag4.setFont(plyrTagFont);
			playerTag4.setForeground(startWindow.getPlayerColor(3));
			add(playerTag4);
			playerCount4 = new JLabel("You have " + newGame.getPlayerAt(3).getNumOfArmies() + " units left to place!");
			playerCount4.setSize(200, 40);
			playerCount4.setLocation(630, 620);
			playerCount4.setFont(plyrCountFont);
			playerCount4.setForeground(startWindow.getPlayerColor(3));
			add(playerCount4);
			playerTag5 = new JLabel(startWindow.getPlayerName(4));
			playerTag5.setSize(150, 40);
			playerTag5.setLocation(830, 600);
			playerTag5.setFont(plyrTagFont);
			playerTag5.setForeground(startWindow.getPlayerColor(4));
			add(playerTag5);
			playerCount5 = new JLabel("You have " + newGame.getPlayerAt(4).getNumOfArmies() + " units left to place!");
			playerCount5.setSize(200, 40);
			playerCount5.setLocation(800, 620);
			playerCount5.setFont(plyrCountFont);
			playerCount5.setForeground(startWindow.getPlayerColor(4));
			add(playerCount5);
		}
		if (numberOfPlayers == 4) {
			playerTag = new JLabel(startWindow.getPlayerName(0));
			playerTag.setSize(150, 40);
			playerTag.setLocation(170, 600);
			playerTag.setFont(plyrTagFont);
			playerTag.setForeground(startWindow.getPlayerColor(0));
			add(playerTag);
			playerCount = new JLabel("You have " + newGame.getPlayerAt(0).getNumOfArmies() + " units left to place!");
			playerCount.setSize(200, 40);
			playerCount.setLocation(130, 620);
			playerCount.setFont(plyrCountFont);
			playerCount.setForeground(startWindow.getPlayerColor(0));
			add(playerCount);
			playerTag2 = new JLabel(startWindow.getPlayerName(1));
			playerTag2.setSize(150, 40);
			playerTag2.setLocation(340, 600);
			playerTag2.setFont(plyrTagFont);
			playerTag2.setForeground(startWindow.getPlayerColor(1));
			add(playerTag2);
			playerCount2 = new JLabel("You have " + newGame.getPlayerAt(1).getNumOfArmies() + " units left to place!");
			playerCount2.setSize(200, 40);
			playerCount2.setLocation(290, 620);
			playerCount2.setFont(plyrCountFont);
			playerCount2.setForeground(startWindow.getPlayerColor(1));
			add(playerCount2);
			playerTag3 = new JLabel(startWindow.getPlayerName(2));
			playerTag3.setSize(150, 40);
			playerTag3.setLocation(490, 600);
			playerTag3.setFont(plyrTagFont);
			playerTag3.setForeground(startWindow.getPlayerColor(2));
			add(playerTag3);
			playerCount3 = new JLabel("You have " + newGame.getPlayerAt(2).getNumOfArmies() + " units left to place!");
			playerCount3.setSize(200, 40);
			playerCount3.setLocation(460, 620);
			playerCount3.setFont(plyrCountFont);
			playerCount3.setForeground(startWindow.getPlayerColor(2));
			add(playerCount3);
			playerTag4 = new JLabel(startWindow.getPlayerName(3));
			playerTag4.setSize(150, 40);
			playerTag4.setLocation(660, 600);
			playerTag4.setFont(plyrTagFont);
			playerTag4.setForeground(startWindow.getPlayerColor(3));
			add(playerTag4);
			playerCount4 = new JLabel("You have " + newGame.getPlayerAt(3).getNumOfArmies() + " units left to place!");
			playerCount4.setSize(200, 40);
			playerCount4.setLocation(630, 620);
			playerCount4.setFont(plyrCountFont);
			playerCount4.setForeground(startWindow.getPlayerColor(3));
			add(playerCount4);
		}
		if (numberOfPlayers == 3) {
			playerTag = new JLabel(startWindow.getPlayerName(0));
			playerTag.setSize(150, 40);
			playerTag.setLocation(170, 600);
			playerTag.setFont(plyrTagFont);
			playerTag.setForeground(startWindow.getPlayerColor(0));
			add(playerTag);
			playerCount = new JLabel("You have " + newGame.getPlayerAt(0).getNumOfArmies() + " units left to place!");
			playerCount.setSize(200, 40);
			playerCount.setLocation(130, 620);
			playerCount.setFont(plyrCountFont);
			playerCount.setForeground(startWindow.getPlayerColor(0));
			add(playerCount);
			playerTag2 = new JLabel(startWindow.getPlayerName(1));
			playerTag2.setSize(150, 40);
			playerTag2.setLocation(340, 600);
			playerTag2.setFont(plyrTagFont);
			playerTag2.setForeground(startWindow.getPlayerColor(1));
			add(playerTag2);
			playerCount2 = new JLabel("You have " + newGame.getPlayerAt(1).getNumOfArmies() + " units left to place!");
			playerCount2.setSize(200, 40);
			playerCount2.setLocation(290, 620);
			playerCount2.setFont(plyrCountFont);
			playerCount2.setForeground(startWindow.getPlayerColor(1));
			add(playerCount2);
			playerTag3 = new JLabel(startWindow.getPlayerName(2));
			playerTag3.setSize(150, 40);
			playerTag3.setLocation(490, 600);
			playerTag3.setFont(plyrTagFont);
			playerTag3.setForeground(startWindow.getPlayerColor(2));
			add(playerTag3);
			playerCount3 = new JLabel("You have " + newGame.getPlayerAt(2).getNumOfArmies() + " units left to place!");
			playerCount3.setSize(200, 40);
			playerCount3.setLocation(460, 620);
			playerCount3.setFont(plyrCountFont);
			playerCount3.setForeground(startWindow.getPlayerColor(2));
			add(playerCount3);
		}
		if (numberOfPlayers == 2) {
			playerTag = new JLabel(startWindow.getPlayerName(0));
			playerTag.setSize(150, 40);
			playerTag.setLocation(170, 600);
			playerTag.setFont(plyrTagFont);
			playerTag.setForeground(startWindow.getPlayerColor(0));
			add(playerTag);
			playerCount = new JLabel("You have " + newGame.getPlayerAt(0).getNumOfArmies() + " units left to place!");
			playerCount.setSize(200, 40);
			playerCount.setLocation(130, 620);
			playerCount.setFont(plyrCountFont);
			playerCount.setForeground(startWindow.getPlayerColor(0));
			add(playerCount);
			playerTag2 = new JLabel(startWindow.getPlayerName(1));
			playerTag2.setSize(150, 40);
			playerTag2.setLocation(340, 600);
			playerTag2.setFont(plyrTagFont);
			playerTag2.setForeground(startWindow.getPlayerColor(1));
			add(playerTag2);
			playerCount2 = new JLabel("You have " + newGame.getPlayerAt(1).getNumOfArmies() + " units left to place!");
			playerCount2.setSize(200, 40);
			playerCount2.setLocation(290, 620);
			playerCount2.setFont(plyrCountFont);
			playerCount2.setForeground(startWindow.getPlayerColor(1));
			add(playerCount2);
		}
	}

	public void startNewGame() {
		newGame = new GameLogic(startWindow.playerOne, startWindow.playerTwo, startWindow.playerThree,
				startWindow.playerFour, startWindow.playerFive, startWindow.playerSix);
		CardCollection newDeck = new CardCollection();
		newDeck.shuffle();

		if (startWindow.getNumberOfPlayer() == 6) {
			newGame.addPlayers(startWindow.playerOne);
			newGame.addPlayers(startWindow.playerTwo);
			newGame.addPlayers(startWindow.playerThree);
			newGame.addPlayers(startWindow.playerFour);
			newGame.addPlayers(startWindow.playerFive);
			newGame.addPlayers(startWindow.playerSix);

			player1 = newGame.getPlayerAt(0);
			player2 = newGame.getPlayerAt(1);
			player3 = newGame.getPlayerAt(2);
			player4 = newGame.getPlayerAt(3);
			player5 = newGame.getPlayerAt(4);
			player6 = newGame.getPlayerAt(5);
		}
		if (startWindow.getNumberOfPlayer() == 5) {
			newGame.addPlayers(startWindow.playerOne);
			newGame.addPlayers(startWindow.playerTwo);
			newGame.addPlayers(startWindow.playerThree);
			newGame.addPlayers(startWindow.playerFour);
			newGame.addPlayers(startWindow.playerFive);

			player1 = newGame.getPlayerAt(0);
			player2 = newGame.getPlayerAt(1);
			player3 = newGame.getPlayerAt(2);
			player4 = newGame.getPlayerAt(3);
			player5 = newGame.getPlayerAt(4);

		}
		if (startWindow.getNumberOfPlayer() == 4) {
			newGame.addPlayers(startWindow.playerOne);
			newGame.addPlayers(startWindow.playerTwo);
			newGame.addPlayers(startWindow.playerThree);
			newGame.addPlayers(startWindow.playerFour);

			player1 = newGame.getPlayerAt(0);
			player2 = newGame.getPlayerAt(1);
			player3 = newGame.getPlayerAt(2);
			player4 = newGame.getPlayerAt(3);

		}
		if (startWindow.getNumberOfPlayer() == 3) {
			newGame.addPlayers(startWindow.playerOne);
			newGame.addPlayers(startWindow.playerTwo);
			newGame.addPlayers(startWindow.playerThree);

			player1 = newGame.getPlayerAt(0);
			player2 = newGame.getPlayerAt(1);
			player3 = newGame.getPlayerAt(2);

		}
		if (startWindow.getNumberOfPlayer() == 2) {
			newGame.addPlayers(startWindow.playerOne);
			newGame.addPlayers(startWindow.playerTwo);

			player1 = newGame.getPlayerAt(0);
			player2 = newGame.getPlayerAt(1);

		}

		newGame.startGame();

	}

	public void addButtons() {

		gray = new ImageIcon("./Pictures/circle.png");
		red = new ImageIcon("./Pictures/rcircle.png");
		blue = new ImageIcon("./Pictures/bcircle.png");
		purple = new ImageIcon("./Pictures/pcircle.png");
		orange = new ImageIcon("./Pictures/ocircle.png");
		yellow = new ImageIcon("./Pictures/ycircle.png");
		green = new ImageIcon("./Pictures/gcircle.png");
		Font font = new Font("Serif", Font.BOLD, 20);
	

		if (startWindow.getNumberOfPlayer() == 6) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(yellow);
					wilmaWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(yellow);
					zonaWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(yellow);
					wilberWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(yellow);
					richWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(yellow);
					millerWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(yellow);
					mckaleWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(yellow);
					scoobyWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(yellow);
					javaLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(yellow);
					pythonLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(yellow);
					cLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(yellow);
					sqlLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(yellow);
					rubyLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(yellow);
					perlLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(yellow);
					gitLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(yellow);
					papajohnsPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(yellow);
					dominosPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(yellow);
					pizzahutPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(yellow);
					blackjackPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(yellow);
					hungryhowiesPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(yellow);
					brooklynPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(yellow);
					pizzaplanetPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(yellow);
					rawrvilleDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(yellow);
					laieggesDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(yellow);
					dactilitoDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(yellow);
					dirtydanDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(yellow);
					blackbeardDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(yellow);
					monisaurusDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(yellow);
					toystoryDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(yellow);
					scraptopiaCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(yellow);
					landofzachCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(yellow);
					giantCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(yellow);
					newlandofzachCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(yellow);
					southscraptopiaCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(yellow);
					bloobawlCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(yellow);
					cresentcaptitalCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(yellow);
					apolloSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(yellow);
					raSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(yellow);
					heliosSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(yellow);
					intiSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(yellow);
					horusSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(yellow);
					tonatiuhSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(yellow);
					amunSun.setName(startWindow.getPlayerName(0));
				}

			}

			for (Territory d : player2.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(green);
					wilmaWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(green);
					zonaWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(green);
					wilberWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(green);
					richWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(green);
					millerWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(green);
					mckaleWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(green);
					scoobyWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(green);
					javaLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(green);
					pythonLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(green);
					cLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(green);
					sqlLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(green);
					rubyLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(green);
					perlLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(green);
					gitLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(green);
					papajohnsPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(green);
					dominosPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(green);
					pizzahutPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(green);
					blackjackPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(green);
					hungryhowiesPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(green);
					brooklynPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(green);
					pizzaplanetPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(green);
					rawrvilleDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(green);
					laieggesDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(green);
					dactilitoDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(green);
					dirtydanDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(green);
					blackbeardDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(green);
					monisaurusDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(green);
					toystoryDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(green);
					scraptopiaCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(green);
					landofzachCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(green);
					giantCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(green);
					newlandofzachCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(green);
					southscraptopiaCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(green);
					bloobawlCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(green);
					cresentcaptitalCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(green);
					apolloSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(green);
					raSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(green);
					heliosSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(green);
					intiSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(green);
					horusSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(green);
					tonatiuhSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(green);
					amunSun.setName(startWindow.getPlayerName(1));
				}
			}
			for (Territory d : player3.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(orange);
					wilmaWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(orange);
					zonaWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(orange);
					wilberWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(orange);
					richWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(orange);
					millerWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(orange);
					mckaleWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(orange);
					scoobyWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(orange);
					javaLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(orange);
					pythonLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(orange);
					cLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(orange);
					sqlLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(orange);
					rubyLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(orange);
					perlLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(orange);
					gitLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(orange);
					papajohnsPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(orange);
					dominosPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(orange);
					pizzahutPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(orange);
					blackjackPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(orange);
					hungryhowiesPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(orange);
					brooklynPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(orange);
					pizzaplanetPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(orange);
					rawrvilleDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(orange);
					laieggesDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(orange);
					dactilitoDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(orange);
					dirtydanDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(orange);
					blackbeardDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(orange);
					monisaurusDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(orange);
					toystoryDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(orange);
					scraptopiaCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(orange);
					landofzachCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(orange);
					giantCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(orange);
					newlandofzachCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(orange);
					southscraptopiaCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(orange);
					bloobawlCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(orange);
					cresentcaptitalCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(orange);
					apolloSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(orange);
					raSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(orange);
					heliosSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(orange);
					intiSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(orange);
					horusSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(orange);
					tonatiuhSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(orange);
					amunSun.setName(startWindow.getPlayerName(2));
				}
			}

			for (Territory d : player4.getTerritories()) {

				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(red);
					wilmaWildcat.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(red);
					zonaWildcat.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(red);
					wilberWildcat.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(red);
					richWildcat.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(red);
					millerWildcat.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(red);
					mckaleWildcat.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(red);
					scoobyWildcat.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(red);
					javaLanguage.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(red);
					pythonLanguage.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(red);
					cLanguage.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(red);
					sqlLanguage.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(red);
					rubyLanguage.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(red);
					perlLanguage.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(red);
					gitLanguage.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(red);
					papajohnsPizza.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(red);
					dominosPizza.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(red);
					pizzahutPizza.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(red);
					blackjackPizza.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(red);
					hungryhowiesPizza.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(red);
					brooklynPizza.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(red);
					pizzaplanetPizza.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(red);
					rawrvilleDino.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(red);
					laieggesDino.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(red);
					dactilitoDino.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(red);
					dirtydanDino.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(red);
					blackbeardDino.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(red);
					monisaurusDino.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(red);
					toystoryDino.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(red);
					scraptopiaCresent.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(red);
					landofzachCresent.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(red);
					giantCresent.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(red);
					newlandofzachCresent.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(red);
					southscraptopiaCresent.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(red);
					bloobawlCresent.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(red);
					cresentcaptitalCresent.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(red);
					apolloSun.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(red);
					raSun.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(red);
					heliosSun.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(red);
					intiSun.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(red);
					horusSun.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(red);
					tonatiuhSun.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(red);
					amunSun.setName(startWindow.getPlayerName(3));
				}
			}

			for (Territory d : player5.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(purple);
					wilmaWildcat.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(purple);
					zonaWildcat.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(purple);
					wilberWildcat.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(purple);
					richWildcat.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(purple);
					millerWildcat.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(purple);
					mckaleWildcat.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(purple);
					scoobyWildcat.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(purple);
					javaLanguage.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(purple);
					pythonLanguage.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(purple);
					cLanguage.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(purple);
					sqlLanguage.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(purple);
					rubyLanguage.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(purple);
					perlLanguage.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(purple);
					gitLanguage.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(purple);
					papajohnsPizza.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(purple);
					dominosPizza.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(purple);
					pizzahutPizza.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(purple);
					blackjackPizza.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(purple);
					hungryhowiesPizza.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(purple);
					brooklynPizza.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(purple);
					pizzaplanetPizza.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(purple);
					rawrvilleDino.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(purple);
					laieggesDino.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(purple);
					dactilitoDino.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(purple);
					dirtydanDino.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(purple);
					blackbeardDino.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(purple);
					monisaurusDino.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(purple);
					toystoryDino.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(purple);
					scraptopiaCresent.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(purple);
					landofzachCresent.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(purple);
					giantCresent.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(purple);
					newlandofzachCresent.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(purple);
					southscraptopiaCresent.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(purple);
					bloobawlCresent.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(purple);
					cresentcaptitalCresent.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(purple);
					apolloSun.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(purple);
					raSun.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(purple);
					heliosSun.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(purple);
					intiSun.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(purple);
					horusSun.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(purple);
					tonatiuhSun.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(purple);
					amunSun.setName(startWindow.getPlayerName(4));
				}
			}

			for (Territory d : player6.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(blue);
					wilmaWildcat.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(blue);
					zonaWildcat.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(blue);
					wilberWildcat.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(blue);
					richWildcat.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(blue);
					millerWildcat.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(blue);
					mckaleWildcat.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(blue);
					scoobyWildcat.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(blue);
					javaLanguage.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(blue);
					pythonLanguage.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(blue);
					cLanguage.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(blue);
					sqlLanguage.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(blue);
					rubyLanguage.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(blue);
					perlLanguage.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(blue);
					gitLanguage.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(blue);
					papajohnsPizza.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(blue);
					dominosPizza.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(blue);
					pizzahutPizza.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(blue);
					blackjackPizza.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(blue);
					hungryhowiesPizza.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(blue);
					brooklynPizza.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(blue);
					pizzaplanetPizza.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(blue);
					rawrvilleDino.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(blue);
					laieggesDino.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(blue);
					dactilitoDino.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(blue);
					dirtydanDino.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(blue);
					blackbeardDino.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(blue);
					monisaurusDino.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(blue);
					toystoryDino.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(blue);
					scraptopiaCresent.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(blue);
					landofzachCresent.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(blue);
					giantCresent.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(blue);
					newlandofzachCresent.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(blue);
					southscraptopiaCresent.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(blue);
					bloobawlCresent.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(blue);
					cresentcaptitalCresent.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(blue);
					apolloSun.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(blue);
					raSun.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(blue);
					heliosSun.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(blue);
					intiSun.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(blue);
					horusSun.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(blue);
					tonatiuhSun.setName(startWindow.getPlayerName(5));
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(blue);
					amunSun.setName(startWindow.getPlayerName(5));
				}
			}
		}
		if (startWindow.getNumberOfPlayer() == 5) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(yellow);
					wilmaWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(yellow);
					zonaWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(yellow);
					wilberWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(yellow);
					richWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(yellow);
					millerWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(yellow);
					mckaleWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(yellow);
					scoobyWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(yellow);
					javaLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(yellow);
					pythonLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(yellow);
					cLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(yellow);
					sqlLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(yellow);
					rubyLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(yellow);
					perlLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(yellow);
					gitLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(yellow);
					papajohnsPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(yellow);
					dominosPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(yellow);
					pizzahutPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(yellow);
					blackjackPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(yellow);
					hungryhowiesPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(yellow);
					brooklynPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(yellow);
					pizzaplanetPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(yellow);
					rawrvilleDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(yellow);
					laieggesDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(yellow);
					dactilitoDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(yellow);
					dirtydanDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(yellow);
					blackbeardDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(yellow);
					monisaurusDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(yellow);
					toystoryDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(yellow);
					scraptopiaCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(yellow);
					landofzachCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(yellow);
					giantCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(yellow);
					newlandofzachCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(yellow);
					southscraptopiaCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(yellow);
					bloobawlCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(yellow);
					cresentcaptitalCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(yellow);
					apolloSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(yellow);
					raSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(yellow);
					heliosSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(yellow);
					intiSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(yellow);
					horusSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(yellow);
					tonatiuhSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(yellow);
					amunSun.setName(startWindow.getPlayerName(0));
				}

			}

			for (Territory d : player2.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(green);
					wilmaWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(green);
					zonaWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(green);
					wilberWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(green);
					richWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(green);
					millerWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(green);
					mckaleWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(green);
					scoobyWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(green);
					javaLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(green);
					pythonLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(green);
					cLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(green);
					sqlLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(green);
					rubyLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(green);
					perlLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(green);
					gitLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(green);
					papajohnsPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(green);
					dominosPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(green);
					pizzahutPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(green);
					blackjackPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(green);
					hungryhowiesPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(green);
					brooklynPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(green);
					pizzaplanetPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(green);
					rawrvilleDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(green);
					laieggesDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(green);
					dactilitoDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(green);
					dirtydanDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(green);
					blackbeardDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(green);
					monisaurusDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(green);
					toystoryDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(green);
					scraptopiaCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(green);
					landofzachCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(green);
					giantCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(green);
					newlandofzachCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(green);
					southscraptopiaCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(green);
					bloobawlCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(green);
					cresentcaptitalCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(green);
					apolloSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(green);
					raSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(green);
					heliosSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(green);
					intiSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(green);
					horusSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(green);
					tonatiuhSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(green);
					amunSun.setName(startWindow.getPlayerName(1));
				}
			}
			for (Territory d : player3.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(orange);
					wilmaWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(orange);
					zonaWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(orange);
					wilberWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(orange);
					richWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(orange);
					millerWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(orange);
					mckaleWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(orange);
					scoobyWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(orange);
					javaLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(orange);
					pythonLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(orange);
					cLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(orange);
					sqlLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(orange);
					rubyLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(orange);
					perlLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(orange);
					gitLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(orange);
					papajohnsPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(orange);
					dominosPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(orange);
					pizzahutPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(orange);
					blackjackPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(orange);
					hungryhowiesPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(orange);
					brooklynPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(orange);
					pizzaplanetPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(orange);
					rawrvilleDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(orange);
					laieggesDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(orange);
					dactilitoDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(orange);
					dirtydanDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(orange);
					blackbeardDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(orange);
					monisaurusDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(orange);
					toystoryDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(orange);
					scraptopiaCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(orange);
					landofzachCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(orange);
					giantCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(orange);
					newlandofzachCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(orange);
					southscraptopiaCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(orange);
					bloobawlCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(orange);
					cresentcaptitalCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(orange);
					apolloSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(orange);
					raSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(orange);
					heliosSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(orange);
					intiSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(orange);
					horusSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(orange);
					tonatiuhSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(orange);
					amunSun.setName(startWindow.getPlayerName(2));
				}
			}

			for (Territory d : player4.getTerritories()) {

				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(red);
					wilmaWildcat.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(red);
					zonaWildcat.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(red);
					wilberWildcat.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(red);
					richWildcat.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(red);
					millerWildcat.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(red);
					mckaleWildcat.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(red);
					scoobyWildcat.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(red);
					javaLanguage.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(red);
					pythonLanguage.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(red);
					cLanguage.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(red);
					sqlLanguage.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(red);
					rubyLanguage.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(red);
					perlLanguage.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(red);
					gitLanguage.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(red);
					papajohnsPizza.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(red);
					dominosPizza.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(red);
					pizzahutPizza.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(red);
					blackjackPizza.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(red);
					hungryhowiesPizza.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(red);
					brooklynPizza.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(red);
					pizzaplanetPizza.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(red);
					rawrvilleDino.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(red);
					laieggesDino.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(red);
					dactilitoDino.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(red);
					dirtydanDino.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(red);
					blackbeardDino.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(red);
					monisaurusDino.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(red);
					toystoryDino.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(red);
					scraptopiaCresent.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(red);
					landofzachCresent.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(red);
					giantCresent.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(red);
					newlandofzachCresent.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(red);
					southscraptopiaCresent.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(red);
					bloobawlCresent.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(red);
					cresentcaptitalCresent.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(red);
					apolloSun.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(red);
					raSun.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(red);
					heliosSun.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(red);
					intiSun.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(red);
					horusSun.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(red);
					tonatiuhSun.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(red);
					amunSun.setName(startWindow.getPlayerName(3));
				}
			}

			for (Territory d : player5.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(purple);
					wilmaWildcat.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(purple);
					zonaWildcat.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(purple);
					wilberWildcat.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(purple);
					richWildcat.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(purple);
					millerWildcat.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(purple);
					mckaleWildcat.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(purple);
					scoobyWildcat.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(purple);
					javaLanguage.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(purple);
					pythonLanguage.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(purple);
					cLanguage.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(purple);
					sqlLanguage.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(purple);
					rubyLanguage.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(purple);
					perlLanguage.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(purple);
					gitLanguage.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(purple);
					papajohnsPizza.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(purple);
					dominosPizza.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(purple);
					pizzahutPizza.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(purple);
					blackjackPizza.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(purple);
					hungryhowiesPizza.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(purple);
					brooklynPizza.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(purple);
					pizzaplanetPizza.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(purple);
					rawrvilleDino.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(purple);
					laieggesDino.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(purple);
					dactilitoDino.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(purple);
					dirtydanDino.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(purple);
					blackbeardDino.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(purple);
					monisaurusDino.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(purple);
					toystoryDino.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(purple);
					scraptopiaCresent.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(purple);
					landofzachCresent.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(purple);
					giantCresent.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(purple);
					newlandofzachCresent.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(purple);
					southscraptopiaCresent.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(purple);
					bloobawlCresent.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(purple);
					cresentcaptitalCresent.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(purple);
					apolloSun.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(purple);
					raSun.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(purple);
					heliosSun.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(purple);
					intiSun.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(purple);
					horusSun.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(purple);
					tonatiuhSun.setName(startWindow.getPlayerName(4));
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(purple);
					amunSun.setName(startWindow.getPlayerName(4));
				}
			}
		}
		if (startWindow.getNumberOfPlayer() == 4) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(yellow);
					wilmaWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(yellow);
					zonaWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(yellow);
					wilberWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(yellow);
					richWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(yellow);
					millerWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(yellow);
					mckaleWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(yellow);
					scoobyWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(yellow);
					javaLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(yellow);
					pythonLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(yellow);
					cLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(yellow);
					sqlLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(yellow);
					rubyLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(yellow);
					perlLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(yellow);
					gitLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(yellow);
					papajohnsPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(yellow);
					dominosPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(yellow);
					pizzahutPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(yellow);
					blackjackPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(yellow);
					hungryhowiesPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(yellow);
					brooklynPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(yellow);
					pizzaplanetPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(yellow);
					rawrvilleDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(yellow);
					laieggesDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(yellow);
					dactilitoDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(yellow);
					dirtydanDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(yellow);
					blackbeardDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(yellow);
					monisaurusDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(yellow);
					toystoryDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(yellow);
					scraptopiaCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(yellow);
					landofzachCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(yellow);
					giantCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(yellow);
					newlandofzachCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(yellow);
					southscraptopiaCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(yellow);
					bloobawlCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(yellow);
					cresentcaptitalCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(yellow);
					apolloSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(yellow);
					raSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(yellow);
					heliosSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(yellow);
					intiSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(yellow);
					horusSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(yellow);
					tonatiuhSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(yellow);
					amunSun.setName(startWindow.getPlayerName(0));
				}

			}

			for (Territory d : player2.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(green);
					wilmaWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(green);
					zonaWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(green);
					wilberWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(green);
					richWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(green);
					millerWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(green);
					mckaleWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(green);
					scoobyWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(green);
					javaLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(green);
					pythonLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(green);
					cLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(green);
					sqlLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(green);
					rubyLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(green);
					perlLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(green);
					gitLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(green);
					papajohnsPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(green);
					dominosPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(green);
					pizzahutPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(green);
					blackjackPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(green);
					hungryhowiesPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(green);
					brooklynPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(green);
					pizzaplanetPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(green);
					rawrvilleDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(green);
					laieggesDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(green);
					dactilitoDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(green);
					dirtydanDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(green);
					blackbeardDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(green);
					monisaurusDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(green);
					toystoryDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(green);
					scraptopiaCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(green);
					landofzachCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(green);
					giantCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(green);
					newlandofzachCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(green);
					southscraptopiaCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(green);
					bloobawlCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(green);
					cresentcaptitalCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(green);
					apolloSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(green);
					raSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(green);
					heliosSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(green);
					intiSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(green);
					horusSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(green);
					tonatiuhSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(green);
					amunSun.setName(startWindow.getPlayerName(1));
				}
			}
			for (Territory d : player3.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(orange);
					wilmaWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(orange);
					zonaWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(orange);
					wilberWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(orange);
					richWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(orange);
					millerWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(orange);
					mckaleWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(orange);
					scoobyWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(orange);
					javaLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(orange);
					pythonLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(orange);
					cLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(orange);
					sqlLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(orange);
					rubyLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(orange);
					perlLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(orange);
					gitLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(orange);
					papajohnsPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(orange);
					dominosPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(orange);
					pizzahutPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(orange);
					blackjackPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(orange);
					hungryhowiesPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(orange);
					brooklynPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(orange);
					pizzaplanetPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(orange);
					rawrvilleDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(orange);
					laieggesDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(orange);
					dactilitoDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(orange);
					dirtydanDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(orange);
					blackbeardDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(orange);
					monisaurusDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(orange);
					toystoryDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(orange);
					scraptopiaCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(orange);
					landofzachCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(orange);
					giantCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(orange);
					newlandofzachCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(orange);
					southscraptopiaCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(orange);
					bloobawlCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(orange);
					cresentcaptitalCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(orange);
					apolloSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(orange);
					raSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(orange);
					heliosSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(orange);
					intiSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(orange);
					horusSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(orange);
					tonatiuhSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(orange);
					amunSun.setName(startWindow.getPlayerName(2));
				}
			}

			for (Territory d : player4.getTerritories()) {

				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(red);
					wilmaWildcat.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(red);
					zonaWildcat.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(red);
					wilberWildcat.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(red);
					richWildcat.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(red);
					millerWildcat.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(red);
					mckaleWildcat.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(red);
					scoobyWildcat.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(red);
					javaLanguage.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(red);
					pythonLanguage.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(red);
					cLanguage.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(red);
					sqlLanguage.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(red);
					rubyLanguage.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(red);
					perlLanguage.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(red);
					gitLanguage.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(red);
					papajohnsPizza.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(red);
					dominosPizza.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(red);
					pizzahutPizza.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(red);
					blackjackPizza.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(red);
					hungryhowiesPizza.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(red);
					brooklynPizza.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(red);
					pizzaplanetPizza.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(red);
					rawrvilleDino.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(red);
					laieggesDino.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(red);
					dactilitoDino.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(red);
					dirtydanDino.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(red);
					blackbeardDino.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(red);
					monisaurusDino.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(red);
					toystoryDino.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(red);
					scraptopiaCresent.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(red);
					landofzachCresent.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(red);
					giantCresent.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(red);
					newlandofzachCresent.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(red);
					southscraptopiaCresent.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(red);
					bloobawlCresent.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(red);
					cresentcaptitalCresent.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(red);
					apolloSun.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(red);
					raSun.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(red);
					heliosSun.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(red);
					intiSun.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(red);
					horusSun.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(red);
					tonatiuhSun.setName(startWindow.getPlayerName(3));
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(red);
					amunSun.setName(startWindow.getPlayerName(3));
				}
			}

		}
		if (startWindow.getNumberOfPlayer() == 3) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(yellow);
					wilmaWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(yellow);
					zonaWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(yellow);
					wilberWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(yellow);
					richWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(yellow);
					millerWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(yellow);
					mckaleWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(yellow);
					scoobyWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(yellow);
					javaLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(yellow);
					pythonLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(yellow);
					cLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(yellow);
					sqlLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(yellow);
					rubyLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(yellow);
					perlLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(yellow);
					gitLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(yellow);
					papajohnsPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(yellow);
					dominosPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(yellow);
					pizzahutPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(yellow);
					blackjackPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(yellow);
					hungryhowiesPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(yellow);
					brooklynPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(yellow);
					pizzaplanetPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(yellow);
					rawrvilleDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(yellow);
					laieggesDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(yellow);
					dactilitoDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(yellow);
					dirtydanDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(yellow);
					blackbeardDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(yellow);
					monisaurusDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(yellow);
					toystoryDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(yellow);
					scraptopiaCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(yellow);
					landofzachCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(yellow);
					giantCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(yellow);
					newlandofzachCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(yellow);
					southscraptopiaCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(yellow);
					bloobawlCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(yellow);
					cresentcaptitalCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(yellow);
					apolloSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(yellow);
					raSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(yellow);
					heliosSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(yellow);
					intiSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(yellow);
					horusSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(yellow);
					tonatiuhSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(yellow);
					amunSun.setName(startWindow.getPlayerName(0));
				}

			}

			for (Territory d : player2.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(green);
					wilmaWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(green);
					zonaWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(green);
					wilberWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(green);
					richWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(green);
					millerWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(green);
					mckaleWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(green);
					scoobyWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(green);
					javaLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(green);
					pythonLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(green);
					cLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(green);
					sqlLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(green);
					rubyLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(green);
					perlLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(green);
					gitLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(green);
					papajohnsPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(green);
					dominosPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(green);
					pizzahutPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(green);
					blackjackPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(green);
					hungryhowiesPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(green);
					brooklynPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(green);
					pizzaplanetPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(green);
					rawrvilleDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(green);
					laieggesDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(green);
					dactilitoDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(green);
					dirtydanDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(green);
					blackbeardDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(green);
					monisaurusDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(green);
					toystoryDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(green);
					scraptopiaCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(green);
					landofzachCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(green);
					giantCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(green);
					newlandofzachCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(green);
					southscraptopiaCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(green);
					bloobawlCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(green);
					cresentcaptitalCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(green);
					apolloSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(green);
					raSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(green);
					heliosSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(green);
					intiSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(green);
					horusSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(green);
					tonatiuhSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(green);
					amunSun.setName(startWindow.getPlayerName(1));
				}
			}
			for (Territory d : player3.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(orange);
					wilmaWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(orange);
					zonaWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(orange);
					wilberWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(orange);
					richWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(orange);
					millerWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(orange);
					mckaleWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(orange);
					scoobyWildcat.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(orange);
					javaLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(orange);
					pythonLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(orange);
					cLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(orange);
					sqlLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(orange);
					rubyLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(orange);
					perlLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(orange);
					gitLanguage.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(orange);
					papajohnsPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(orange);
					dominosPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(orange);
					pizzahutPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(orange);
					blackjackPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(orange);
					hungryhowiesPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(orange);
					brooklynPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(orange);
					pizzaplanetPizza.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(orange);
					rawrvilleDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(orange);
					laieggesDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(orange);
					dactilitoDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(orange);
					dirtydanDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(orange);
					blackbeardDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(orange);
					monisaurusDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(orange);
					toystoryDino.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(orange);
					scraptopiaCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(orange);
					landofzachCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(orange);
					giantCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(orange);
					newlandofzachCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(orange);
					southscraptopiaCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(orange);
					bloobawlCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(orange);
					cresentcaptitalCresent.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(orange);
					apolloSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(orange);
					raSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(orange);
					heliosSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(orange);
					intiSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(orange);
					horusSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(orange);
					tonatiuhSun.setName(startWindow.getPlayerName(2));
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(orange);
					amunSun.setName(startWindow.getPlayerName(2));
				}
			}
		}
		if (startWindow.getNumberOfPlayer() == 2) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(yellow);
					wilmaWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(yellow);
					zonaWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(yellow);
					wilberWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(yellow);
					richWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(yellow);
					millerWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(yellow);
					mckaleWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(yellow);
					scoobyWildcat.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(yellow);
					javaLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(yellow);
					pythonLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(yellow);
					cLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(yellow);
					sqlLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(yellow);
					rubyLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(yellow);
					perlLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(yellow);
					gitLanguage.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(yellow);
					papajohnsPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(yellow);
					dominosPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(yellow);
					pizzahutPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(yellow);
					blackjackPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(yellow);
					hungryhowiesPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(yellow);
					brooklynPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(yellow);
					pizzaplanetPizza.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(yellow);
					rawrvilleDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(yellow);
					laieggesDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(yellow);
					dactilitoDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(yellow);
					dirtydanDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(yellow);
					blackbeardDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(yellow);
					monisaurusDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(yellow);
					toystoryDino.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(yellow);
					scraptopiaCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(yellow);
					landofzachCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(yellow);
					giantCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(yellow);
					newlandofzachCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(yellow);
					southscraptopiaCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(yellow);
					bloobawlCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(yellow);
					cresentcaptitalCresent.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(yellow);
					apolloSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(yellow);
					raSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(yellow);
					heliosSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(yellow);
					intiSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(yellow);
					horusSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(yellow);
					tonatiuhSun.setName(startWindow.getPlayerName(0));
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(yellow);
					amunSun.setName(startWindow.getPlayerName(0));
				}

			}

			for (Territory d : player2.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(green);
					wilmaWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(green);
					zonaWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(green);
					wilberWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(green);
					richWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(green);
					millerWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(green);
					mckaleWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(green);
					scoobyWildcat.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(green);
					javaLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(green);
					pythonLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(green);
					cLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(green);
					sqlLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(green);
					rubyLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(green);
					perlLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(green);
					gitLanguage.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(green);
					papajohnsPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(green);
					dominosPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(green);
					pizzahutPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(green);
					blackjackPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(green);
					hungryhowiesPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(green);
					brooklynPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(green);
					pizzaplanetPizza.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(green);
					rawrvilleDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(green);
					laieggesDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(green);
					dactilitoDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(green);
					dirtydanDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(green);
					blackbeardDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(green);
					monisaurusDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(green);
					toystoryDino.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(green);
					scraptopiaCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(green);
					landofzachCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(green);
					giantCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(green);
					newlandofzachCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(green);
					southscraptopiaCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(green);
					bloobawlCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(green);
					cresentcaptitalCresent.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(green);
					apolloSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(green);
					raSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(green);
					heliosSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(green);
					intiSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(green);
					horusSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(yellow);
					tonatiuhSun.setName(startWindow.getPlayerName(1));
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(green);
					amunSun.setName(startWindow.getPlayerName(1));
				}
			}

		}
currPlayer = newGame.nextPlayer();
		javaLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && javaLanguage.getName() == currPlayer.getName()) {
					javaUnits += 1;
					myLabel.setText("" + javaUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}

System.out.println(currPlayer.getName());
						currPlayer = newGame.nextPlayer();
						System.out.println(currPlayer.getName());

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}

		});

		pythonLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && pythonLanguage.getName() == currPlayer.getName()) {
					pythonUnits += 1;
					myLabel.setText("" + pythonUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}
					System.out.println(currPlayer.getName());
					currPlayer = newGame.nextPlayer();
					System.out.println(currPlayer.getName());
						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}

					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		cLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && cLanguage.getName() == currPlayer.getName()) {
					cUnits += 1;
					myLabel.setText("" + cUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}
					System.out.println(currPlayer.getName());

						currPlayer = newGame.nextPlayer();
						System.out.println(currPlayer.getName());
						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		sqlLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && sqlLanguage.getName() == currPlayer.getName()) {
					sqlUnits += 1;
					myLabel.setText("" + sqlUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		rubyLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && rubyLanguage.getName() == currPlayer.getName()) {
					rubyUnits += 1;
					myLabel.setText("" + rubyUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		gitLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && gitLanguage.getName() == currPlayer.getName()) {
					gitUnits += 1;
					myLabel.setText("" + gitUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}

						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		perlLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && perlLanguage.getName() == currPlayer.getName()) {
					perlUnits += 1;
					myLabel.setText("" + perlUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		wilberWildcat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && wilberWildcat.getName() == currPlayer.getName()) {
					wilberUnits += 1;
					myLabel.setText("" + wilberUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		wilmaWildcat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && wilmaWildcat.getName() == currPlayer.getName()) {
					wilmaUnits += 1;
					myLabel.setText("" + wilmaUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		richWildcat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && richWildcat.getName() == currPlayer.getName()) {
					richUnits += 1;
					myLabel.setText("" + richUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		millerWildcat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && millerWildcat.getName() == currPlayer.getName()) {
					millerUnits += 1;
					myLabel.setText("" + millerUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		scoobyWildcat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && scoobyWildcat.getName() == currPlayer.getName()) {
					scoobyUnits += 1;
					myLabel.setText("" + scoobyUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}

						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		mckaleWildcat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && mckaleWildcat.getName() == currPlayer.getName()) {
					mckaleUnits += 1;
					myLabel.setText("" + mckaleUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		zonaWildcat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && zonaWildcat.getName() == currPlayer.getName()) {
					zonaUnits += 1;
					myLabel.setText("" + zonaUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}

						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		papajohnsPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && papajohnsPizza.getName() == currPlayer.getName()) {
					pjUnits += 1;
					myLabel.setText("" + pjUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}

						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		dominosPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && dominosPizza.getName() == currPlayer.getName()) {
					domUnits += 1;
					myLabel.setText("" + domUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		pizzahutPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && pizzahutPizza.getName() == currPlayer.getName()) {
					phUnits += 1;
					myLabel.setText("" + phUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		blackjackPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && blackjackPizza.getName() == currPlayer.getName()) {
					bjUnits += 1;
					myLabel.setText("" + bjUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		hungryhowiesPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && hungryhowiesPizza.getName() == currPlayer.getName()) {
					hhUnits += 1;
					myLabel.setText("" + hhUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}

						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		brooklynPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && brooklynPizza.getName() == currPlayer.getName()) {
					bUnits += 1;
					myLabel.setText("" + bUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}

						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		pizzaplanetPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && pizzaplanetPizza.getName() == currPlayer.getName()) {
					ppUnits += 1;
					myLabel.setText("" + ppUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		apolloSun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && apolloSun.getName() == currPlayer.getName()) {
					apolloUnits += 1;
					myLabel.setText("" + apolloUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}

						currPlayer = newGame.nextPlayer();


					// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
				}
				checkIfReinforcementPhaseIsOver();

			}
			}	
		});
		
		raSun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && raSun.getName() == currPlayer.getName()) {
					raUnits += 1;
					myLabel.setText("" + raUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);

					}
					currPlayer = newGame.nextPlayer();
				}
					
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
	
		heliosSun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && heliosSun.getName() == currPlayer.getName()) {
					heliosUnits += 1;
					myLabel.setText("" + heliosUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		intiSun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && intiSun.getName() == currPlayer.getName()) {
					intiUnits += 1;
					myLabel.setText("" + intiUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		horusSun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && horusSun.getName() == currPlayer.getName()) {
					horusUnits += 1;
					myLabel.setText("" + horusUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}

						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		tonatiuhSun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && tonatiuhSun.getName() == currPlayer.getName()) {
					tonatiuhUnits += 1;
					myLabel.setText("" + tonatiuhUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		amunSun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && amunSun.getName() == currPlayer.getName()) {
					amunUnits += 1;
					myLabel.setText("" + amunUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		rawrvilleDino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && rawrvilleDino.getName() == currPlayer.getName()) {
					rawrUnits += 1;
					myLabel.setText("" + rawrUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}

						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		laieggesDino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && laieggesDino.getName() == currPlayer.getName()) {
					eggUnits += 1;
					myLabel.setText("" + eggUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}
					currPlayer = newGame.nextPlayer();


						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		dactilitoDino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && dactilitoDino.getName() == currPlayer.getName()) {
					dacUnits += 1;
					myLabel.setText("" + dacUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		dirtydanDino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && dirtydanDino.getName() == currPlayer.getName()) {
					danUnits += 1;
					myLabel.setText("" + danUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		blackbeardDino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && blackbeardDino.getName() == currPlayer.getName()) {
					bbUnits += 1;
					myLabel.setText("" + bbUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		monisaurusDino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && monisaurusDino.getName() == currPlayer.getName()) {
					moniUnits += 1;
					myLabel.setText("" + moniUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		toystoryDino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
				if (currPlayer.getNumOfArmies() >= 1 && toystoryDino.getName() == currPlayer.getName()) {
					tsUnits += 1;
					myLabel.setText("" + tsUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		scraptopiaCresent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {

					if (currPlayer.getNumOfArmies() >= 1 && scraptopiaCresent.getName() == currPlayer.getName()) {
						scrapUnits += 1;
						myLabel.setText("" + scrapUnits);

					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)

					}
					checkIfReinforcementPhaseIsOver();
				}

			}
		});
		landofzachCresent.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {

					if (currPlayer.getNumOfArmies() >= 1 && landofzachCresent.getName() == currPlayer.getName()) {
						zachUnits += 1;
						myLabel.setText("" + zachUnits);
					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}


						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		giantCresent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {

				if (currPlayer.getNumOfArmies() >= 1 && giantCresent.getName() == currPlayer.getName()) {
					giantUnits += 1;
					myLabel.setText("" + giantUnits);

					currPlayer.removeArmies(1);
					if (startWindow.getPlayerAt(0) == currPlayer) {
						playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(320,590);
					} else if (startWindow.getPlayerAt(1) == currPlayer) {
						playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(470,590);
					} else if (startWindow.getPlayerAt(2) == currPlayer) {
						playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(640,590);
					} else if (startWindow.getPlayerAt(3) == currPlayer) {
						playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(810,590);
					} else if (startWindow.getPlayerAt(4) == currPlayer) {
						playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(980,590);
					} else if (startWindow.getPlayerAt(5) == currPlayer) {
						playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
						turnMarker.setLocation(150,590);
					}

					currPlayer = newGame.nextPlayer();

					// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
				}
				checkIfReinforcementPhaseIsOver();
				}

			}
		});
		newlandofzachCresent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);

				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && newlandofzachCresent.getName() == currPlayer.getName()) {
						newzachUnits += 1;
						myLabel.setText("" + newzachUnits);

						currPlayer.removeArmies(1);
						if (startWindow.getPlayerAt(0) == currPlayer) {
							playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(320,590);
						} else if (startWindow.getPlayerAt(1) == currPlayer) {
							playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(470,590);
						} else if (startWindow.getPlayerAt(2) == currPlayer) {
							playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(640,590);
						} else if (startWindow.getPlayerAt(3) == currPlayer) {
							playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(810,590);
						} else if (startWindow.getPlayerAt(4) == currPlayer) {
							playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(980,590);
						} else if (startWindow.getPlayerAt(5) == currPlayer) {
							playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(150,590);
						}

						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
			}
		});
		southscraptopiaCresent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);

				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && southscraptopiaCresent.getName() == currPlayer.getName()) {
						southUnits += 1;
						myLabel.setText("" + southUnits);

						currPlayer.removeArmies(1);
						if (startWindow.getPlayerAt(0) == currPlayer) {
							playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(320,590);
						} else if (startWindow.getPlayerAt(1) == currPlayer) {
							playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(470,590);
						} else if (startWindow.getPlayerAt(2) == currPlayer) {
							playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(640,590);
						} else if (startWindow.getPlayerAt(3) == currPlayer) {
							playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(810,590);
						} else if (startWindow.getPlayerAt(4) == currPlayer) {
							playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(980,590);
						} else if (startWindow.getPlayerAt(5) == currPlayer) {
							playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(150,590);
						}

						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();

				}
			}
		});
		bloobawlCresent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);

				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && bloobawlCresent.getName() == currPlayer.getName()) {
						blooUnits += 1;
						myLabel.setText("" + blooUnits);

						currPlayer.removeArmies(1);
						if (startWindow.getPlayerAt(0) == currPlayer) {
							playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(320,590);
						} else if (startWindow.getPlayerAt(1) == currPlayer) {
							playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(470,590);
						} else if (startWindow.getPlayerAt(2) == currPlayer) {
							playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(640,590);
						} else if (startWindow.getPlayerAt(3) == currPlayer) {
							playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(810,590);
						} else if (startWindow.getPlayerAt(4) == currPlayer) {
							playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(980,590);
						} else if (startWindow.getPlayerAt(5) == currPlayer) {
							playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(150,590);
						}

						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();

				}
			}
		});
		cresentcaptitalCresent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);

				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && cresentcaptitalCresent.getName() == currPlayer.getName()) {
						capUnits += 1;
						myLabel.setText("" + capUnits);

						currPlayer.removeArmies(1);
						if (startWindow.getPlayerAt(0) == currPlayer) {
							playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(320,590);
						} else if (startWindow.getPlayerAt(1) == currPlayer) {
							playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(470,590);
						} else if (startWindow.getPlayerAt(2) == currPlayer) {
							playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(640,590);
						} else if (startWindow.getPlayerAt(3) == currPlayer) {
							playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(810,590);
						} else if (startWindow.getPlayerAt(4) == currPlayer) {
							playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(980,590);
						} else if (startWindow.getPlayerAt(5) == currPlayer) {
							playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
							turnMarker.setLocation(150,590);
						}

						currPlayer = newGame.nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();

				}
			}
		});

		/// ALL OF LAUNGUAGE***
		javaUnits = 1;
		pythonUnits = 1;
		cUnits = 1;
		sqlUnits = 1;
		rubyUnits = 1;
		gitUnits = 1;
		perlUnits = 1;

		languageLabel1 = new JLabel("" + javaUnits);
		languageLabel2 = new JLabel("" + pythonUnits);
		languageLabel3 = new JLabel("" + cUnits);
		languageLabel4 = new JLabel("" + sqlUnits);
		languageLabel5 = new JLabel("" + rubyUnits);
		languageLabel6 = new JLabel("" + gitUnits);
		languageLabel7 = new JLabel("" + perlUnits);

		javaLanguage.setSize(25, 25);
		javaLanguage.setLocation(720, 100);
		javaLanguage.setOpaque(false);
		javaLanguage.setContentAreaFilled(false);
		javaLanguage.setBorderPainted(false);

		languageLabel1.setSize(25, 25);
		languageLabel1.setFont(font);
		languageLabel1.setForeground(Color.BLACK);
		languageLabel1.setLocation(728, 103);
		languageLabel1.setOpaque(false);

		pythonLanguage.setSize(25, 25);
		pythonLanguage.setLocation(840, 85);
		pythonLanguage.setOpaque(false);
		pythonLanguage.setContentAreaFilled(false);
		pythonLanguage.setBorderPainted(false);

		languageLabel2.setSize(25, 25);
		languageLabel2.setFont(font);
		languageLabel2.setForeground(Color.BLACK);
		languageLabel2.setLocation(848, 88);
		languageLabel2.setOpaque(false);

		cLanguage.setSize(25, 25);
		cLanguage.setLocation(725, 145);
		cLanguage.setOpaque(false);
		cLanguage.setContentAreaFilled(false);
		cLanguage.setBorderPainted(false);

		languageLabel3.setSize(25, 25);
		languageLabel3.setFont(font);
		languageLabel3.setForeground(Color.BLACK);
		languageLabel3.setLocation(733, 148);
		languageLabel3.setOpaque(false);

		sqlLanguage.setSize(25, 25);
		sqlLanguage.setLocation(800, 110);
		sqlLanguage.setOpaque(false);
		sqlLanguage.setContentAreaFilled(false);
		sqlLanguage.setBorderPainted(false);

		languageLabel4.setSize(25, 25);
		languageLabel4.setFont(font);
		languageLabel4.setForeground(Color.BLACK);
		languageLabel4.setLocation(808, 113);
		languageLabel4.setOpaque(false);

		rubyLanguage.setSize(25, 25);
		rubyLanguage.setLocation(780, 165);
		rubyLanguage.setOpaque(false);
		rubyLanguage.setContentAreaFilled(false);
		rubyLanguage.setBorderPainted(false);

		languageLabel5.setSize(25, 25);
		languageLabel5.setFont(font);
		languageLabel5.setForeground(Color.BLACK);
		languageLabel5.setLocation(788, 168);
		languageLabel5.setOpaque(false);

		gitLanguage.setSize(25, 25);
		gitLanguage.setLocation(840, 140);
		gitLanguage.setOpaque(false);
		gitLanguage.setContentAreaFilled(false);
		gitLanguage.setBorderPainted(false);

		languageLabel6.setSize(25, 25);
		languageLabel6.setFont(font);
		languageLabel6.setForeground(Color.BLACK);
		languageLabel6.setLocation(848, 143);
		languageLabel6.setOpaque(false);

		perlLanguage.setSize(25, 25);
		perlLanguage.setLocation(890, 130);
		perlLanguage.setOpaque(false);
		perlLanguage.setContentAreaFilled(false);
		perlLanguage.setBorderPainted(false);

		languageLabel7.setSize(25, 25);
		languageLabel7.setFont(font);
		languageLabel7.setForeground(Color.BLACK);
		languageLabel7.setLocation(898, 133);
		languageLabel7.setOpaque(false);

		myMap = new HashMap<JButton, JLabel>();
		myMap.put(perlLanguage, languageLabel7);
		myMap.put(javaLanguage, languageLabel1);
		myMap.put(pythonLanguage, languageLabel2);
		myMap.put(cLanguage, languageLabel3);
		myMap.put(sqlLanguage, languageLabel4);
		myMap.put(rubyLanguage, languageLabel5);
		myMap.put(gitLanguage, languageLabel6);

		// ALL OF WILDCAT***
		wilberUnits = 1;
		wilmaUnits = 1;
		richUnits = 1;
		millerUnits = 1;
		scoobyUnits = 1;
		mckaleUnits = 1;
		zonaUnits = 1;

		wildcatLabel1 = new JLabel("" + wilberUnits);
		wildcatLabel2 = new JLabel("" + wilmaUnits);
		wildcatLabel3 = new JLabel("" + richUnits);
		wildcatLabel4 = new JLabel("" + millerUnits);
		wildcatLabel5 = new JLabel("" + scoobyUnits);
		wildcatLabel6 = new JLabel("" + mckaleUnits);
		wildcatLabel7 = new JLabel("" + zonaUnits);

		wilberWildcat.setSize(25, 25);
		wilberWildcat.setLocation(395, 305);
		wilberWildcat.setOpaque(false);
		wilberWildcat.setContentAreaFilled(false);
		wilberWildcat.setBorderPainted(false);

		wildcatLabel1.setSize(25, 25);
		wildcatLabel1.setFont(font);
		wildcatLabel1.setForeground(Color.BLACK);
		wildcatLabel1.setLocation(403, 308);
		wildcatLabel1.setOpaque(false);

		wilmaWildcat.setSize(25, 25);
		wilmaWildcat.setLocation(460, 300);
		wilmaWildcat.setOpaque(false);
		wilmaWildcat.setContentAreaFilled(false);
		wilmaWildcat.setBorderPainted(false);

		wildcatLabel2.setSize(25, 25);
		wildcatLabel2.setFont(font);
		wildcatLabel2.setForeground(Color.BLACK);
		wildcatLabel2.setLocation(468, 303);
		wildcatLabel2.setOpaque(false);

		richWildcat.setSize(25, 25);
		richWildcat.setLocation(520, 370);
		richWildcat.setOpaque(false);
		richWildcat.setContentAreaFilled(false);
		richWildcat.setBorderPainted(false);

		wildcatLabel3.setSize(25, 25);
		wildcatLabel3.setFont(font);
		wildcatLabel3.setForeground(Color.BLACK);
		wildcatLabel3.setLocation(528, 373);
		wildcatLabel3.setOpaque(false);

		millerWildcat.setSize(25, 25);
		millerWildcat.setLocation(560, 345);
		millerWildcat.setOpaque(false);
		millerWildcat.setContentAreaFilled(false);
		millerWildcat.setBorderPainted(false);

		wildcatLabel4.setSize(25, 25);
		wildcatLabel4.setFont(font);
		wildcatLabel4.setForeground(Color.BLACK);
		wildcatLabel4.setLocation(568, 348);
		wildcatLabel4.setOpaque(false);

		scoobyWildcat.setSize(25, 25);
		scoobyWildcat.setLocation(380, 380);
		scoobyWildcat.setOpaque(false);
		scoobyWildcat.setContentAreaFilled(false);
		scoobyWildcat.setBorderPainted(false);

		wildcatLabel5.setSize(25, 25);
		wildcatLabel5.setFont(font);
		wildcatLabel5.setForeground(Color.BLACK);
		wildcatLabel5.setLocation(388, 383);
		wildcatLabel5.setOpaque(false);

		mckaleWildcat.setSize(25, 25);
		mckaleWildcat.setLocation(450, 380);
		mckaleWildcat.setOpaque(false);
		mckaleWildcat.setContentAreaFilled(false);
		mckaleWildcat.setBorderPainted(false);

		wildcatLabel6.setSize(25, 25);
		wildcatLabel6.setFont(font);
		wildcatLabel6.setForeground(Color.BLACK);
		wildcatLabel6.setLocation(458, 383);
		wildcatLabel6.setOpaque(false);

		zonaWildcat.setSize(25, 25);
		zonaWildcat.setLocation(450, 435);
		zonaWildcat.setOpaque(false);
		zonaWildcat.setContentAreaFilled(false);
		zonaWildcat.setBorderPainted(false);

		wildcatLabel7.setSize(25, 25);
		wildcatLabel7.setFont(font);
		wildcatLabel7.setForeground(Color.BLACK);
		wildcatLabel7.setLocation(458, 438);
		wildcatLabel7.setOpaque(false);

		// myMap = new HashMap<JButton, JLabel>();
		myMap.put(wilberWildcat, wildcatLabel1);
		myMap.put(wilmaWildcat, wildcatLabel2);
		myMap.put(richWildcat, wildcatLabel3);
		myMap.put(millerWildcat, wildcatLabel4);
		myMap.put(scoobyWildcat, wildcatLabel5);
		myMap.put(mckaleWildcat, wildcatLabel6);
		myMap.put(zonaWildcat, wildcatLabel7);

		// ALL FOR PIZZA***
		pjUnits = 1;
		domUnits = 1;
		phUnits = 1;
		bjUnits = 1;
		hhUnits = 1;
		bUnits = 1;
		ppUnits = 1;

		pizzaLabel1 = new JLabel("" + pjUnits);
		pizzaLabel2 = new JLabel("" + domUnits);
		pizzaLabel3 = new JLabel("" + phUnits);
		pizzaLabel4 = new JLabel("" + bjUnits);
		pizzaLabel5 = new JLabel("" + hhUnits);
		pizzaLabel6 = new JLabel("" + bUnits);
		pizzaLabel7 = new JLabel("" + ppUnits);

		papajohnsPizza.setSize(25, 25);
		papajohnsPizza.setLocation(290, 265);
		papajohnsPizza.setOpaque(false);
		papajohnsPizza.setContentAreaFilled(false);
		papajohnsPizza.setBorderPainted(false);

		pizzaLabel1.setSize(25, 25);
		pizzaLabel1.setFont(font);
		pizzaLabel1.setForeground(Color.BLACK);
		pizzaLabel1.setLocation(298, 268);
		pizzaLabel1.setOpaque(false);

		dominosPizza.setSize(25, 25);
		dominosPizza.setLocation(360, 297);
		dominosPizza.setOpaque(false);
		dominosPizza.setContentAreaFilled(false);
		dominosPizza.setBorderPainted(false);

		pizzaLabel2.setSize(25, 25);
		pizzaLabel2.setFont(font);
		pizzaLabel2.setForeground(Color.BLACK);
		pizzaLabel2.setLocation(368, 300);
		pizzaLabel2.setOpaque(false);

		pizzahutPizza.setSize(25, 25);
		pizzahutPizza.setLocation(320, 263);
		pizzahutPizza.setOpaque(false);
		pizzahutPizza.setContentAreaFilled(false);
		pizzahutPizza.setBorderPainted(false);

		pizzaLabel3.setSize(25, 25);
		pizzaLabel3.setFont(font);
		pizzaLabel3.setForeground(Color.BLACK);
		pizzaLabel3.setLocation(328, 266);
		pizzaLabel3.setOpaque(false);

		blackjackPizza.setSize(25, 25);
		blackjackPizza.setLocation(306, 218);
		blackjackPizza.setOpaque(false);
		blackjackPizza.setContentAreaFilled(false);
		blackjackPizza.setBorderPainted(false);

		pizzaLabel4.setSize(25, 25);
		pizzaLabel4.setFont(font);
		pizzaLabel4.setForeground(Color.BLACK);
		pizzaLabel4.setLocation(315, 221);
		pizzaLabel4.setOpaque(false);

		hungryhowiesPizza.setSize(25, 25);
		hungryhowiesPizza.setLocation(368, 211);
		hungryhowiesPizza.setOpaque(false);
		hungryhowiesPizza.setContentAreaFilled(false);
		hungryhowiesPizza.setBorderPainted(false);

		pizzaLabel5.setSize(25, 25);
		pizzaLabel5.setFont(font);
		pizzaLabel5.setForeground(Color.BLACK);
		pizzaLabel5.setLocation(376, 214);
		pizzaLabel5.setOpaque(false);

		brooklynPizza.setSize(25, 25);
		brooklynPizza.setLocation(398, 234);
		brooklynPizza.setOpaque(false);
		brooklynPizza.setContentAreaFilled(false);
		brooklynPizza.setBorderPainted(false);

		pizzaLabel6.setSize(25, 25);
		pizzaLabel6.setFont(font);
		pizzaLabel6.setForeground(Color.BLACK);
		pizzaLabel6.setLocation(406, 237);
		pizzaLabel6.setOpaque(false);

		pizzaplanetPizza.setSize(25, 25);
		pizzaplanetPizza.setLocation(440, 201);
		pizzaplanetPizza.setOpaque(false);
		pizzaplanetPizza.setContentAreaFilled(false);
		pizzaplanetPizza.setBorderPainted(false);

		pizzaLabel7.setSize(25, 25);
		pizzaLabel7.setFont(font);
		pizzaLabel7.setForeground(Color.BLACK);
		pizzaLabel7.setLocation(448, 204);
		pizzaLabel7.setOpaque(false);

		// myMap = new HashMap<JButton, JLabel>();
		myMap.put(papajohnsPizza, pizzaLabel1);
		myMap.put(dominosPizza, pizzaLabel2);
		myMap.put(pizzahutPizza, pizzaLabel3);
		myMap.put(blackjackPizza, pizzaLabel4);
		myMap.put(hungryhowiesPizza, pizzaLabel5);
		myMap.put(brooklynPizza, pizzaLabel6);
		myMap.put(pizzaplanetPizza, pizzaLabel7);

		// ALL of SUNN****
		apolloUnits = 1;
		raUnits = 1;
		heliosUnits = 1;
		intiUnits = 1;
		horusUnits = 1;
		tonatiuhUnits = 1;
		amunUnits = 1;

		sunLabel1 = new JLabel("" + apolloUnits);
		sunLabel2 = new JLabel("" + raUnits);
		sunLabel3 = new JLabel("" + heliosUnits);
		sunLabel4 = new JLabel("" + intiUnits);
		sunLabel5 = new JLabel("" + horusUnits);
		sunLabel6 = new JLabel("" + tonatiuhUnits);
		sunLabel7 = new JLabel("" + amunUnits);

		apolloSun.setSize(25, 25);
		apolloSun.setLocation(460, 125);
		apolloSun.setOpaque(false);
		apolloSun.setContentAreaFilled(false);
		apolloSun.setBorderPainted(false);

		sunLabel1.setSize(25, 25);
		sunLabel1.setFont(font);
		sunLabel1.setForeground(Color.BLACK);
		sunLabel1.setLocation(468, 128);
		sunLabel1.setOpaque(false);

		raSun.setSize(25, 25);
		raSun.setLocation(530, 109);
		raSun.setOpaque(false);
		raSun.setContentAreaFilled(false);
		raSun.setBorderPainted(false);

		sunLabel2.setSize(25, 25);
		sunLabel2.setFont(font);
		sunLabel2.setForeground(Color.BLACK);
		sunLabel2.setLocation(538, 112);
		sunLabel2.setOpaque(false);

		heliosSun.setSize(25, 25);
		heliosSun.setLocation(570, 121);
		heliosSun.setOpaque(false);
		heliosSun.setContentAreaFilled(false);
		heliosSun.setBorderPainted(false);

		sunLabel3.setSize(25, 25);
		sunLabel3.setFont(font);
		sunLabel3.setForeground(Color.BLACK);
		sunLabel3.setLocation(578, 124);
		sunLabel3.setOpaque(false);

		intiSun.setSize(25, 25);
		intiSun.setLocation(565, 180);
		intiSun.setOpaque(false);
		intiSun.setContentAreaFilled(false);
		intiSun.setBorderPainted(false);

		sunLabel4.setSize(25, 25);
		sunLabel4.setFont(font);
		sunLabel4.setForeground(Color.BLACK);
		sunLabel4.setLocation(573, 183);
		sunLabel4.setOpaque(false);

		horusSun.setSize(25, 25);
		horusSun.setLocation(525, 230);
		horusSun.setOpaque(false);
		horusSun.setContentAreaFilled(false);
		horusSun.setBorderPainted(false);

		sunLabel5.setSize(25, 25);
		sunLabel5.setFont(font);
		sunLabel5.setForeground(Color.BLACK);
		sunLabel5.setLocation(533, 233);
		sunLabel5.setOpaque(false);

		tonatiuhSun.setSize(25, 25);
		tonatiuhSun.setLocation(495, 215);// *
		tonatiuhSun.setOpaque(false);
		tonatiuhSun.setContentAreaFilled(false);
		tonatiuhSun.setBorderPainted(false);

		sunLabel6.setSize(25, 25);
		sunLabel6.setFont(font);
		sunLabel6.setForeground(Color.BLACK);
		sunLabel6.setLocation(503, 218);
		sunLabel6.setOpaque(false);

		amunSun.setSize(25, 25);
		amunSun.setLocation(510, 170);// *
		amunSun.setOpaque(false);
		amunSun.setContentAreaFilled(false);
		amunSun.setBorderPainted(false);

		sunLabel7.setSize(25, 25);
		sunLabel7.setFont(font);
		sunLabel7.setForeground(Color.BLACK);
		sunLabel7.setLocation(518, 173);
		sunLabel7.setOpaque(false);

		// myMap = new HashMap<JButton, JLabel>();
		myMap.put(apolloSun, sunLabel1);
		myMap.put(raSun, sunLabel2);
		myMap.put(heliosSun, sunLabel3);
		myMap.put(intiSun, sunLabel4);
		myMap.put(horusSun, sunLabel5);
		myMap.put(tonatiuhSun, sunLabel6);
		myMap.put(amunSun, sunLabel7);

		// ALL FOR DINO***
		rawrUnits = 1;
		eggUnits = 1;
		dacUnits = 1;
		danUnits = 1;
		bbUnits = 1;
		moniUnits = 1;
		tsUnits = 1;

		dinoLabel1 = new JLabel("" + rawrUnits);
		dinoLabel2 = new JLabel("" + eggUnits);
		dinoLabel3 = new JLabel("" + dacUnits);
		dinoLabel4 = new JLabel("" + danUnits);
		dinoLabel5 = new JLabel("" + bbUnits);
		dinoLabel6 = new JLabel("" + moniUnits);
		dinoLabel7 = new JLabel("" + tsUnits);

		rawrvilleDino.setSize(25, 25);
		rawrvilleDino.setLocation(960, 224);
		rawrvilleDino.setOpaque(false);
		rawrvilleDino.setContentAreaFilled(false);
		rawrvilleDino.setBorderPainted(false);

		dinoLabel1.setSize(25, 25);
		dinoLabel1.setFont(font);
		dinoLabel1.setForeground(Color.BLACK);
		dinoLabel1.setLocation(968, 227);
		dinoLabel1.setOpaque(false);

		laieggesDino.setSize(25, 25);
		laieggesDino.setLocation(923, 241);
		laieggesDino.setOpaque(false);
		laieggesDino.setContentAreaFilled(false);
		laieggesDino.setBorderPainted(false);

		dinoLabel2.setSize(25, 25);
		dinoLabel2.setFont(font);
		dinoLabel2.setForeground(Color.BLACK);
		dinoLabel2.setLocation(931, 244);
		dinoLabel2.setOpaque(false);

		dactilitoDino.setSize(25, 25);
		dactilitoDino.setLocation(920, 325);
		dactilitoDino.setOpaque(false);
		dactilitoDino.setContentAreaFilled(false);
		dactilitoDino.setBorderPainted(false);

		dinoLabel3.setSize(25, 25);
		dinoLabel3.setFont(font);
		dinoLabel3.setForeground(Color.BLACK);
		dinoLabel3.setLocation(928, 328);
		dinoLabel3.setOpaque(false);

		dirtydanDino.setSize(25, 25);
		dirtydanDino.setLocation(868, 315);
		dirtydanDino.setOpaque(false);
		dirtydanDino.setContentAreaFilled(false);
		dirtydanDino.setBorderPainted(false);

		dinoLabel4.setSize(25, 25);
		dinoLabel4.setFont(font);
		dinoLabel4.setForeground(Color.BLACK);
		dinoLabel4.setLocation(875, 318);
		dinoLabel4.setOpaque(false);

		blackbeardDino.setSize(25, 25);
		blackbeardDino.setLocation(885, 358);
		blackbeardDino.setOpaque(false);
		blackbeardDino.setContentAreaFilled(false);
		blackbeardDino.setBorderPainted(false);

		dinoLabel5.setSize(25, 25);
		dinoLabel5.setFont(font);
		dinoLabel5.setForeground(Color.BLACK);
		dinoLabel5.setLocation(893, 361);
		dinoLabel5.setOpaque(false);

		monisaurusDino.setSize(25, 25);
		monisaurusDino.setLocation(845, 383);
		monisaurusDino.setOpaque(false);
		monisaurusDino.setContentAreaFilled(false);
		monisaurusDino.setBorderPainted(false);

		dinoLabel6.setSize(25, 25);
		dinoLabel6.setFont(font);
		dinoLabel6.setForeground(Color.BLACK);
		dinoLabel6.setLocation(853, 386);
		dinoLabel6.setOpaque(false);

		toystoryDino.setSize(25, 25);
		toystoryDino.setLocation(930, 408);
		toystoryDino.setOpaque(false);
		toystoryDino.setContentAreaFilled(false);
		toystoryDino.setBorderPainted(false);

		dinoLabel7.setSize(25, 25);
		dinoLabel7.setFont(font);
		dinoLabel7.setForeground(Color.BLACK);
		dinoLabel7.setLocation(938, 411);
		dinoLabel7.setOpaque(false);

		// myMap = new HashMap<JButton, JLabel>();
		myMap.put(rawrvilleDino, dinoLabel1);
		myMap.put(laieggesDino, dinoLabel2);
		myMap.put(dactilitoDino, dinoLabel3);
		myMap.put(dirtydanDino, dinoLabel4);
		myMap.put(blackbeardDino, dinoLabel5);
		myMap.put(monisaurusDino, dinoLabel6);
		myMap.put(toystoryDino, dinoLabel7);

		// ALL CRESENT**
		scrapUnits = 1;
		zachUnits = 1;
		giantUnits = 1;
		newzachUnits = 1;
		southUnits = 1;
		blooUnits = 1;
		capUnits = 1;

		cresentLabel1 = new JLabel("" + scrapUnits);
		cresentLabel2 = new JLabel("" + zachUnits);
		cresentLabel3 = new JLabel("" + giantUnits);
		cresentLabel4 = new JLabel("" + newzachUnits);
		cresentLabel5 = new JLabel("" + southUnits);
		cresentLabel6 = new JLabel("" + blooUnits);
		cresentLabel7 = new JLabel("" + capUnits);

		scraptopiaCresent.setSize(25, 25);
		scraptopiaCresent.setLocation(715, 334);
		scraptopiaCresent.setOpaque(false);
		scraptopiaCresent.setContentAreaFilled(false);
		scraptopiaCresent.setBorderPainted(false);

		cresentLabel1.setSize(25, 25);
		cresentLabel1.setFont(font);
		cresentLabel1.setForeground(Color.BLACK);
		cresentLabel1.setLocation(723, 337);
		cresentLabel1.setOpaque(false);

		landofzachCresent.setSize(25, 25);
		landofzachCresent.setLocation(750, 335);
		landofzachCresent.setOpaque(false);
		landofzachCresent.setContentAreaFilled(false);
		landofzachCresent.setBorderPainted(false);

		cresentLabel2.setSize(25, 25);
		cresentLabel2.setFont(font);
		cresentLabel2.setForeground(Color.BLACK);
		cresentLabel2.setLocation(758, 338);
		cresentLabel2.setOpaque(false);

		giantCresent.setSize(25, 25);
		giantCresent.setLocation(765, 298);
		giantCresent.setOpaque(false);
		giantCresent.setContentAreaFilled(false);
		giantCresent.setBorderPainted(false);

		cresentLabel3.setSize(25, 25);
		cresentLabel3.setFont(font);
		cresentLabel3.setForeground(Color.BLACK);
		cresentLabel3.setLocation(773, 301);
		cresentLabel3.setOpaque(false);

		newlandofzachCresent.setSize(25, 25);
		newlandofzachCresent.setLocation(790, 350);
		newlandofzachCresent.setOpaque(false);
		newlandofzachCresent.setContentAreaFilled(false);
		newlandofzachCresent.setBorderPainted(false);

		cresentLabel4.setSize(25, 25);
		cresentLabel4.setFont(font);
		cresentLabel4.setForeground(Color.BLACK);
		cresentLabel4.setLocation(798, 353);
		cresentLabel4.setOpaque(false);

		southscraptopiaCresent.setSize(25, 25);
		southscraptopiaCresent.setLocation(790, 320);
		southscraptopiaCresent.setOpaque(false);
		southscraptopiaCresent.setContentAreaFilled(false);
		southscraptopiaCresent.setBorderPainted(false);

		cresentLabel5.setSize(25, 25);
		cresentLabel5.setFont(font);
		cresentLabel5.setForeground(Color.BLACK);
		cresentLabel5.setLocation(798, 323);
		cresentLabel5.setOpaque(false);

		bloobawlCresent.setSize(25, 25);
		bloobawlCresent.setLocation(835, 310);
		bloobawlCresent.setOpaque(false);
		bloobawlCresent.setContentAreaFilled(false);
		bloobawlCresent.setBorderPainted(false);

		cresentLabel6.setSize(25, 25);
		cresentLabel6.setFont(font);
		cresentLabel6.setForeground(Color.BLACK);
		cresentLabel6.setLocation(843, 313);
		cresentLabel6.setOpaque(false);

		cresentcaptitalCresent.setSize(25, 25);
		cresentcaptitalCresent.setLocation(861, 285);
		cresentcaptitalCresent.setOpaque(false);
		cresentcaptitalCresent.setContentAreaFilled(false);
		cresentcaptitalCresent.setBorderPainted(false);

		cresentLabel7.setSize(25, 25);
		cresentLabel7.setFont(font);
		cresentLabel7.setForeground(Color.BLACK);
		cresentLabel7.setLocation(866, 288);
		cresentLabel7.setOpaque(false);

		// myMap = new HashMap<JButton, JLabel>();
		myMap.put(scraptopiaCresent, cresentLabel1);
		myMap.put(landofzachCresent, cresentLabel2);
		myMap.put(giantCresent, cresentLabel3);
		myMap.put(newlandofzachCresent, cresentLabel4);
		myMap.put(southscraptopiaCresent, cresentLabel5);
		myMap.put(bloobawlCresent, cresentLabel6);
		myMap.put(cresentcaptitalCresent, cresentLabel7);

		// add all lables
		this.add(languageLabel1);
		this.add(languageLabel2);
		this.add(languageLabel3);
		this.add(languageLabel4);
		this.add(languageLabel5);
		this.add(languageLabel6);
		this.add(languageLabel7);

		// add all buttons
		this.add(javaLanguage);
		this.add(pythonLanguage);
		this.add(cLanguage);
		this.add(sqlLanguage);
		this.add(rubyLanguage);
		this.add(gitLanguage);
		this.add(perlLanguage);

		// add all lables
		this.add(wildcatLabel1);
		this.add(wildcatLabel2);
		this.add(wildcatLabel3);
		this.add(wildcatLabel4);
		this.add(wildcatLabel5);
		this.add(wildcatLabel6);
		this.add(wildcatLabel7);

		// add all buttons
		this.add(wilberWildcat);
		this.add(wilmaWildcat);
		this.add(richWildcat);
		this.add(millerWildcat);
		this.add(scoobyWildcat);
		this.add(mckaleWildcat);
		this.add(zonaWildcat);

		// add all lables
		this.add(pizzaLabel1);
		this.add(pizzaLabel2);
		this.add(pizzaLabel3);
		this.add(pizzaLabel4);
		this.add(pizzaLabel5);
		this.add(pizzaLabel6);
		this.add(pizzaLabel7);

		// add all buttons
		this.add(papajohnsPizza);
		this.add(dominosPizza);
		this.add(pizzahutPizza);
		this.add(blackjackPizza);
		this.add(hungryhowiesPizza);
		this.add(brooklynPizza);
		this.add(pizzaplanetPizza);

		// add all lables
		this.add(sunLabel1);
		this.add(sunLabel2);
		this.add(sunLabel3);
		this.add(sunLabel4);
		this.add(sunLabel5);
		this.add(sunLabel6);
		this.add(sunLabel7);

		// add all buttons
		this.add(apolloSun);
		this.add(raSun);
		this.add(heliosSun);
		this.add(intiSun);
		this.add(horusSun);
		this.add(tonatiuhSun);
		this.add(amunSun);

		// add all lables
		this.add(dinoLabel1);
		this.add(dinoLabel2);
		this.add(dinoLabel3);
		this.add(dinoLabel4);
		this.add(dinoLabel5);
		this.add(dinoLabel6);
		this.add(dinoLabel7);

		// add all buttons
		this.add(rawrvilleDino);
		this.add(laieggesDino);
		this.add(dactilitoDino);
		this.add(dirtydanDino);
		this.add(blackbeardDino);
		this.add(monisaurusDino);
		this.add(toystoryDino);

		// add all lables
		this.add(cresentLabel1);
		this.add(cresentLabel2);
		this.add(cresentLabel3);
		this.add(cresentLabel4);
		this.add(cresentLabel5);
		this.add(cresentLabel6);
		this.add(cresentLabel7);

		// add all buttons
		this.add(scraptopiaCresent);
		this.add(landofzachCresent);
		this.add(giantCresent);
		this.add(newlandofzachCresent);
		this.add(southscraptopiaCresent);
		this.add(bloobawlCresent);
		this.add(cresentcaptitalCresent);

	}

	private void checkIfReinforcementPhaseIsOver() {
		int playersDone=0;
		for(int i=0; i<newGame.getNumOfPlayers(); i++)
		{
			if(newGame.getPlayerAt(i).getNumOfArmies()==0)
			{
				playersDone++;
			}
		}
		if(playersDone==newGame.getNumOfPlayers())
		{
			reinforcementPhase=false;
		}
		
	}

	private class buttonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton myButton = (JButton) e.getSource();

			JLabel myLabel = myMap.get(myButton);

			System.out.println(player1.getNumOfArmies());

			if (myLabel != null) {
				String curr = myLabel.getText();

				Integer i = new Integer(10);
				// i= Integer.getInteger(curr);
				i = Integer.parseInt(curr);

				if (i < 20) {
					myLabel.setText("" + (i + 1));
				}

			}

		}

	}

}